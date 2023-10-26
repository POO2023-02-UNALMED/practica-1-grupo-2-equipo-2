package uiMain.Funcionalidades;
import gestorAplicacion.sujeto.*;
import gestorAplicacion.adminHospitalaria.*;
import gestorAplicacion.serviciosOfrecidos.*;

import java.util.Scanner;
import static uiMain.Screen.SCANNER;

public class F2 {
	public static final String reiniciar = "\u001B[0m";
	public static final String negro = "\u001B[30m";
	public static final String verde = "\u001B[32m";
	public static final String amarillo = "\u001B[33m";
	public static final String azul = "\u001B[34m";
	public static final String morado = "\u001B[35m";
	public static final String blanco = "\u001B[37m";
	
	public static final Scanner SCANNER_ORDEN= SCANNER;

//Método que nos dará la especialidad del médico

	//Metodo para asignar el médico
	public static Medico asignarMedico() {
	    System.out.println("Asigne el medico que atendera al paciente: ");
	    Medico ortopedista = new Medico(Categoria.ALTO_RENDIMIENTO, 78964, "Dr. Pérez", Especialidad.ORTOPEDISTA);
	    Medico fisioterapeuta = new Medico(Categoria.OLIMPICO, 789013, "Dr. Pepe", Especialidad.FISIOTERAPEUTA);
	    Medico nutricionista = new Medico(Categoria.AFICIONADOS, 789014, "Dra. Molly", Especialidad.NUTRICIONISTA);
	    Medico optometrista = new Medico(Categoria.OLIMPICO, 789015, "Dra. Margarita", Especialidad.OPTOMETRISTA);
	    Medico medico=null;

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

	    while (true) {
	        System.out.println("Ingrese la especialidad -ORTOPEDISTA, FISIOTERAPEUTA, NUTRICIONISTA, OPTOMETRISTA-");
	        String entrada = SCANNER_ORDEN.nextLine();

	        for (Especialidad especialidad : Especialidad.values()) {
	            if (especialidad.toString().equalsIgnoreCase(entrada)) {
	                return especialidad;
	            }
	        }

	        System.out.println("Especialidad inválida. Por favor, ingrese una especialidad válida.");
	    }
	}
	// este metodo se encargará de dar las restricciones que tiene el paciente
    public static Restriccion restriccionPaciente() {

        System.out.println("¿El paciente tiene alguna restricción médica? (Sí/No)");
        String respuesta = SCANNER_ORDEN.nextLine().toUpperCase();

        if (respuesta.equalsIgnoreCase("SI")) {
            System.out.println("Ingrese la restricción -CARDIOVASCULAR, RESPIRATORIA, EQUILIBRIO, FUERZA, FLEXIBILIDAD-");
            String restriccion = SCANNER_ORDEN.nextLine();

            try {
                return Restriccion.valueOf(restriccion.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Restricción no reconocida.");
            }
        }

        System.out.println("El paciente no tiene restricciones médicas..");
        return null;
    }

	
//Crearemos la orden médica 	
	public static void generarOrdenMedica(OrdenMedica ordenMedica) {
		System.out.println("==============================================================================================================");
		System.out.println("||                                                                                                          ||");
		System.out.println("||                                                                                                          ||");
		System.out.println("||                                             ORDEN MEDICA                                                 ||");
		System.out.println("||                                                                                                          ||");
		System.out.println("||                                                                                                          ||");
		System.out.println("==============================================================================================================");
		System.out.println( "Nombre del paciente: " + ordenMedica.getPaciente().getNombre()                                     + "\n"
						+ "Numero de identificacion: " + ordenMedica.getPaciente().getNumeroIdentificacion()                   + "\n"
						+ "Sexo del paciente: " + ordenMedica.getPaciente().getSexo() +                                          "\n" 
						+ "Peso del paciente: " + ordenMedica.getPaciente().getPeso() +                                      "\n"
						+ "Talla del paciente: " + ordenMedica.getPaciente().getTalla());
		System.out.println("==============================================================================================================");
		System.out.println("Nombre del Medico: " + ordenMedica.getMedico().getNombre() + "\n" 
						+ "Especialidad: " + ordenMedica.getMedico().getEspecialidad() + "\n"
						+ "Numero de identificacion: " + ordenMedica.getMedico().getNumeroIdentificacion());
		System.out.println("==============================================================================================================");
		System.out.println("Enfermedad del paciente: " + ordenMedica.getEnfermedad().getNombre());
		System.out.println("Sintomas de la enfermedad: " + ordenMedica.getEnfermedad().getSintomas());
		System.out.println("==============================================================================================================");
		System.out.println("Recomendaciones: " + ordenMedica.getRecomendaciones());
		System.out.println("==============================================================================================================");
	
	}
	
	public static void screenOrdenMedica (Consulta consulta) {
		Paciente paciente = consulta.getPaciente();
		Enfermedad enfermedad = consulta.getEnfermedad();
		Medico medico = consulta.getMedico();
		
		System.out.print("Por favor ingrese las recomendaciones, solo presione enter después de ingresar toda la información: ");
		String recomendaciones = SCANNER_ORDEN.next();

		OrdenMedica ordenNueva = new OrdenMedica(paciente, enfermedad, medico, recomendaciones);
		
		generarOrdenMedica(ordenNueva);
		paciente.actualizarHistorialOrdenes(ordenNueva);
	}

}
