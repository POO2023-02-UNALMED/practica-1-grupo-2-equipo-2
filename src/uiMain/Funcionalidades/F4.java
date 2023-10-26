package uiMain.Funcionalidades;
import gestorAplicacion.serviciosOfrecidos.*;
import java.util.Scanner;
import gestorAplicacion.sujeto.*;
import java.util.ArrayList;
import static uiMain.Screen.SCANNER;

public class F4 {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    
    static final Scanner SCANNER_RUTINA = SCANNER;
    public static Rutina rutina;
    
    public static void screenRutina(Paciente paciente) {
       System.out.println(BLUE + "Bienvenido al generador de rutinas :D" + RESET);
       Rutina unaRutina = generarRutina(paciente);
       generarEjerciciosOrdenados(unaRutina);
       agregarEjerciciosAdicionales(unaRutina);
       eliminarEjercicios(unaRutina);
       paciente.getHistoriaClinica().actualizarHistorialRutinas(unaRutina);
       System.out.println(BLUE + "La rutina ha sido guardad en la historia clinica" + RESET);
       System.out.println(BLUE + "Gracias por usar nuestro generador :D" + RESET);
       
    }
    
    public static void imprimirTablaEjercicios(ArrayList<Ejercicio> elementos) {
       // Definir el ancho de cada columna
       int ancho = 48;
       int columnas = 3;
       int contador = 0;

       System.out.println(new String(new char[ancho * columnas + columnas + 1]).replace('\0', '-'));

       for (Ejercicio elemento : elementos) {
          System.out.printf("|| %-" + (ancho - 2) + "s ", elemento);
          contador++;
          if (contador % columnas == 0) {
             System.out.println("||");  // Salta a una nueva línea después de imprimir 6 elementos
             System.out.println(new String(new char[ancho * columnas + columnas + 1]).replace('\0', '-'));
          }
       }

       // Rellenar con espacios en blanco si la última fila tiene menos de 6 elementos
       int elementosRestantes = columnas - (contador % columnas);
       if (elementosRestantes != columnas) {  // Solo rellenar con espacios en blanco si no es múltiplo de 6
          for (int i = 0; i < elementosRestantes; i++) {
             System.out.printf("| %-" + (ancho-2) + "s ", "");
          }
          System.out.println("|");  // Salta a una nueva línea si se agregaron espacios en blanco
       }
    }
    
    /* Metodo que pide una entrada hasta que el usario proporcione un entero, si proporciona una entrada de otro tipo imprime un mensaje de entrada
     * y continúa hasta que el usuario proporcione una entrada válida, como argumento se debe pasar el mensaje que se debe utilizar para que el usuario
     * ingrese su entero, ej: "Ingrese su edad"*/
    
	 /* Imprime todos los ejercicios que puede usar el paciente segun su objetivo y restriccion */
    public static void mostrarEjercicios() {

       ArrayList<Ejercicio>ejerciciosParaMostrar = rutina.getEjerciciosPosibles();

       System.out.println(BLUE + "Seleccione los ejercicios de la siguente lista " + RESET);
       System.out.println(BLUE + "Ingrese el nombre de los ejercicios, separados por un solo espacio: " + RESET);

       imprimirTablaEjercicios(ejerciciosParaMostrar);

    }

    /* Imprime los ejercicios seleccionados anteriormente por el usuario*/
    public static void mostrarEjerciciosOrdenados() {
       ArrayList<Ejercicio>ejerciciosParaMostrar = rutina.getEjerciciosOrdenados();

       System.out.println(BLUE + "Estos son los ejercicios incluidos en la rutina:  " + RESET);

       imprimirTablaEjercicios(ejerciciosParaMostrar);

    }

    /*Convierte la entrada del usuario que es una String a un ArrayList de ejercicios*/
    public static ArrayList<Ejercicio> convertirEjercicios(String entrada) {

       String[] nombresEjercicios = entrada.split(" ");
       ArrayList<Ejercicio>ejerciciosConvertidos = new ArrayList<>();

       try {
          for(int i = 0; i < nombresEjercicios.length; i++) {
             String ejercicioConvertir = nombresEjercicios[i];
             Ejercicio ejercicioConvertido = Ejercicio.valueOf(ejercicioConvertir);
             ejerciciosConvertidos.add(ejercicioConvertido);
          }

       } catch (IllegalArgumentException error) {
          F0.indicarEntradaInvalida();
       }
       return ejerciciosConvertidos;
    }
    /*Crea un objeto de tipo rutina a partir de los requerimientos del paciente dados por el usuario */
    public static Rutina generarRutina(Paciente paciente) {
       TipoTerapia terapiaSeleccionada = null;
       TipoObjetivo objetivoSeleccionado = null;


       do {
          System.out.println(BLUE + "Que tipo de terapia desea aplicar?" + RESET);
          System.out.println(BLUE + "Ingrese el tipo de terapia entre: ACONDICIONAMIENTO o REHABILITACION" + RESET);
          String entrada = SCANNER_RUTINA.nextLine().toUpperCase();

          try {
             terapiaSeleccionada = TipoTerapia.valueOf(entrada);
          } catch (IllegalArgumentException error) {
             F0.indicarEntradaInvalida();
          }

       } while (terapiaSeleccionada == null);
       F0.indicarEntradaValida();


       do {
          System.out.println(BLUE + "Ingrese el tipo de objetivo que desea cumplir de entre las siguientes opciones: " + RESET);
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
          String entrada = SCANNER_RUTINA.nextLine().toUpperCase();

          try {
             objetivoSeleccionado = TipoObjetivo.valueOf(entrada);
          } catch (IllegalArgumentException error) {
             F0.indicarEntradaInvalida();
          }
       } while (objetivoSeleccionado == null);
       F0.indicarEntradaValida();


       rutina = new Rutina(paciente, terapiaSeleccionada, objetivoSeleccionado);
       return rutina;
    }

