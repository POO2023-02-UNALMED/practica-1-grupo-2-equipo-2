/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.instalaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import gestorAplicacion.sujeto.CuentaBancaria;
import gestorAplicacion.sujeto.Paciente;
import uiMain.ConsoleColors;

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


    public String datafono(String medioDePago, String respuestaCredito, String respuestaOrganos, double costoTotalConIVA, Paciente pacienteSeleccionado, Banco bancoSeleccionado) {
        StringBuilder mensaje = new StringBuilder();
        switch (medioDePago) {
            case "DEBITO":
                if (pacienteSeleccionado.getCuentaBancaria().getSaldo() >= costoTotalConIVA) {
                // El saldo en la cuenta bancaria del paciente es suficiente
                double saldoAntesTransferencia = pacienteSeleccionado.getCuentaBancaria().getSaldo();
                     
                // Realizar la transferencia
                bancoSeleccionado.transferencia(pacienteSeleccionado, this ,costoTotalConIVA);
                
                // Actualizar el saldo después de la transferencia
                double saldoDespuesTransferencia = pacienteSeleccionado.getCuentaBancaria().getSaldo();
                
                mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                mensaje.append("Su saldo previo a la transferencia: $").append(String.format("%.2f", saldoAntesTransferencia)).append("\n").append("\n");
                mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                mensaje.append("🎀🏅 Nos complace informarle que su deuda con Athenea ha sido completamente saldada 🏅🎀").append("\n").append("\n");
                mensaje.append(ConsoleColors.BLUE_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                mensaje.append("El saldo disponible después de la transferencia es: $").append(String.format("%.2f", saldoDespuesTransferencia)).append("\n").append("\n");
                mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                mensaje.append("Le deseamos un agradable resto del día.").append("\n").append("\n");
                
                pacienteSeleccionado.marcarServiciosComoPagados();
                
                break;

                } else {
                // El saldo en la cuenta bancaria no es suficiente
                // Se evalúa si la respuesta al crédito es "S", es decir Si
                if (respuestaCredito.equals("S")) {
                    // El paciente ha respondido "S" (Sí) para sacar un crédito
                    // Verificar el estado de reporte
                    if (!pacienteSeleccionado.getCuentaBancaria().isEstadoDeReporte()) {
                        // El estado de reporte es falso, por lo que el paciente puede acceder al crédito
                        // Realizar lógica para conceder el crédito y actualizar la cuenta del paciente
                        
                    	double deudaAntesCredito = pacienteSeleccionado.getCuentaBancaria().getDeuda();
                    	
                    	double dineroNecesario = costoTotalConIVA - pacienteSeleccionado.getCuentaBancaria().getSaldo();
                        bancoSeleccionado.pedirCredito(pacienteSeleccionado ,this , dineroNecesario, costoTotalConIVA);
                        
                        double deudaDespuesCredito = pacienteSeleccionado.getCuentaBancaria().getDeuda();	
                        
                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                        mensaje.append("Como usted,").append(pacienteSeleccionado.getNombre()).append(",").append("\n");
                        mensaje.append("optó por aceptar un crédito en previsión de cualquier necesidad futura,").append("\n");
                        mensaje.append("y dado que posee un excelente historial crediticio, se le ha otorgado un crédito.").append("\n");
                        
                        mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                        mensaje.append("Su deuda con el banco antes de la operación: $").append(String.format("%.2f", deudaAntesCredito)).append("\n");
                        mensaje.append(ConsoleColors.BLUE_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                        mensaje.append("Su deuda con el banco después de la operación: $").append(String.format("%.2f", deudaDespuesCredito)).append("\n");
                        
                        mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                        mensaje.append("🎀🏅 Nos complace informarle que su deuda con Athenea ha sido completamente liquidada 🏅🎀").append("\n");
                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                        mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                        break;

                        } else {
                            // El estado de reporte es verdadero, el paciente no puede acceder al crédito
                            // Verificar la respuesta del paciente al método de pago alternativo
                            if (respuestaOrganos.equals("N")) {
                            	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                            	mensaje.append("Lamentablemente, su saldo es insuficiente, y se encuentra reportado en Datacrédito.").append("\n");
                                mensaje.append("Además, no ha accedio al método de pago alternativo, por lo tanto,").append("\n");
                                
                                mensaje.append(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                mensaje.append("👎 no es posible saldar la deuda pendiente con Athenea en este momento 👎").append("\n");
                                mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                                break;
                                } else {
                                	// El paciente accedio al plan de pago alternativo
                                	double dineroTotalDonacion = bancoSeleccionado.calcularDineroDonacionOrganos(pacienteSeleccionado);
                                	double saldoAntesTransferencia = pacienteSeleccionado.getCuentaBancaria().getSaldo();
                         
                                    bancoSeleccionado.donacion(pacienteSeleccionado, this , costoTotalConIVA);
                                    
                                    double saldoDespuesTransferencia = pacienteSeleccionado.getCuentaBancaria().getSaldo();
                                    // Calcula la diferencia entre el dinero total de la donación y el costo total con IVA
                                    double diferencia = dineroTotalDonacion - costoTotalConIVA;

                                    if (diferencia >= 0) {
                                    	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                    	mensaje.append("A pesar de que su saldo era insuficiente y se encontraba reportado en Datacrédito,").append("\n");
                                    	mensaje.append("😄 Acepto ser parte de nuestro plan alternativo de pago 😄").append("\n");
                                        mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("💉🩸 Nos complace informar el dinero total recaudado por su donación: $").append(String.format("%.2f", dineroTotalDonacion)).append("\n");
                                        mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("🎀🏅 Ha sido suficiente para pagar la deuda pendiente con Athenea 🏅🎀").append("\n");
                                        mensaje.append(ConsoleColors.BLUE_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("💱 El dinero restante, se ha consignado a su cuenta Bancanria: $").append(String.format("%.2f", diferencia)).append("\n");
                                        mensaje.append("Saldo en su cuenta bancaria: $").append(String.format("%.2f", saldoAntesTransferencia)).append("\n");
                                        mensaje.append("🤑 Nuevo saldo en su cuenta bancaria: $").append(String.format("%.2f", saldoDespuesTransferencia)).append("\n");
                                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                        mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                                        
                                        break;

                                        
                                    } else {
                                    	double dineroRestante = -1* diferencia;
                                    	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                    	mensaje.append("A pesar de que su saldo era insuficiente y se encontraba reportado en Datacrédito").append("\n");
                                    	mensaje.append("😄 Acepto ser parte de nuestro plan alternativo de pago 😄").append("\n");
                                        mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("💉🩸 Le informamos que el dinero total recaudado por su donación: $").append(String.format("%.2f", dineroTotalDonacion)).append("\n");
                                        mensaje.append(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("😮 No ha sido suficiente para pagar la deuda pendiente con Athenea 😮").append("\n");
                                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                        mensaje.append("Pero, no se preocupe, el dinero que hacia falta le ha sido otorgado").append("\n");
                                        mensaje.append("es un regalo solidario como agradecimiento por su donacion: $").append(String.format("%.2f", dineroRestante)).append("\n");
                                        mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("🎀🏅 Por lo tanto, nos complace informarle que su deuda con Athenea ha sido completamente saldada 🏅🎀");
                                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                        mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                                        
                                       break;
                                    }
                   
                                }        
                        }
                }
                        else if(respuestaCredito.equals("N")){ 
                        	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                        	mensaje.append("Lamentablemente, su saldo es insuficiente, y no accedio a un credito en caso de ser necesario").append("\n");
                            mensaje.append("Además, no ha accedio al método de pago alternativo, por lo tanto,").append("\n");
                            mensaje.append(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                            mensaje.append("👎 No es posible saldar la deuda pendiente con Athenea en este momento 👎").append("\n");
                            mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                            mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                            break;
                        }
            }

                case "CREDITO":
                    // Verificar el estado de reporte
                    if (!pacienteSeleccionado.getCuentaBancaria().isEstadoDeReporte()) {
                        // El estado de reporte es falso, por lo que el paciente puede acceder al crédito
                        // Realizar lógica para conceder el crédito y actualizar la cuenta del paciente
                    	double deudaAntesCredito = pacienteSeleccionado.getCuentaBancaria().getDeuda();
                    	
                    	double dineroNecesario = costoTotalConIVA - pacienteSeleccionado.getCuentaBancaria().getSaldo();
                        bancoSeleccionado.pedirCredito(pacienteSeleccionado ,this , dineroNecesario, costoTotalConIVA);
                        
                        double deudaDespuesCredito = pacienteSeleccionado.getCuentaBancaria().getDeuda();	
                        
                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                        mensaje.append("Como usted,").append(pacienteSeleccionado.getNombre()).append(",").append("\n");
                        mensaje.append("optó por aceptar un crédito en previsión de cualquier necesidad futura,").append("\n");
                        mensaje.append("y dado que posee un excelente historial crediticio, se le ha otorgado un crédito.").append("\n");
                        
                        mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                        mensaje.append("Su deuda con el banco antes de la operación: $").append(String.format("%.2f", deudaAntesCredito)).append("\n");
                        mensaje.append(ConsoleColors.BLUE_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                        mensaje.append("Su deuda con el banco después de la operación: $").append(String.format("%.2f", deudaDespuesCredito)).append("\n");
                        
                        mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                        mensaje.append("🎀🏅 Nos complace informarle que su deuda con Athenea ha sido completamente liquidada 🏅🎀").append("\n");
                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                        mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                        break;

                        } else {
                        	// El estado de reporte es verdadero, el paciente no puede acceder al crédito
                            // Verificar la respuesta del paciente al método de pago alternativo
                            if (respuestaOrganos.equals("N")) {
                            	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                            	mensaje.append("Lamentablemente, su saldo es insuficiente, y se encuentra reportado en Datacrédito.").append("\n");
                                mensaje.append("Además, no ha accedio al método de pago alternativo, por lo tanto,").append("\n");
                                
                                mensaje.append(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                mensaje.append("👎 no es posible saldar la deuda pendiente con Athenea en este momento 👎").append("\n");
                                mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                                break;
                                
                                } else {
                                	// El paciente accedio al plan de pago alternativo
                                	double dineroTotalDonacion = bancoSeleccionado.calcularDineroDonacionOrganos(pacienteSeleccionado);
                                	double saldoAntesTransferencia = pacienteSeleccionado.getCuentaBancaria().getSaldo();
                         
                                    bancoSeleccionado.donacion(pacienteSeleccionado, this , costoTotalConIVA);
                                    
                                    double saldoDespuesTransferencia = pacienteSeleccionado.getCuentaBancaria().getSaldo();
                                    // Calcula la diferencia entre el dinero total de la donación y el costo total con IVA
                                    double diferencia = dineroTotalDonacion - costoTotalConIVA;

                                    if (diferencia >= 0) {
                                    	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                    	mensaje.append("A pesar de que se encontraba reportado en Datacrédito").append("\n");
                                    	mensaje.append("😄 Acepto ser parte de nuestro plan alternativo de pago 😄").append("\n");
                                        mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("💉🩸 Nos complace informar el dinero total recaudado por su donación: $").append(String.format("%.2f", dineroTotalDonacion)).append("\n");
                                        mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("🎀🏅 Ha sido suficiente para pagar la deuda pendiente con Athenea 🏅🎀").append("\n");
                                        mensaje.append(ConsoleColors.BLUE_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("💱 El dinero restante, se ha consignado a su cuenta Bancanria: $").append(String.format("%.2f", diferencia)).append("\n");
                                        mensaje.append("Saldo previo en su cuenta bancaria: $").append(String.format("%.2f", saldoAntesTransferencia)).append("\n");
                                        mensaje.append("🤑 Nuevo saldo en su cuenta bancaria: $").append(String.format("%.2f", saldoDespuesTransferencia)).append("\n");
                                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                        mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                                        
                                        break;

                                        
                                    } else {
                                    	double dineroRestante = -1* diferencia;
                                    	mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                    	mensaje.append("A pesar de que se encontraba reportado en Datacrédito").append("\n");
                                    	mensaje.append("😄 Acepto ser parte de nuestro plan alternativo de pago 😄").append("\n");
                                        mensaje.append(ConsoleColors.PURPLE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("💉🩸 Le informamos que el dinero total recaudado por su donación: $").append(String.format("%.2f", dineroTotalDonacion)).append("\n");
                                        mensaje.append(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("😮 No ha sido suficiente para pagar la deuda pendiente con Athenea 😮").append("\n");
                                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                        mensaje.append("Pero, no se preocupe, el dinero que hacia falta le ha sido otorgado").append("\n");
                                        mensaje.append("es un regalo solidario como agradecimiento por su donacion: $").append(String.format("%.2f", dineroRestante)).append("\n");
                                        mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                                        mensaje.append("🎀🏅 Por lo tanto, nos complace informarle que su deuda con Athenea ha sido completamente saldada 🏅🎀");
                                        mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                                        mensaje.append("Le deseamos un agradable resto de día.").append("\n");
                                        
                                       break;
                                    }
                   
                                }
                        }
                    
                case "EFECTIVO":
                	double descuentoEfectivo = 0.30; // 30% de descuento para pago en efectivo
                    double costoConDescuentoxEfectivo = costoTotalConIVA * (1 - descuentoEfectivo);
                    bancoSeleccionado.transferencia(this, costoConDescuentoxEfectivo);
                    
                    mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                    mensaje.append("Recibimos su pago en efectivo con agradecimiento.").append("\n");
                    mensaje.append("El monto total de su factura, con un descuento del 30%, es: $").append(String.format("%.2f", costoConDescuentoxEfectivo)).append("\n");
                    mensaje.append(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT);
                    mensaje.append("🎀🏅 Su deuda con Athenea ha sido saldada 🏅🎀").append("\n");
                    mensaje.append(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                    mensaje.append("Le deseamos un excelente día y gracias por su confianza en nosotros.").append("\n");
                    break;
        
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