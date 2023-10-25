package gestorAplicacion.instalaciones;

import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.sujeto.Paciente;

public class Banco {
    private double cajaFuerte;
    private Map<String, Double> preciosOrganos;

    public Banco() {
        // Inicializa el diccionario de precios de órganos
        preciosOrganos = new HashMap<>();
        preciosOrganos.put("Ojo", 750000.0);
        preciosOrganos.put("Oreja", 950000.0);
        preciosOrganos.put("Porcion de higado", 1235000.0);
        preciosOrganos.put("Riñon", 1950000.0);
        preciosOrganos.put("1 extremidad inferior", 2450000.0);
        preciosOrganos.put("1 extremidad superior", 3000000.0);
        this.cajaFuerte = Double.MAX_VALUE; // Establece la caja fuerte con el valor máximo de double
    }

    // Transfiere un monto desde la cuenta del paciente a la cuenta del hospital.
    public void transferencia(Paciente paciente, Hospital hospital, double monto) {
        // Verifica que el monto sea positivo y que el paciente tenga suficientes fondos en su cuenta.
        if (monto > 0 && paciente.getCuentaBancaria().getSaldo() >= monto) {
            // Realiza el débito en la cuenta del paciente.
            paciente.getCuentaBancaria().debitar(monto);
    
            // Realiza el depósito en la cuenta del hospital.
            hospital.getCuentaBancaria().depositar(monto);
        }
    }

    // Realiza un depósito en la cuenta del hospital.
    public void transferencia(Hospital hospital, double monto){
        // Realiza un depósito en la cuenta del hospital con el monto especificado.
        hospital.getCuentaBancaria().depositar(monto);
    }


    public void pedirCredito(Paciente paciente, Hospital hospital, double dineroNecesario, double costoTotalConIVA) {
        // Resta el dinero necesario de la caja fuerte del banco
        cajaFuerte -= dineroNecesario;
        // Agrega el dinero prestado como deuda en la cuenta bancaria del paciente
        paciente.getCuentaBancaria().agregarDeuda(dineroNecesario);
        // Realiza la transferencia del dinero de la cuenta del paciente hacia la cuenta del hospital
        this.transferencia(paciente, hospital ,costoTotalConIVA);
        // Se marcan como pago todos los servicios que el paciente selecciono
        paciente.marcarServiciosComoPagados();

    }
    

    public double calcularDineroDonacionOrganos(Paciente paciente) {
        // Obtén el diccionario de precios de órganos del banco
        Map<String, Double> preciosOrganos = this.getPreciosOrganos();

        // Obtén el diccionario de órganos donados por el paciente
        Map<String, Integer> organosDonar = paciente.getCuentaBancaria().getOrganosDonar();

        double dineroTotal = 0.0;

        // Itera a través de los órganos donados
        for (Map.Entry<String, Integer> entry : organosDonar.entrySet()) {
            String organo = entry.getKey();
            int cantidadDonada = entry.getValue();

            // Verifica si el órgano existe en el diccionario de precios
            if (preciosOrganos.containsKey(organo)) {
                double precioOrgano = preciosOrganos.get(organo);
                double dineroOrgano = precioOrgano * cantidadDonada;

                dineroTotal += dineroOrgano;
            }
        }

        return dineroTotal;
    }

    public void donacion(Paciente paciente, Hospital hospital, double costoTotalConIVA) {
        // Llama al método calcularDineroDonacionOrganos para obtener el dinero total de la donación de órganos
        double dineroTotalDonacion = calcularDineroDonacionOrganos(paciente);

        // Calcula la diferencia entre el dinero total de la donación y el costo total con IVA
        double diferencia = dineroTotalDonacion - costoTotalConIVA;

        if (diferencia >= 0) {
            // Realiza la transferencia del dinero de la cuenta del paciente hacia la cuenta del hospital
            this.transferencia(paciente, hospital ,costoTotalConIVA);
            // Si el dinero de la donación cubre los costos de los servicios, marca los servicios como pagados
            paciente.marcarServiciosComoPagados();
            
            // Calcula el dinero restante
            double dineroRestante = diferencia;
            

            // Agrega el dinero restante a la cuenta bancaria del paciente
            paciente.getCuentaBancaria().depositar(dineroRestante);
        } else {
            // Si el dinero de la donación no es suficiente, marca los servicios como pagados
            // Basicamente se le regala el dinero que le hace falta
            // Un regalo solidario como agradecimiento por su donacion
        	double dineroRestante = -1* diferencia;
        	cajaFuerte -= dineroRestante;
        	double regaloSolidario = dineroRestante + dineroTotalDonacion;
            this.transferencia(hospital , regaloSolidario);
            paciente.marcarServiciosComoPagados();
        }
    }



    public double getCajaFuerte() {
        return cajaFuerte;
    }

    public void setCajaFuerte(double cajaFuerte) {
        this.cajaFuerte = cajaFuerte;
    }

    public Map<String, Double> getPreciosOrganos() {
        return preciosOrganos;
    }
}