    /* Muestra los ejercicios y permite al usuario seleccionar los que este considere,
     * luego los guarda en el atributo ejerciciosOrdenados*/
    public static void generarEjerciciosOrdenados(Rutina rutina) {

       do {
          mostrarEjercicios();

          String entrada = SCANNER_RUTINA.nextLine().toUpperCase();
          ArrayList<Ejercicio>ejerciciosConvertidos = convertirEjercicios(entrada);


          try {
             rutina.setEjerciciosOrdenados(ejerciciosConvertidos);
          } catch (IllegalArgumentException error) {
             F0.indicarEntradaInvalida();

          }
       } while (rutina.getEjerciciosOrdenados().size() == 0);
       F0.indicarEntradaValida();

    }

    /*Da la opcion al usuario de agregar ejercicios a la lista de ejerciciosOrdenados*/
    public static void agregarEjerciciosAdicionales(Rutina rutina) {
       String entrada;

       do {
          F0.eraseScreen();
          mostrarEjerciciosOrdenados();

          System.out.println(BLUE + "Desea agregar mas ejercicios? " + RESET);
          System.out.println(BLUE + "Ingrese " + PURPLE + "Y" + BLUE + " para si o " + PURPLE + "N" + BLUE + " para no" + RESET);

          entrada = SCANNER_RUTINA.nextLine().toUpperCase();
          if(!entrada.equals("Y") && !entrada.equals("N") ) {
             F0.indicarEntradaInvalida();
          }

       } while (!entrada.equals("Y") && !entrada.equals("N"));

       F0.indicarEntradaValida();

       if (entrada.equals("Y")) {
          ArrayList <Ejercicio> ejerciciosConvertidos = new ArrayList<>();
          do {
             F0.eraseScreen();
             mostrarEjerciciosOrdenados();
             mostrarEjercicios();
             String entradaEjercicios = SCANNER_RUTINA.nextLine().toUpperCase();

             ejerciciosConvertidos = convertirEjercicios(entradaEjercicios);

             try {
                for(int i = 0; i < ejerciciosConvertidos.size(); i++ ) {
                   rutina.agregarEjercicioOrdenado(ejerciciosConvertidos.get(i));
                }
             } catch (IllegalArgumentException error) {
                F0.indicarEntradaInvalida();

             }

          } while(ejerciciosConvertidos.size() == 0);

          F0.indicarEntradaValida();
       }
    }

    /*Da la opcion al usuario de eliminar ejercicios de la lista ejerciciosOrdenados*/
    public static void eliminarEjercicios(Rutina rutina) {
       String entrada;

       do {
          F0.eraseScreen();
          mostrarEjerciciosOrdenados();

          System.out.println(BLUE + "Desea eliminar ejercicios? " + RESET);
          System.out.println(BLUE + "Ingrese " + PURPLE + "Y" + BLUE + " para si o " + PURPLE + "N" + BLUE + " para no" + RESET);

          entrada = SCANNER_RUTINA.nextLine().toUpperCase();
          if(!entrada.equals("Y") && !entrada.equals("N") ) {
             F0.indicarEntradaInvalida();
          }

       } while (!entrada.equals("Y") && !entrada.equals("N"));

       F0.indicarEntradaValida();

       if (entrada.equals("Y")) {

          String ejerciciosConvertir;
          ArrayList<Ejercicio>ejerciciosConvertidos = new ArrayList<>();

          do {
             System.out.println(BLUE + "Ingrese el nombre de los ejercicios que desea eliminar separados por un solo espacio " + RESET);
             ejerciciosConvertir = SCANNER_RUTINA.nextLine().toUpperCase();
             ejerciciosConvertidos = convertirEjercicios(ejerciciosConvertir);
             try {
                for(int i = 0; i < ejerciciosConvertidos.size(); i++) {
                   rutina.eliminarEjercicio(ejerciciosConvertidos.get(i));
                }
             } catch (IllegalArgumentException error) {
                F0.indicarEntradaInvalida();

             }
          } while (ejerciciosConvertidos.size() == 0);
          F0.indicarEntradaValida();
          mostrarEjerciciosOrdenados();
       }
    }
}