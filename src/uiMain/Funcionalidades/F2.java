package uiMain.Funcionalidades;
import gestorAplicacion.sujeto.*;
import gestorAplicacion.adminHospitalaria.*;

import java.util.Scanner;

public class F2 {
	public static final String reiniciar = "\u001B[0m";
	public static final String negro = "\u001B[30m";
	public static final String verde = "\u001B[32m";
	public static final String amarillo = "\u001B[33m";
	public static final String azul = "\u001B[34m";
	public static final String morado = "\u001B[35m";
	public static final String blanco = "\u001B[37m";
	
	public static final Scanner scanner= new Scanner(System.in);

//Método que nos dará la especialidad del médico

	//Metodo para asignar el médico
	public static Medico asignarMedico() {
	    System.out.println("Asigne el medico que atendera al paciente: ");
	    Medico ortopedista = new Medico(Categoria.ALTO_RENDIMIENTO, 78964, "Dr. Pérez", Especialidad.ORTOPEDISTA);
	    Medico fisioterapeuta = new Medico(Categoria.OLIMPICO, 789013, "Dr. Pepe", Especialidad.FISIOTERAPEUTA);
	    Medico nutricionista = new Medico(Categoria.AFICIONADOS, 789014, "Dra. Molly", Especialidad.NUTRICIONISTA);
	    Medico optometrista = new Medico(Categoria.OLIMPICO, 789015, "Dra. Margarita", Especialidad.OPTOMETRISTA);
	    Medico medico=null;
//Obtendremos la especialidad del médico que tratará al paciente
	    Especialidad especialidadSeleccionada = F2.obtenerEspecialidad();  // Almacenar la especialidad seleccionada en una variable
	    
	    if(especialidadSeleccionada==Especialidad.ORTOPEDISTA) {
	        medico= ortopedista;

	    }
	    else if(especialidadSeleccionada==Especialidad.NUTRICIONISTA) {
	        medico=nutricionista;

	    }
	    else if(especialidadSeleccionada==Especialidad.OPTOMETRISTA) {
	        medico=optometrista;

	    }
	    else if(especialidadSeleccionada==Especialidad.FISIOTERAPEUTA) {
	        medico=fisioterapeuta;

	    }
	    return medico;
	   
	}

	
	
//Método que nos dará la especialidad del médico
	public static Especialidad obtenerEspecialidad() {
	    Scanner scanner = new Scanner(System.in);
//comprobaremos de que el usuario esté colocando los valores correctos, sino devolverá un error
	    while (true) {
	        System.out.println("Ingrese la especialidad -ORTOPEDISTA, FISIOTERAPEUTA, NUTRICIONISTA, OPTOMETRISTA-");
	        String entrada = scanner.nextLine();

	        for (Especialidad especialidad : Especialidad.values()) {
	            if (especialidad.toString().equalsIgnoreCase(entrada)) {
	                return especialidad;
	            }
	        }

	        System.out.println("Especialidad inválida. Por favor, ingrese una especialidad válida.");
	    }
	}
	//Metodo que comprobará si el paciente tiene alguna restricción que pueda poner el peligro su salud
    public static Restriccion restriccionPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿El paciente tiene alguna restricción médica? (Sí/No)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Sí")) {
            System.out.println("Ingrese la restricción -CARDIOVASCULAR, RESPIRATORIA, EQUILIBRIO, FUERZA, FLEXIBILIDAD-");
            String restriccion = scanner.nextLine();

            try {
                return Restriccion.valueOf(restriccion.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Restricción no reconocida.");
            }
        }

        System.out.println("El paciente no tiene restricciones médicas..");
        return null;
    }

		

		
	

	
//Método que guardará los datos del paciente para luego crear la orden médica	
	public static void datosPaciente(){
		System.out.print("Ingrese el nombre del paciente: ");
		String nombre= scanner.nextLine();
		
		System.out.print("Ingrese la identificación del paciente: ");
		int identificacion=Integer.parseInt(scanner.nextLine());

		System.out.print(azul + "1-Si es deportista de Alto rendimiento" + "\n" + 
				"2-Si es deportista olímpico" + "\n" + 
				"3-Si es deportista aficionado" + reiniciar);
		int opcion=Integer.parseInt(scanner.nextLine());
		
		Categoria categoria=null;
		

		switch(opcion){
			
			case 1:
				categoria=Categoria.ALTO_RENDIMIENTO ;
				break;
			case 2:
				categoria=Categoria.OLIMPICO;
				break;
			case 3:
				categoria=Categoria.AFICIONADOS;
				break;
				
			default:
				System.out.print("Opción no válida");				
		}
		
		System.out.print("Ingrese el sexo del paciente");
		String sexo=scanner.nextLine();
		
		System.out.print("Ingrese la edad del paciente");
		int peso=Integer.parseInt(scanner.nextLine());
		
		System.out.print("Ingrese la talla del paciente");
		int talla=Integer.parseInt(scanner.nextLine());
		
		//Paciente creado
		Paciente paciente= new Paciente(categoria,identificacion,nombre,sexo,peso,talla);
		
	}
	
	
//Crearemos la orden médica 	
	public static OrdenMedica generarOrdenMedica(OrdenMedica ordenMedica) {
	    String linea = "==============================================================================================================";
	    String espacio = "||                                                                                                          ||";

	    System.out.println(linea);
	    System.out.println(espacio);
	    System.out.println(espacio);
	    System.out.println("||                                             ORDEN MEDICA                                                 ||");
	    System.out.println(espacio);
	    System.out.println(espacio);
	    System.out.println(linea);

	    System.out.println("||" + "Nombre del paciente: " + ordenMedica.getPaciente().getNombre() + "______________________________");
	    System.out.println("||╬╬" + "Numero de identificacion: " + ordenMedica.getPaciente().getNumeroIdentificacion() + "╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬||");
	    System.out.println("||╬╬" + "Sexo del paciente: " + ordenMedica.getPaciente().getSexo() + "╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬||");
	    System.out.println("||╬╬" + "Peso del paciente: " + ordenMedica.getPaciente().getPeso() + "╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬||");
	    System.out.println("||╬╬" + "Talla del paciente: " + ordenMedica.getPaciente().getTalla() + "╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬||");
	    System.out.println(linea);

	    System.out.println("Nombre del Medico: " + ordenMedica.getMedico().getNombre() + "\n" 
	                    + "Especialidad: " + ordenMedica.getMedico().obtenerEspecialidad() + "\n"
	                    + "Numero de identificacion: " + ordenMedica.getMedico().getNumeroIdentificacion());
	    System.out.println(linea);

	    System.out.println("Enfermedad del paciente: " + ordenMedica.getEnfermedad().getNombre());
	    System.out.println("Sintomas de la enfermedad: " + ordenMedica.getEnfermedad().getSintomas());
	    System.out.println(linea);

	    System.out.println("Recomendaciones : " + ordenMedica.getRecomendaciones());
	    System.out.println(linea);

	    return null;
	}


	


	}


