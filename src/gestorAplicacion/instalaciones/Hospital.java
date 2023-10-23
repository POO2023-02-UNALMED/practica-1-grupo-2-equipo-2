/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.instalaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import gestorAplicacion.sujeto.CuentaBancaria;
import gestorAplicacion.sujeto.Paciente;

/*Descripción: Esta clase se encarga de describir el funcionamiento del hospital y de tratar la lista de los pacientes que estan en el
hospital.*/
public class Hospital {
    //Atributos
    private CuentaBancaria cuentaBancaria;
    private String nombre;
    private String direcion;
    public ArrayList<Habitacion> habitaciones;
    public ArrayList<Paciente> pacientes;

    //Constructor principal
    public Hospital(String nombre,String direcion){
        this.nombre = nombre;
        this.direcion = direcion;
        this.habitaciones = new ArrayList<Habitacion>();
        this.pacientes = new ArrayList<Paciente>();
        this.cuentaBancaria = new CuentaBancaria();
    }

    // funcion que returna una habitacion si hay una habitacion libre en el hospital, sino returna NULL
    public Habitacion buscarhabitacionLibre(){
        Habitacion h = null;
        for(int i=0;i<habitaciones.size();i++){
            if(habitaciones.get(i).isOccupada() == false){
                h = habitaciones.get(i);
                i = habitaciones.size()+1;
            }
        }
        return h;
    }

    //funcion que hace el enlace entre un paciente y un habitacion
    public void anadirPaciente(Paciente p){
        this.pacientes.add(p);
        this.buscarhabitacionLibre().reservarHabitacion(p);

    }

