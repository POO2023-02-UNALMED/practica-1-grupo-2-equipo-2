
package uiMain.Funcionalidades;

import gestorAplicacion.sujeto.*;
import gestorAplicacion.adminHospitalaria.*;
import java.util.Scanner;

public class F1 {
	static {
		// algunos Medicos- caso de prueba.
        Medico ortopedista = new Medico(Categoria.ALTO_RENDIMIENTO, 78964, "Dr. Pérez", Especialidad.ORTOPEDISTA);
        Medico fisioterapeuta = new Medico(Categoria.OLIMPICO, 789013, "Dr. Pepe", Especialidad.FISIOTERAPEUTA);
        Medico nutricionista = new Medico(Categoria.AFICIONADOS, 789014, "Dra. Molly", Especialidad.NUTRICIONISTA);
        Medico optometrista = new Medico(Categoria.OLIMPICO, 789015, "Dra. Margarita", Especialidad.OPTOMETRISTA);
        Medico ortopedista2 = new Medico(Categoria.OLIMPICO, 7893, "Dr. Mario", Especialidad.ORTOPEDISTA);
        Medico fisioterapeuta2 = new Medico(Categoria.ALTO_RENDIMIENTO, 7892, "Dr. lugui", Especialidad.FISIOTERAPEUTA);
        Medico nutricionista2 = new Medico(Categoria.AFICIONADOS, 7890, "Dr. yoshi", Especialidad.NUTRICIONISTA);
        Medico optometrista2 = new Medico(Categoria.AFICIONADOS, 7891, "Dra. rosalina", Especialidad.OPTOMETRISTA);

      //Los medicos de prueba se guaradan en una lista.
        ListaProfesionales.agregarProfesional(ortopedista);
        ListaProfesionales.agregarProfesional(fisioterapeuta);
        ListaProfesionales.agregarProfesional(nutricionista);
        ListaProfesionales.agregarProfesional(optometrista);
        ListaProfesionales.agregarProfesional(ortopedista2);
        ListaProfesionales.agregarProfesional(fisioterapeuta2);
        ListaProfesionales.agregarProfesional(nutricionista2);
        ListaProfesionales.agregarProfesional(optometrista2);
    }
	
	 public static void generarCita() {
	        Scanner scanner = new Scanner(System.in);

	        // se solicita el nombre del paciente primero.
	        System.out.print("Ingrese su nombre: ");
	        String nombrePaciente = scanner.nextLine();
	        
	        // se solicita el numero de identificación al paciente.
	        System.out.print("Ingrese su número de identificación: ");
	        int idPaciente = scanner.nextInt();
	        
	     // Solicitar la categoría del paciente
	        Categoria categoriaPaciente = obtenerCategoriaPorInput();
	        
	        // se crea un paciente con información proporcionada por el usuario- ¿como pedir la categoria?
	       
	        Paciente paciente = new Paciente(categoriaPaciente, idPaciente, nombrePaciente,"Masculino",0,0);
	        
	        // Se solicita la información de la especialidad para la que se desea tener cita.
	        System.out.print("Ingrese la especialidad (ORTOPEDISTA, FISIOTERAPEUTA, NUTRICIONISTA, OPTOMETRISTA): ");
	        String especialidadString = scanner.next();
	        Especialidad especialidad = Especialidad.valueOf(especialidadString);

	        
	       //Se pide la fecha para la cita.
	        System.out.print("Ingrese la fecha (dd/mm/yyyy): ");
	        String fecha = scanner.next();
	        
	     // Se encuentra un médico disponible con la especialidad seleccionada
	        Medico medicoDisponible = ListaProfesionales.buscarMedicoPorEspecialidad(especialidad);
	        
	        
	        //logica para terminar la creacion de la cita, se verifica que hay medicos disponibles para asignar al paciente.
	        if (medicoDisponible != null) {
	            // Se agenda la cita
	            Cita nuevaCita = paciente.agendarCita(medicoDisponible, fecha);

	            // Se informa al usuario sobre la cita agendada
	            System.out.println("¡Cita agendada con éxito!");
	            System.out.println("Médico: " + nuevaCita.getMedico().getNombre());
	            System.out.println("Especialidad: " + nuevaCita.getMedico().obtenerEspecialidad());
	            System.out.println("Fecha: " + nuevaCita.getFecha());
	        } else {
	            System.out.println("Lo sentimos, no hay médicos disponibles para la especialidad seleccionada.");
	        }
			scanner.close();
	    }



public static void generarCita(Paciente paciente) {
	         Scanner scanner = new Scanner(System.in);

	    //     // se solicita el nombre del paciente primero.
	    //     System.out.print("Ingrese su nombre: ");
	    //     String nombrePaciente = scanner.nextLine();
	        
	    //     // se solicita el numero de identificación al paciente.
	    //     System.out.print("Ingrese su número de identificación: ");
	    //     int idPaciente = scanner.nextInt();
	        
	    //  // Solicitar la categoría del paciente
	    //     Categoria categoriaPaciente = obtenerCategoriaPorInput();
	        
	    //     // se crea un paciente con información proporcionada por el usuario- ¿como pedir la categoria?
	       
	    //     Paciente paciente = new Paciente(categoriaPaciente, idPaciente, nombrePaciente);
	        
	        // Se solicita la información de la especialidad para la que se desea tener cita.
	        System.out.print("Ingrese la especialidad (ORTOPEDISTA, FISIOTERAPEUTA, NUTRICIONISTA, OPTOMETRISTA): ");
	        String especialidadString = scanner.next();
	        Especialidad especialidad = Especialidad.valueOf(especialidadString);

	        
	       //Se pide la fecha para la cita.
	        System.out.print("Ingrese la fecha (dd/mm/yyyy): ");
	        String fecha = scanner.next();
	        
	     // Se encuentra un médico disponible con la especialidad seleccionada
	        Medico medicoDisponible = ListaProfesionales.buscarMedicoPorEspecialidad(especialidad);
	        
	        
	        //logica para terminar la creacion de la cita, se verifica que hay medicos disponibles para asignar al paciente.
	        if (medicoDisponible != null) {
	            // Se agenda la cita
	            Cita nuevaCita = paciente.agendarCita(medicoDisponible, fecha);

	            // Se informa al usuario sobre la cita agendada
	            System.out.println("¡Cita agendada con éxito!");
	            System.out.println("Médico: " + nuevaCita.getMedico().getNombre());
	            System.out.println("Especialidad: " + nuevaCita.getMedico().obtenerEspecialidad());
	            System.out.println("Fecha: " + nuevaCita.getFecha());
	        } else {
	            System.out.println("Lo sentimos, no hay médicos disponibles para la especialidad seleccionada.");
	        }
			scanner.close();
	    }


	 public static Categoria obtenerCategoriaPorInput() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese su categoría (ALTO_RENDIMIENTO, OLIMPICO, AFICIONADOS): ");
	        String categoriaString = scanner.next();
	        return Categoria.valueOf(categoriaString);
	    }

}
