/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package uiMain.Funcionalidades;

import gestorAplicacion.instalaciones.*;
import gestorAplicacion.sujeto.*;
import java.util.Scanner;

public class F5 {

    private static final Scanner sc = new Scanner(System.in);

    public static void facturacion(Hospital hospital, Banco banco) {

        // Buscar paciente
            Paciente pacienteSeleccionado;

            do {
                // Solicitar la cédula del paciente y buscarlo en el hospital
                System.out.println("Ingrese la cédula del paciente:");
                int cedula = Integer.parseInt(sc.nextLine());
                pacienteSeleccionado = hospital.buscarPaciente(cedula);
        
                if (pacienteSeleccionado == null) {
                    // Mostrar mensaje si el paciente no existe y preguntar si desea intentar de nuevo
                    System.out.println("\u001B[34mNo existe un paciente registrado con esta cédula.\u001B[0m ¿Desea intentar de nuevo? (S/N)");
                        if (sc.nextLine().equalsIgnoreCase("N")) {
                            return; // Terminar la ejecución si el usuario no desea intentar de nuevo
                        }
                    }
                } while (pacienteSeleccionado == null); // Repetir hasta que se encuentre un paciente válido
        

        /* -------------- Primera interacción: obtenerServiciosSinPagar (ubicación: Clase Paciente) --------------
        * Obtener los servicios pendientes de pago del paciente seleccionado */

        // dejar habitacion occupada por el paciente saliente
        pacienteSeleccionado.getHabitacionAsignada().dejarHabitacion();

        // Mostrar lista de servicios pendientes de pago
        System.out.println("Servicios pendientes de pago para " + pacienteSeleccionado.getNombre() + " (Cédula: " + pacienteSeleccionado.getNumeroIdentificacion() + "):");
        String serviciosSinPagar = pacienteSeleccionado.obtenerServiciosSinPagar();
        System.out.println(serviciosSinPagar);

        
        /* -------------- Segunda interacción: seleccionarServiciosAPagar (ubicación: Clase Paciente) --------------
        *el paciente sleccionado, ingresa los servicios que desea pagar */

        // Información introductoria sobre descuentos
        System.out.println("En AtheneaOlympicCare tenemos una serie de descuentos, dependiendo de la cantidad de servicios que quiera pagar, los cuales son:");
        
        // Tabla de descuentos
        System.out.println("\u001B[31m-------------------------------------------------");
        System.out.println("| \u001B[33mCantidad de Servicios \u001B[31m| \u001B[33mPorcentaje de Descuento \u001B[31m|");
        System.out.println("\u001B[31m-------------------------------------------------");
        System.out.println("| \u001B[33m5 o más                \u001B[31m| \u001B[33m20%                    \u001B[31m|");
        System.out.println("| \u001B[33m10 o más               \u001B[31m| \u001B[33m30%                    \u001B[31m|");
        System.out.println("| \u001B[33m15 o más               \u001B[31m| \u001B[33m40%                    \u001B[31m|");
        System.out.println("| \u001B[33m20 o más               \u001B[31m| \u001B[33m50%                    \u001B[31m|");
        System.out.println("\u001B[31m-------------------------------------------------\u001B[0m");

        // Ingresar los índices de los servicios a pagar
        System.out.println("Ingrese los índices de los servicios que desea pagar (separados por comas):");
        String indices = sc.nextLine();

        // Llamar al método seleccionarServiciosAPagar con los índices ingresados
        double[] costos = pacienteSeleccionado.seleccionarServiciosAPagar(indices);

        // Mostrar factura
        System.out.println("Factura para " + pacienteSeleccionado.getNombre() + " (Cédula: " + pacienteSeleccionado.getNumeroIdentificacion() + "):");
        System.out.println("Costo total: \u001B[33m" + costos[0] + "\u001B[0m");
        System.out.println("Costo total con descuento: \u001B[33m" + costos[1] + "\u001B[0m");
        System.out.println("Costo total con IVA: \u001B[33m" + costos[2] + "\u001B[0m");
        System.out.println("\n");
        System.out.println("\n");
    
        /* -------------- Tercera interacción: datafono (ubicación: Clase Hospital) --------------
        *el paciente sleccionado, ingresa el medio de pago que desea utilizar para pagar */
        
        /*~~~~~~~~~~~ Breve introducción de como funcionan los medios de pago en la clinica ~~~~~~~~~~~*/

        System.out.println("En Athena OlympiCare ofrecemos los siguientes medios de pago:");

    	// Tabla de medios de pago
    	System.out.println("╔═════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    	System.out.println("║   \u001B[95mMedio de Pago   ║ 				\u001B[35mDescripción                                           ║");
    	System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════╢");
    	System.out.println("║   \u001B[33mDEBITO          ║ Si tiene saldo suficiente en su cuenta se efectuará el pago, sin problemas.     ║");
    	System.out.println("║   \u001B[33m                ║ En caso contrario, se le preguntará si desea acceder a un crédito.              ║");
    	System.out.println("║   \u001B[33m                ║ Tenga en cuenta que para poder tener un crédito no debe estar reportado en      ║");
    	System.out.println("║   \u001B[33m                ║ datacrédito, es decir, no debe tener ningún crédito pendiente de pago.          ║");
    	System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════╢");
    	System.out.println("║   \u001B[96mCREDITO         ║ Como se mencionó previamente, para poder tener un crédito  		      ║");
    	System.out.println("║   \u001B[96m                ║ no debe estar reportado en datacrédito.                                         ║");
    	System.out.println("╠═════════════════════════════════════════════════════════════════════════════════════════════════════╢");
    	System.out.println("║   \u001B[92mEFECTIVO        ║ Por pagar en efectivo, obtendrá un 30% de descuento en el costo total con IVA   ║");
    	System.out.println("╚═════════════════════════════════════════════════════════════════════════════════════════════════════╝");

        System.out.println("\n");
        
        System.out.println("\u001B[1m\u001B[31m¿Qué ocurre si como usuario no puede sacar un crédito?\u001B[0m");
    	System.out.println("\u001B[3m\u001B[95mPara eso hemos creado nuestro plan alternativo de pago, que consiste en la donación voluntaria de sus órganos.\u001B[0m");
    	System.out.println("\u001B[3m\u001B[95mLos órganos que aceptamos como pago son:\u001B[0m");

        System.out.println("\n");

        System.out.println("╔═══════════════════════════════════════════════╗");
    	System.out.println("║   \u001B[91mÓrgano               \u001B[96m  ║   \u001B[91mPrecio           \u001B[96m║");
    	System.out.println("╠═══════════════════════════════════════════════╢");
    	System.out.println("║   \u001B[96mOjo                  \u001B[96m  ║   \u001B[96m750000          \u001B[96m║");
    	System.out.println("║   \u001B[96mOreja                \u001B[96m  ║   \u001B[96m950000           \u001B[96m║");
    	System.out.println("║   \u001B[96mPorción de hígado    \u001B[96m  ║   \u001B[96m1235000          \u001B[96m║");
    	System.out.println("║   \u001B[96mRiñón               \u001B[96m   ║   \u001B[96m1950000          \u001B[96m║");
    	System.out.println("║   \u001B[96m1 extremidad superior\u001B[96m  ║   \u001B[96m2450000          \u001B[96m║");
    	System.out.println("║   \u001B[96m1 extremidad inferior\u001B[96m  ║   \u001B[96m3000000          \u001B[96m║");
    	System.out.println("╚═══════════════════════════════════════════════╝");

        System.out.println("\n");

        // Imprimir el mensaje
        System.out.println("\u001B[95mTeniendo en cuenta la información recibida, nos gustaría guardar en nuestra base de datos el consentimiento informado.");
        System.out.println("¿Le gustaría ser parte de nuestro plan alternativo? Por favor, ingrese S en caso de Sí y N en caso de No.\u001B[0m");

        System.out.println("\n");

        // Crear un Scanner para consentimiento
        Scanner consentimientoScanner = new Scanner(System.in);
        // Leer el consentimiento
        String consentimiento = consentimientoScanner.nextLine().trim().toUpperCase();

        // Agregar de una vez a la base de datos del Hospital, los organos que el paciente quiere donar
        if (consentimiento.equals("S")) {
            System.out.println("\u001B[95m ¡Muchas gracias por querer ser parte de nuestro plan alternativo de pago!");
            System.out.println("\u001B[95m Por favor, teniendo en cuenta la tabla de los órganos que aceptamos como pago");
            System.out.println("\u001B[95m ingrese el órgano y la cantidad de este que le gustaría donar. Ingrese 'fin' para terminar.");
        
            // Crear un Scanner para recibir los órganos
            try (Scanner organoScanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("Órgano (o 'fin' para terminar): ");
                    String organo = organoScanner.nextLine().trim();
                    
                    if (organo.equalsIgnoreCase("fin")) {
                        break; // El usuario ha terminado de ingresar órganos
                    }
                    
                    System.out.print("Cantidad: ");
                    int cantidad = organoScanner.nextInt();
                    organoScanner.nextLine(); // Limpiar el salto de línea, esto ocurre por el uso de nextInt
                    
                    // Agregar el órgano y cantidad al diccionario de órganos para donar
                    pacienteSeleccionado.getCuentaBancaria().agregarOrganoDonar(organo, cantidad);
                }
            }
        } else if (consentimiento.equals("N")) {
            // Con el else if nos aseguramos que estamos evaluando el caso de N
            // Si solo usáramos un else, el código imprimiría el mensaje de respuesta a pesar de que la respuesta del paciente no fuera "N"
            // En caso de que el paciente responda "N" (No)
            System.out.println("\u001B[94mEntendemos su respuesta, tenga un feliz resto de día.\u001B[0m");}
        
        /* ~~~~~~~~~~~ Inicio de la interacción ~~~~~~~~~~~ */

        // Imprimir el mensaje
        System.out.println("\u001B[96mNos gustaría saber de antemano si está dispuesto a sacar un crédito.");
        System.out.println("Digite 'S' para sí y 'N' para no:\u001B[0m");

        // Crear un Scanner para obtener la respuesta
        Scanner creditoScanner = new Scanner(System.in);

        // Leer la respuesta del usuario
        String respuestaCredito = creditoScanner.nextLine().trim().toUpperCase();

        // Imprimir el mensaje
        System.out.println("\u001B[92mYa con toda la información recibida,");
        System.out.println("por favor ingrese el medio de pago con el que desea saldar su deuda:\u001B[0m");

        // Crear un Scanner para el medio de pago
        Scanner medioPagoScanner = new Scanner(System.in);

        // Leer el medio de pago y convertirlo a mayúsculas
        String medioPago = medioPagoScanner.nextLine().toUpperCase();


        /* ~~~~~~~~~~~~ Aqui esta al fin el llamado al metodo datafono ~~~~~~~~~~~~ */
        String datafono = hospital.datafono(medioPago, respuestaCredito, costos[2] , pacienteSeleccionado, banco);
        System.out.println(datafono);


        // Cerrar los scanners usados en la función al finalizar el bloque
        sc.close();
        consentimientoScanner.close();
        medioPagoScanner.close();
        creditoScanner.close();
        // No es necesario cerrar organoScanner debido al uso de try-with-resources
        
    }

}


