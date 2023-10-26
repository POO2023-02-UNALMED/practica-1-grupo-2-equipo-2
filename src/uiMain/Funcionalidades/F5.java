/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */
package uiMain.Funcionalidades;

import gestorAplicacion.instalaciones.*;
import gestorAplicacion.serviciosOfrecidos.Tratamiento;
import gestorAplicacion.sujeto.*;
import uiMain.ConsoleColors;

import java.util.Scanner;
import static uiMain.Screen.SCANNER;

public class F5 {

    private static final Scanner SCANNER_FACTURACION = SCANNER;

    public static void facturacion(Hospital hospital, Banco banco) {

    	System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.GREEN_BOLD_BRIGHT + "🧾💰 𝑩𝒊𝒆𝒏𝒗𝒆𝒏𝒊𝒅𝒐𝒔 𝒂𝒍 𝒔𝒊𝒔𝒕𝒆𝒎𝒂 𝒅𝒆 𝒑𝒂𝒈𝒐𝒔 𝒅𝒆 𝑨𝒕𝒉𝒏𝒆𝒂 💰🧾" + ConsoleColors.RESET);
    	System.out.println("\n");
    	
        // Buscar paciente
            Paciente pacienteSeleccionado;

            do {
                // Solicitar la cédula del paciente y buscarlo en el hospital
                System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT + "Por favor, ingrese la cédula del paciente 👤" + ConsoleColors.RESET);
                int cedula = Integer.parseInt(SCANNER_FACTURACION.nextLine());
                pacienteSeleccionado = hospital.buscarPaciente(cedula);
        
