
package uiMain.Funcionalidades;

import gestorAplicacion.sujeto.*;
import uiMain.Screen;
import gestorAplicacion.adminHospitalaria.*;
import gestorAplicacion.instalaciones.Hospital;
import gestorAplicacion.serviciosOfrecidos.Tipo;
import java.text.ParseException;


import java.util.Scanner;
import java.util.ArrayList;
import static uiMain.Screen.SCANNER;
import java.util.Calendar;

public class F1 {
	

	// EL HOSPITALXD
	private static String TESTNOMBRE = "testNombre";
	private static String TESTDIRECCION = "testDireccion";
	private static Hospital HOSPITAL = new Hospital(TESTNOMBRE, TESTDIRECCION);
	static Scanner SCANNER_CITA = SCANNER;
	
	
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


	 	public static void generarCita(Paciente paciente) {

	        
	        // Se solicita la información de la especialidad para la que se desea tener cita.
	         
	        Tipo tipo = F0.obtenerEnumPorInput(Tipo.class, "Ingrese el tipo de cita deseada: ");
	        Especialidad especialidad = F0.obtenerEnumPorInput(Especialidad.class, "Ingrese la especialidad (ORTOPEDISTA, FISIOTERAPEUTA, NUTRICIONISTA, OPTOMETRISTA): ");
	        Categoria categoria = paciente.getCategoria();
	        
	       //Se pide la fecha para la cita.
	        Fecha fecha = obtenerFechaPorInput();
	        
	        
	     // Se encuentra un médico disponible con la especialidad seleccionada
	        
	        ArrayList<Medico> medicosDisponibles = generarListaMedicos(especialidad, categoria, fecha);

	        
	        //logica para terminar la creacion de la cita, se verifica que hay medicos disponibles para asignar al paciente.
	        if (medicosDisponibles.size() != 0) {
	        	for (Medico medico : medicosDisponibles) {
		        	System.out.println(medico);
		        }
	        	Medico medicoElegido = obtenerMedicoPorInput();
	            // Se agenda la cita
	            Cita nuevaCita = paciente.agendarCita(medicoElegido, fecha, tipo, especialidad);

	             System.out.println("--------------------------------------------------");
	            System.out.println("|               Hoja de Cita Médica              |");
	            System.out.println("--------------------------------------------------");
	            System.out.println("| Paciente:" + paciente.getNombre()+"                                  |");
	            System.out.println("| ID:" + paciente.getNumeroIdentificacion()+"                                        |");
	            System.out.println("| Categoría:" + paciente.getCategoria()+"                             |");
	            System.out.println("| Especialidad:" + nuevaCita.getMedico().getEspecialidad()+"                      |");
	            System.out.println("| Médico:" + nuevaCita.getMedico().getNombre()+"                          |");
	            System.out.println("| Fecha:" + nuevaCita.getFecha()+"                               |");
	            System.out.println("--------------------------------------------------");
	        } else {
	            System.out.println("Lo sentimos, no hay médicos disponibles para la fecha seleccionada.");
	        }
	    }


 	public static Fecha obtenerFechaPorInput() {
 	    Fecha fecha = null;
 	    int dia = 0;
 	    int mes = 0;
 	    int año = 0;
 	    int hora = 0;
 	    int APERTURA = 7;
 	    int CIERRE = 22;
 	    int LIMITEAÑO = 2024;
 	    int AÑOACTUAL = 2023;

 	    // Obtener fecha actual
 	    Calendar now = Calendar.getInstance();
 	    int diaActual = now.get(Calendar.DAY_OF_MONTH);
 	    int mesActual = now.get(Calendar.MONTH) + 1;  // +1 porque en Java los meses comienzan en 0
 	    int añoActual = now.get(Calendar.YEAR);

 	    do {
 	        año = F0.obtenerEnteroConLimitePorInput(AÑOACTUAL, LIMITEAÑO, "Ingrese el año deseado para la cita:");
 	        mes = F0.obtenerEnteroConLimitePorInput(1, 12, "Ingrese el mes deseado para la cita:");
 	        if (mes == 1 || mes == 3 || mes == 4 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
 	            dia = F0.obtenerEnteroConLimitePorInput(1, 31, "Ingrese el día deseado para la cita (de 1 a 31):");
 	        }
 	        else if (mes == 5 || mes == 6 || mes == 9 || mes == 11) {
 	            dia = F0.obtenerEnteroConLimitePorInput(1, 30, "Ingrese el día deseado para la cita (de 1 a 30):");
 	        }
 	        else {
 	            dia = F0.obtenerEnteroConLimitePorInput(1, 28, "Ingrese el día deseado para la cita (de 1 a 28) :");
 	        }

 	        hora = F0.obtenerEnteroConLimitePorInput(APERTURA, CIERRE, String.format("Ingrese la hora deseada para la cita en formato militar y sin ingresar minutos, números enteros entre %d y %d", APERTURA, CIERRE));
 	        
 	        fecha = new Fecha(dia, mes, año, hora);
 	        
 	        if (año < añoActual || (año == añoActual && mes < mesActual) || (año == añoActual && mes == mesActual && dia < diaActual)) {
 	            System.out.println("La fecha no puede ser anterior a la fecha actual. Intente de nuevo.");
 	            fecha = null;  // Esto es para que el bucle continúe
 	        }

 	    } while(fecha == null);
 	    return fecha;
 	}
     

	 public static Medico obtenerMedicoPorInput() {
		 Medico medicoObtenido = null;
		 String ID;
		 long IDConvertido = 0;
		 
		 do {
			 System.out.println("Por favor ingrese el numero de identificacion del médico que desea seleccionar, sin espacios ni guiones: ");
			 ID = SCANNER_CITA.nextLine();
			 
			 try {
				 IDConvertido = Integer.parseInt(ID);
			 } catch (IllegalArgumentException e) {
		            System.out.println("Entrada inválida, por favor intente de nuevo.");
			 }
		 } while( IDConvertido == 0);
		 
		 
		 for (Medico medico : F1.HOSPITAL.getListaMedicos()) {
			 if (medico.getNumeroIdentificacion() == IDConvertido) {
				 medicoObtenido = medico;
				 return medicoObtenido; // Si encuentra, retorna el médico y rompe el método para no gastar recursos
			 }
		 }
		 
		 return medicoObtenido; // Si no encuentra, retorna null
	 }
	 
	 
	 //Revisa la agenda, categoria y especialidad y regresa solo los disponibles para las opciones seleccionadas
	 public static ArrayList<Medico> generarListaMedicos (Especialidad especialidad, Categoria categoria, Fecha fecha){
		 ArrayList <Medico> medicosDisponibles = new ArrayList<>();
		 ArrayList <Medico> medicosPosibles = new ArrayList<>();
		 Medico medicoExcluido = null;
		 
		 for (Medico medico : F1.HOSPITAL.getListaMedicos()) {
			 if (medico.getCategoria() == categoria && medico.getEspecialidad() == especialidad) {
				 medicosPosibles.add(medico);
			 }
		 }
		 
		 for (Medico medico : medicosPosibles) {
			 for (Cita cita: medico.getAgenda()) {
				 if (cita.getFecha().comparar(fecha)) {
					 medicoExcluido = medico;
				 }
			 }
			 if (medicoExcluido.getNombre() != medico.getNombre()) {
				 medicosDisponibles.add(medico);
			 }
		 }
		 
		 return medicosDisponibles;
	 }
}