    // fonction que returna el paciente segun su numero de Identificacion, returna null si no esta en el hospital
    public Paciente buscarPaciente(int numeroIdentificacion) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNumeroIdentificacion() == numeroIdentificacion) {
                return paciente;
            }
        }
        return null; // Retornar null si no se encuentra al paciente con el número de identificación dado
    }


    public String datafono(String medioDePago, String respuestaCredito, double costoTotalConIVA, Paciente pacienteSeleccionado, Banco bancoSeleccionado) {
        StringBuilder mensaje = new StringBuilder();
        switch (medioDePago) {
            case "DEBITO":
                if (pacienteSeleccionado.getCuentaBancaria().getSaldo() >= costoTotalConIVA) {
                // El saldo en la cuenta bancaria del paciente es suficiente
                // Realizar la transferencia
                bancoSeleccionado.transferencia(pacienteSeleccionado, this ,costoTotalConIVA);
                mensaje.append("Su saldo es suficiente");
                mensaje.append("\n");
                mensaje.append("La deuda que tiene con Athenea ha sido saldada");
                mensaje.append("\n");
                mensaje.append("Feliz resto de día");
                mensaje.append("\n");
                pacienteSeleccionado.marcarServiciosComoPagados();

                } else {
                // El saldo en la cuenta bancaria no es suficiente
                // Se evalúa si la respuesta al crédito es "S", es decir Si
                if (respuestaCredito.equals("S")) {
                    // El paciente ha respondido "S" (Sí) para sacar un crédito
                    // Verificar el estado de reporte
                    if (!pacienteSeleccionado.getCuentaBancaria().isEstadoDeReporte()) {
                        // El estado de reporte es falso, por lo que el paciente puede acceder al crédito
                        // Realizar lógica para conceder el crédito y actualizar la cuenta del paciente
                        double dineroNecesario = costoTotalConIVA - pacienteSeleccionado.getCuentaBancaria().getSaldo();
                        bancoSeleccionado.pedirCredito(pacienteSeleccionado ,this , dineroNecesario, costoTotalConIVA);
                        mensaje.append("Su saldo es insuficiente, como NO se encuentra reportado en datacredito.").append("\n");
                        mensaje.append("Y accedio a tener un credito si era necesario").append("\n");
                        mensaje.append("La deuda que tiene con Athenea ha sido saldada").append("\n");
                        mensaje.append("Feliz resto de día").append("\n");

                        } else {
                            // El estado de reporte es verdadero, el paciente no puede acceder al crédito
                            // Verificar si el hashmap organosDonar tiene algún valor nulo
                            HashMap<String, Integer> organosDonar = pacienteSeleccionado.getCuentaBancaria().getOrganosDonar();
                            if (organosDonar.values().stream().anyMatch(Objects::isNull)) {
                                // Hay algún valor nulo en el hashmap, lo que significa que el paciente no accedió al plan de pago alternativo
                                mensaje.append("Su saldo es insuficiente, y se encuentra reportado en datacredito. ").append("\n");
                                mensaje.append("Además, no accedió al método de pago alternativo").append("\n");
                                mensaje.append("por lo tanto, la deuda que tiene con Athenea no puede ser saldada. ").append("\n");
                                mensaje.append("Feliz resto de día.").append("\n");
                                } else {
                                    // El paciente accedio al plan de pago alternativo
                                    bancoSeleccionado.donacion(pacienteSeleccionado, this , costoTotalConIVA);
                                    mensaje.append("Su saldo es insuficiente y se encuentra reportado en datacredito.").append("\n");
                                    mensaje.append("Sin embargo, accedió al método de pago alternativo").append("\n");
                                    mensaje.append("por lo tanto, la deuda que tiene con Athenea ha sido saldada").append("\n");
                                    mensaje.append("Feliz resto de día").append("\n");}
                                }        
                    
                    } else if(respuestaCredito.equals("N")){ 
                        mensaje.append("Su saldo es insuficiente, y NO accedio a un credito en caso de ser necesario").append("\n"); 
                        mensaje.append("por lo tanto, la deuda que tiene con Athenea no puede ser saldada").append("\n"); 
                        mensaje.append("Feliz resto de dia").append("\n");}
            }

                case "CREDITO":
                    // Verificar el estado de reporte
                    if (!pacienteSeleccionado.getCuentaBancaria().isEstadoDeReporte()) {
                        // El estado de reporte es falso, por lo que el paciente puede acceder al crédito
                        // Realizar lógica para conceder el crédito y actualizar la cuenta del paciente
                        double dineroNecesario = costoTotalConIVA - pacienteSeleccionado.getCuentaBancaria().getSaldo();
                        bancoSeleccionado.pedirCredito(pacienteSeleccionado ,this , dineroNecesario, costoTotalConIVA);
                        mensaje.append("NO se encuentra reportado en datacredito.").append("\n");
                        mensaje.append("La deuda que tiene con Athenea ha sido saldada").append("\n");
                        mensaje.append("Feliz resto de día").append("\n");

                        } else {
                            // El estado de reporte es verdadero, el paciente no puede acceder al crédito
                            // Verificar si el hashmap organosDonar tiene algún valor nulo
                            HashMap<String, Integer> organosDonar = pacienteSeleccionado.getCuentaBancaria().getOrganosDonar();
                            if (organosDonar.values().stream().anyMatch(Objects::isNull)) {
                                // Hay algún valor nulo en el hashmap, lo que significa que el paciente no accedió al plan de pago alternativo
                                mensaje.append("Se encuentra reportado en datacredito.").append("\n");
                                mensaje.append("Además, no accedió al método de pago alternativo").append("\n");
                                mensaje.append("por lo tanto, la deuda que tiene con Athenea no puede ser saldada. ").append("\n");
                                mensaje.append("Feliz resto de día.").append("\n");
                                } else {
                                    // El paciente accedio al plan de pago alternativo
                                    bancoSeleccionado.donacion(pacienteSeleccionado, this , costoTotalConIVA);
                                    mensaje.append("Se encuentra reportado en datacredito.").append("\n");
                                    mensaje.append("Sin embargo, accedió al método de pago alternativo,").append("\n");
                                    mensaje.append("por lo tanto, la deuda que tiene con Athenea ha sido saldada");
                                    mensaje.append("Feliz resto de día");}
                            }  
                    
                case "EFECTIVO":
                    double costoConDescuentoxEfectivo = costoTotalConIVA - (costoTotalConIVA * 0.30); 
                    bancoSeleccionado.transferencia(this, costoConDescuentoxEfectivo);
                    mensaje.append("Muchas gracias por su pago").append("\n");
                    mensaje.append("Su ahorro fue: ").append(costoConDescuentoxEfectivo).append("\n");
                    mensaje.append("La deuda que tiene con Athenea ha sido saldada").append("\n");
                    mensaje.append("Feliz resto de día").append("\n");
        }
        return mensaje.toString();
    }    

    //Getters y setters

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return this.direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }
   
}