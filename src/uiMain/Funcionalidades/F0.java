package uiMain.Funcionalidades;

import java.util.Scanner;

import gestorAplicacion.sujeto.*;
import gestorAplicacion.instalaciones.*;
import static uiMain.Screen.HOSPITAL;
import static uiMain.Screen.SCANNER;

public class F0 {
	public static  Scanner UTILITY_SCANNER = SCANNER;
    private static Hospital UTILITY_HOSPITAL = HOSPITAL;
    


	public static Categoria obtenerCategoriaPorInput() {
	    Categoria categoriaElegida = null;
	    do {
	    	System.out.println("Ingrese su categoría (ALTO_RENDIMIENTO, OLIMPICO, AFICIONADOS): ");
	        String categoriaString = UTILITY_SCANNER.nextLine().toUpperCase();
	        try {
	        	categoriaElegida = Categoria.valueOf(categoriaString);
	        } catch (IllegalArgumentException e){
	        	System.out.println("Entrada invalida, por favor intente de nuevo");

	        }
	    } while(categoriaElegida == null);
	    return categoriaElegida;
	}

    public static Paciente obtenerPacientePorInput() {
		Paciente pacienteElegido = null;
		int IDElegido = 0;

        do {
            IDElegido = obtenerEnteroPorInput("Por favor ingrese el numero de identificacion del paciente: ");
            for (Paciente paciente : F0.UTILITY_HOSPITAL.getListaPacientes()) {
				if (IDElegido == paciente.getNumeroIdentificacion()) {
					pacienteElegido = paciente;
					return pacienteElegido;
				}
            }
            if (pacienteElegido == null) {
                System.out.println("No hemos podido encontrar al paciente en nuestro sistema, por favor intente de nuevo.");
            } 
        } while (pacienteElegido == null);
        
        return pacienteElegido;
    }

    public static long obtenerLongPorInput(String mensaje) {
		long longElegido = 0;
	    String entrada;
		do {
		    System.out.println(mensaje);
		    entrada = UTILITY_SCANNER.nextLine();
		    try {
				longElegido = Long.parseLong(entrada);
		    } catch (NumberFormatException e) {
				F0.indicarEntradaInvalida();
		    }
		} while (longElegido == 0);
        return longElegido;
    }

    public static String obtenerEleccionDeSioNo(String mensaje) {
        	String eleccion;

        	do {
        		System.out.println(mensaje);
        		System.out.println("Ingresa Y para sí o N para no");
        		eleccion = UTILITY_SCANNER.nextLine().toUpperCase();
        		
        		if (!eleccion.equals("Y") && !eleccion.equals("N")) {
            		System.out.println("Entrada inválida, por favor intente de nuevo.");
        		}

        	} while(!eleccion.equals("Y") && !eleccion.equals("N"));

        	return eleccion;
        }

	//Borra la pantalla
	//Borra la pantalla
	public static void eraseScreen(){
	
	   System.out.print("\033[H\033[2J");
	   System.out.flush();
	}

	//Indica cuando el usuario ingreso una entrada valida
	public static void indicarEntradaValida() {
	   eraseScreen();
	   System.out.println(F4.GREEN + "Entrada aceptada, procesando informacion..." + F4.RESET);
	}

	//Indica cuando el usuario ingreso una entrada invalida
	public static void indicarEntradaInvalida() {
	   eraseScreen();
	   System.out.println(F4.RED + "Entrada invalida, por favor intente nuevamente " + F4.RESET);
	
	}

	public static int obtenerEnteroPorInput(String mensaje) {
		String entrada;
		int entradaConvertida = 0;
		
		do {
			System.out.println(mensaje);
			entrada = UTILITY_SCANNER.nextLine();
			try {
				entradaConvertida = Integer.parseInt(entrada);
			} catch (NumberFormatException e){
				indicarEntradaInvalida();
			}
			
		} while(entradaConvertida == 0);
		
		return entradaConvertida;
	}

	public static <E extends Enum<E>> E obtenerEnumPorInput(Class<E> enumClass, String mensaje) {
	        System.out.print(mensaje);
	        E enumValue = null;
	        
	        do {
	        	try {
	        		String input = UTILITY_SCANNER.nextLine().toUpperCase();
		            enumValue = Enum.valueOf(enumClass, input);
		        } catch (IllegalArgumentException e) {
		            System.out.println("Entrada inválida, por favor intente de nuevo.");
		        } 
	        } while (enumValue == null);
	        
	        return enumValue;
	  }

	public static int obtenerEnteroConLimitePorInput(int limiteInferior, int limiteSuperior, String mensaje) {
		 int enteroChequeado;
		 
		 do {
			 enteroChequeado = obtenerEnteroPorInput(mensaje);
			 if (enteroChequeado < limiteInferior || enteroChequeado > limiteSuperior) {
			 	System.out.println("Entrada inválida, por favor intente de nuevo.");
			 }
		 } while (enteroChequeado < limiteInferior || enteroChequeado > limiteSuperior);
		 
		 return enteroChequeado;
	 }
	
	public static Enfermedad obtenerEnfermedadPorInput() {
		Enfermedad enfermedadElegida = null;
		
		for (Enfermedad enfermedad: UTILITY_HOSPITAL.getListaEnfermedades()) {
			System.out.println(enfermedad.getNombre());
		}
		
		do {
			System.out.println("Por favor ingrese el nombre de la enfermedad: ");
			String entrada = UTILITY_SCANNER.nextLine().toUpperCase();
			
			for (Enfermedad enfermedad : UTILITY_HOSPITAL.getListaEnfermedades()) {
				if (enfermedad.getNombre().toUpperCase().equals(entrada)) {
					enfermedadElegida = enfermedad;
					return enfermedadElegida;
				}
			}
			
			if (enfermedadElegida == null) {
			 	System.out.println("Entrada inválida, por favor intente de nuevo.");
			}
		} while(enfermedadElegida == null);
		
		return enfermedadElegida;
	}
	
}
