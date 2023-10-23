package uiMain.Funcionalidades;
import gestorAplicacion.serviciosOfrecidos.*;
import java.util.Scanner;
import gestorAplicacion.sujeto.*;
import java.util.ArrayList;

public class F4 {
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	private static final Scanner sc = new Scanner(System.in);
	public static Rutina rutina;
	
	public static void generarRutina(Paciente paciente) {
		TipoTerapia terapiaSeleccionada = null;
		TipoObjetivo objetivoSeleccionado = null;
	
		
		do {
			System.out.println(BLUE + "Que tipo de terapia desea aplicar?" + RESET);
			System.out.println(BLUE + "Elija entre: ACONDICIONAMIENTO o REHABILITACION" + RESET);
			String entrada = sc.nextLine().toUpperCase();
			
			try {
				terapiaSeleccionada = TipoTerapia.valueOf(entrada);
			} catch (IllegalArgumentException error) {
				System.out.println(RED + "Entrada invalida, intentelo nuevamente" + RESET);
			}
			
		} while (terapiaSeleccionada == null);
		
		do {
			System.out.println(BLUE + "Que objetivo desea cumplir?" + RESET);
				if(terapiaSeleccionada == TipoTerapia.ACONDICIONAMIENTO) {
					System.out.println(PURPLE + "FORTALECIMIENTO_MUSCULAR" + RESET);
					System.out.println(PURPLE + "AUMENTO_RESISTENCIA_CARDIOVASCULAR" + RESET);
					System.out.println(PURPLE + "INCREMENTO_ELASTICIDAD" + RESET);
					System.out.println(PURPLE + "INCREMENTO_VELOCIDAD" + RESET);
					System.out.println(PURPLE + "MEJORA_DEL_EQUILIBIRIO" + RESET);
				}
				else {
					System.out.println(PURPLE + "RECUPERACION_LESION_OSEA" + RESET);
					System.out.println(PURPLE + "RECUPERACION_LESION_MUSCULAR" + RESET);
				} 
				String entrada = sc.nextLine().toUpperCase();
				
				try {
					objetivoSeleccionado = TipoObjetivo.valueOf(entrada);
				} catch (IllegalArgumentException error) {
					System.out.println(RED + "Entrada invalida, intentelo nuevamente" + RESET);
				}
		} while (objetivoSeleccionado == null);
		
		rutina = new Rutina(paciente, terapiaSeleccionada, objetivoSeleccionado);
	}
	
	public static void generarEjerciciosOrdenados() {
		ArrayList<Ejercicio>ejerciciosParaMostrar = rutina.getEjerciciosPosibles();
		
		do {
			System.out.println(BLUE + "Seleccione los ejercicios de la siguente lista " + RESET);
			System.out.println(BLUE + "Ingrese el nombre de los ejercicios, separados por un solo espacio: " + RESET);
		
			for(int i = 0; i < ejerciciosParaMostrar.size(); i++) {
				System.out.println(PURPLE + i + ")" + ejerciciosParaMostrar.get(i) + RESET);
			}
			
			String entrada = sc.nextLine().toUpperCase();
			String[] nombresEjercicios = entrada.split(" ");
			ArrayList<Ejercicio>ejerciciosConvertidos = new ArrayList<>();
			
			try {
				for(int i = 0; i < nombresEjercicios.length; i++) {
					String ejercicioConvertir = nombresEjercicios[i];
					Ejercicio ejercicioConvertido = Ejercicio.valueOf(ejercicioConvertir);
					ejerciciosConvertidos.add(ejercicioConvertido);
				}
				rutina.setEjerciciosOrdenados(ejerciciosConvertidos);
			} catch (IllegalArgumentException error) {
				System.out.println(RED + "Entrada invalida, intentelo nuevamente" + RESET);

			}
		} while (rutina.getEjerciciosOrdenados().size() == 0);
	}
}
