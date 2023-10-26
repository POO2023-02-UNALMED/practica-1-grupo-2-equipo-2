package gestorAplicacion.instalaciones;

import java.util.HashMap;
import java.util.Map;

import gestorAplicacion.sujeto.Paciente;

public class Banco {
    private double cajaFuerte;
    
    public Banco() {
        this.cajaFuerte = Double.MAX_VALUE; // Establece la caja fuerte con el valor máximo de double
    }

    public void transferencia(Paciente paciente, Hospital hospital, double monto) {
        if (monto > 0 && paciente.getCuentaBancaria().getSaldo() >= monto) {
            // Realiza el débito en la cuenta del paciente
            paciente.getCuentaBancaria().debitar(monto);
    
            // Realiza el depósito en la cuenta del hospital
            hospital.getCuentaBancaria().depositar(monto);
        }
    }

    public void transferencia (Hospital hospital, double monto){
        hospital.getCuentaBancaria().depositar(monto);
    }
    

    public void pedirCredito(Paciente paciente, Hospital hospital, double dineroNecesario, double costoTotalConIVA) {
        // Resta el dinero necesario de la caja fuerte del banco
        cajaFuerte -= dineroNecesario;
        // Agrega el dinero prestado como deuda en la cuenta bancaria del paciente
        paciente.getCuentaBancaria().agregarDeuda(dineroNecesario);
        double saldoRestar = paciente.getCuentaBancaria().getSaldo();
        paciente.getCuentaBancaria().debitar(saldoRestar);
        // Realiza la transferencia del dinero de la cuenta del paciente hacia la cuenta del hospital
        this.transferencia(hospital ,costoTotalConIVA);
        // Se marcan como pago todos los servicios que el paciente selecciono
        paciente.marcarServiciosComoPagados();

    }
    

    // Método para calcular el dinero de donación
    public double calcularDineroDonacion(Paciente paciente) {
        HashMap<Organos, Integer> donacionesPaciente = paciente.getCuentaBancaria().getOrganosDonar();
        int montoTotalDonacion = 0;

        // Recorre el mapa de donaciones del paciente
        for (Organos organo : donacionesPaciente.keySet()) {
            int cantidadDonada = donacionesPaciente.get(organo);
            int precioOrgano = organo.getPrecio();
            int montoDonadoPorOrgano = cantidadDonada * precioOrgano;
            
            // Agrega el monto donado por el órgano al monto total de donación
            montoTotalDonacion += montoDonadoPorOrgano;
        }

        return montoTotalDonacion;}

    public void donacion(Paciente paciente, Hospital hospital, double costoTotalConIVA) {
        // Llama al método calcularDineroDonacionOrganos para obtener el dinero total de la donación de órganos
        double dineroTotalDonacion = calcularDineroDonacion(paciente);

        // Calcula la diferencia entre el dinero total de la donación y el costo total con IVA
        double diferencia = dineroTotalDonacion - costoTotalConIVA;

        if (diferencia >= 0) {
            // Realiza la transferencia del dinero de la cuenta del paciente hacia la cuenta del hospital
            this.transferencia(hospital ,costoTotalConIVA);
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
}