                if (pacienteSeleccionado == null) {
                    // Mostrar mensaje si el paciente no existe y preguntar si desea intentar de nuevo
                    System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.RED_BOLD_BRIGHT + "No existe un paciente registrado con esta cédula.\u001B[0m ¿Desea intentar de nuevo? (S/N)" + ConsoleColors.RESET);
                        if (SCANNER_FACTURACION.nextLine().equalsIgnoreCase("N")) {
                            return; // Terminar la ejecución si el usuario no desea intentar de nuevo
                        }
                    }
                } while (pacienteSeleccionado == null); // Repetir hasta que se encuentre un paciente válido
        

        /* -------------- Primera interacción: obtenerServiciosSinPagar (ubicación: Clase Paciente) --------------
        * Obtener los servicios pendientes de pago del paciente seleccionado */

        // Mostrar lista de servicios pendientes de pago
        System.out.println("\n");
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.CYAN_BOLD_BRIGHT + "⚕️ El Paciente: " + pacienteSeleccionado.getNombre());
        System.out.println("🔢 identificado por: " + pacienteSeleccionado.getNumeroIdentificacion() + ConsoleColors.RESET);
        System.out.println("\n");
        String[] serviciosSinPagar = pacienteSeleccionado.obtenerServiciosSinPagar();
        
        if (serviciosSinPagar[0].equals("No hay servicios pendientes de pago")) {
        	System.out.println(serviciosSinPagar);
        	System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT + ConsoleColors.PURPLE_BOLD_BRIGHT);
        	System.out.println("🎀 Le deseamos un agradable resto del día. 🎀");
    
        } else {
        	System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT+ ConsoleColors.RED_BOLD_BRIGHT + "😩😵 Presenta un saldo pendiente por los siguientes servicios no pagados:​ 😩😵" + ConsoleColors.RESET);
            System.out.println("\n");
            System.out.println(serviciosSinPagar[0]);

            
            /* -------------- Segunda interacción: seleccionarServiciosAPagar (ubicación: Clase Paciente) --------------
            *el paciente sleccionado, ingresa los servicios que desea pagar */

            // Información introductoria sobre descuentos
            System.out.println(ConsoleColors.GREEN_BACKGROUND + ConsoleColors.WHITE_BOLD_BRIGHT + "En AtheneaOlympicCare ofrecemos los siguientes descuentos");
            System.out.println("dependiendo de la cantidad de servicios que quiera pagar: " + ConsoleColors.RESET);
            
            // Tabla de descuentos
            System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.PURPLE_BOLD_BRIGHT);
            System.out.print("╔════════════════════════════════╤═══════════════════════════════╗\n");
            System.out.print("║  🔢 Cantidad de servicios 🔢   │  💲Porcentaje de descuento💲  ║\n");
            System.out.print("╟────────────────────────────────┼───────────────────────────────╢\n");
            System.out.print("║   		5 o más          │   		20%              ║\n");
            System.out.print("║   	       10 o más          │   		30%              ║\n");
            System.out.print("║   	       15 o más          │   		40%              ║\n");
            System.out.print("║   	       20 o más          │   	        50%              ║\n");
            System.out.print("╚════════════════════════════════╧═══════════════════════════════╝\n");
            System.out.println(ConsoleColors.RESET);

            String indicesSeleccionados = "";
            boolean numeroEncontrado = false;
            // Ingresar los índices de los servicios a pagar
            do {
                String indices = serviciosSinPagar[1];
                System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT + "Por favor, ingrese el número del servicio que desea pagar" + ConsoleColors.RESET);
                int numeroServicio = Integer.parseInt(SCANNER_FACTURACION.nextLine());
                // Dividimos la cadena de índices en un arreglo de strings
                String[] indicesArray = indices.split(" ");

                // Recorremos los índices para comprobar si el número del usuario se encuentra en alguno de ellos
                for (String indiceStr : indicesArray) {
                    int indice = Integer.parseInt(indiceStr);
                    if (indice == numeroServicio) {
                    numeroEncontrado = true;

                    // Agregar el índice a la cadena de índices seleccionados (separados por comas)
                    if (!indicesSeleccionados.isEmpty()) {
                        indicesSeleccionados += ",";
                    }
                    indicesSeleccionados += numeroServicio;
                    break;
                    }
                } // Si encontramos el número, no es necesario seguir buscando

                if (numeroEncontrado == false) {
                    // Mostrar mensaje si el indice no existe y preguntar si desea intentar de nuevo
                    System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.RED_BOLD_BRIGHT + "No existe ese número de servicio. ¿Desea intentar de nuevo? (S/N)" + ConsoleColors.RESET);
                        if (SCANNER_FACTURACION.nextLine().equalsIgnoreCase("N")) {
                            return; // Terminar la ejecución si el usuario no desea intentar de nuevo
                        }
                    }
                } while (numeroEncontrado == false); // Repetir hasta que el usuario ingrese un indice válido


            // Llamar al método seleccionarServiciosAPagar con los índices ingresados
            double[] costos = pacienteSeleccionado.seleccionarServiciosAPagar(indicesSeleccionados);

            // Imprimir la factura
            System.out.println("\n");
            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.RED_BOLD_BRIGHT);
            System.out.println(" 	   ♨️⭐Factura⭐♨️		 ");
            System.out.println("----------------------------------------");
            System.out.println(ConsoleColors.RESET);
            
            System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD);
            System.out.println(" 🩺⚕️Servicio⚕️🩺           💲Precio💲	");
            System.out.println("────────────────────────────────────────");
            System.out.println(ConsoleColors.RESET);

            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.RED_BOLD_BRIGHT);
            for (Tratamiento servicio : pacienteSeleccionado.getServiciosSeleccionados()) {
                System.out.printf(" %-25s $%.2f\n", "🔆", servicio.calcularPrecio(pacienteSeleccionado));
            }
            
            System.out.println(ConsoleColors.RESET);
            
            System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.GREEN_BOLD_BRIGHT);
            System.out.println("────────────────────────────────────────");

            double costoTotal = costos[0];
            double costoTotalConDescuento = costos[1];
            double costoTotalConIVA = costos[2];
            
            System.out.printf(" 💫 Subtotal:               $%.2f\n", costoTotal);
            System.out.printf(" 💠 Descuento:              $%.2f\n", costoTotal - costoTotalConDescuento);
            System.out.printf(" 💥 Total sin IVA:          $%.2f\n", costoTotalConDescuento);
            System.out.printf(" 🔱 IVA (19%%):              $%.2f\n", costoTotalConIVA - costoTotalConDescuento);
            System.out.printf(" 🔆 Total a pagar:          $%.2f\n", costoTotalConIVA);

            System.out.println("────────────────────────────────────────");
            System.out.println(ConsoleColors.RESET);
            
        
            /* -------------- Tercera interacción: datafono (ubicación: Clase Hospital) --------------
            *el paciente sleccionado, ingresa el medio de pago que desea utilizar para pagar */
            
            /*~~~~~~~~~~~ Breve introducción de como funcionan los medios de pago en la clinica ~~~~~~~~~~~*/
            System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
            System.out.println("✨💰🧾💸 En Athena OlympiCare ofrecemos los siguientes medios de pago: 💸🧾💰✨");
            System.out.println(ConsoleColors.RESET);
            
        	// Tabla de medios de pago
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD_BRIGHT);
        	System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        	System.out.println("║  ✨ Medio de Pago ✨ ║ 				  ✨ Descripción ✨                             ║");
        	System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════════════╢");
        	System.out.println("║   💰 DEBITO 💰       ║ Si tiene saldo suficiente en su cuenta se efectuará el pago, sin problemas     ║");
        	System.out.println("║                      ║ En caso contrario, se le preguntará si desea acceder a un crédito.             ║");
        	System.out.println("║                      ║ Tenga en cuenta que para poder tener un crédito                                ║");
        	System.out.println("║                      ║ no debe estar reportado en datacredito.                                        ║");
        	System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════════════╢");
        	System.out.println("║  🧾 CREDITO 🧾       ║ Como se mencionó previamente, para poder tener un crédito  		        ║");
        	System.out.println("║                      ║ no debe estar reportado en datacrédito.                                        ║");
        	System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════════════╢");
        	System.out.println("║  💸 EFECTIVO 💸      ║ Por pagar en efectivo, obtendrá un 30% de descuento en el costo total con IVA  ║");
        	System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        	System.out.println(ConsoleColors.RESET);
        	
            System.out.println("\n");
            
            System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.RED_BOLD_BRIGHT);
            System.out.println("💀👁️ ¿Qué ocurre si como usuario no puede sacar un crédito? 👁️💀");
            System.out.println(ConsoleColors.RESET);
            
            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD);
        	System.out.println("🧠🫀🫁 Para eso hemos creado nuestro plan alternativo de pago,");
        	System.out.println("que consiste en la donación voluntaria de sus órganos 🫁🫀🧠");
        	System.out.println(ConsoleColors.RESET);
        	
        	System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD);
        	System.out.println("👉 Los órganos que aceptamos como pago son: 👈");
        	System.out.println(ConsoleColors.RESET);

            System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.PURPLE_BOLD_BRIGHT);
            System.out.println("╔═══════════════════════════════════════════════╗");
        	System.out.println("║       🔪Órgano🗡️         ║   🫰Precio🫰       ║");
        	System.out.println("╠═══════════════════════════════════════════════╢");
        	System.out.println("║   OJO                    ║      750000        ║");
        	System.out.println("║   OREJA                  ║      950000        ║");
        	System.out.println("║   PORCION_DE_HIGADO      ║     1235000        ║");
        	System.out.println("║   RIÑON                  ║     1950000        ║");
        	System.out.println("║   UNA_EXTREMIDAD_SUPERIOR  ║     2450000        ║");
        	System.out.println("║   UNA_EXTREMIDAD_INFERIOR  ║     3000000        ║");
        	System.out.println("╚═══════════════════════════════════════════════╝");
        	System.out.println(ConsoleColors.RESET);

            System.out.println("\n");

            // Imprimir el mensaje
            System.out.println(ConsoleColors.YELLOW_BACKGROUND_BRIGHT + ConsoleColors.GREEN_BOLD);
            System.out.println("Teniendo en cuenta la información recibida, nos gustaría guardar en nuestra base de datos el consentimiento informado.");
            System.out.println("¿Le gustaría ser parte de nuestro plan alternativo? Por favor, ingrese S en caso de Sí y N en caso de No.");
            System.out.println(ConsoleColors.RESET);
            System.out.println("\n");

            // Leer el consentimiento
            String consentimiento = SCANNER_FACTURACION.nextLine().trim().toUpperCase();

            // Agregar de una vez a la base de datos del Hospital, los organos que el paciente quiere donar
            if (consentimiento.equals("S")) {
            	System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD);
                System.out.println("¡Muchas gracias por querer ser parte de nuestro plan alternativo de pago!");
                System.out.println("Por favor, teniendo en cuenta la tabla de los órganos que aceptamos como pago");
                System.out.println("ingrese el órgano y la cantidad de este que le gustaría donar. Ingrese 'fin' para terminar.");
                System.out.println(ConsoleColors.RESET);
                
                // Crear un Scanner para recibir los órganos
                int cuantosOrganos = F0.obtenerEnteroPorInput("Cuantos organos diferentes quieres?: ");
                for (int i = 0; i <= cuantosOrganos; i++){
                    	System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.RED_BOLD_BRIGHT);
                        System.out.print("Órgano: ");
                        Organos organo = F0.obtenerEnumPorInput(Organos.class, "Por favor ingrese alguno de los organos indicado en la tabla");
                        System.out.println(ConsoleColors.RESET);
                    
                        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLUE_BOLD_BRIGHT);
                        System.out.print("Cantidad: ");
                        int cantidad = SCANNER_FACTURACION.nextInt();
                        SCANNER_FACTURACION.nextLine(); // Limpiar el salto de línea, esto ocurre por el uso de nextInt
                        System.out.println(ConsoleColors.RESET);
                        
                        // Agregar el órgano y cantidad al diccionario de órganos para donar
                        pacienteSeleccionado.getCuentaBancaria().agregarOrganoDonar(organo, cantidad);
                    }
                
            } else if (consentimiento.equals("N")) {
                // Con el else if nos aseguramos que estamos evaluando el caso de N
                // Si solo usáramos un else, el código imprimiría el mensaje de respuesta a pesar de que la respuesta del paciente no fuera "N"
                // En caso de que el paciente responda "N" (No)
                System.out.println(ConsoleColors.BLUE_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
            	System.out.println("Entendemos su respuesta. No todos son tan valientes como para desprenderse de una parte de sí");}
            	System.out.println(ConsoleColors.RESET);
            
            /* ~~~~~~~~~~~ Inicio de la interacción ~~~~~~~~~~~ */

            // Imprimir el mensaje
            System.out.println(ConsoleColors.RED_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
            System.out.println("Nos gustaría saber de antemano si está dispuesto a sacar un crédito, ");
            System.out.println("en caso de que su saldo en la cuenta bancaria NO fuese suficiente.");
            System.out.println("Digite 'S' para sí y 'N' para no:");
            System.out.println(ConsoleColors.RESET);
            
            // Leer la respuesta del usuario
            String respuestaCredito = SCANNER_FACTURACION.nextLine().trim().toUpperCase();

            // Imprimir el mensaje
            System.out.println(ConsoleColors.GREEN_BACKGROUND_BRIGHT + ConsoleColors.WHITE_BOLD_BRIGHT);
            System.out.println("Ya con toda la información recibida,");
            System.out.println("por favor ingrese el medio de pago con el que desea saldar su deuda:");
            System.out.println(ConsoleColors.RESET);
            

            // Leer el medio de pago y convertirlo a mayúsculas
            String medioPago = SCANNER_FACTURACION.nextLine().toUpperCase();


            /* ~~~~~~~~~~~~ Aqui esta al fin el llamado al metodo datafono ~~~~~~~~~~~~ */
            String datafono = hospital.datafono(medioPago, respuestaCredito, consentimiento, costos[2] , pacienteSeleccionado, banco);
            System.out.println(datafono);

        }
         
    }

}


