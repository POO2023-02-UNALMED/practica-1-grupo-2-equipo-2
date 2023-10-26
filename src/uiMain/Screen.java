/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package uiMain;

import java.util.Scanner;
import java.util.ArrayList;
import gestorAplicacion.sujeto.*;
import gestorAplicacion.serviciosOfrecidos.*;
import gestorAplicacion.adminHospitalaria.*;
import gestorAplicacion.instalaciones.Banco;
import gestorAplicacion.instalaciones.Habitacion;
import gestorAplicacion.instalaciones.Hospital;
import uiMain.Funcionalidades.F0;
import uiMain.Funcionalidades.F1;
import uiMain.Funcionalidades.F2;
import uiMain.Funcionalidades.F4;
import uiMain.Funcionalidades.F5;

public class Screen {
    
	private static String TESTNOMBRE = "Athenea OlympiCare";
	private static String TESTDIRECCION = "Cra. 65 #59a-110";
	private static Banco BANCO = new Banco();
	public static Hospital HOSPITAL = new Hospital(TESTNOMBRE, TESTDIRECCION);
	public static Scanner SCANNER = new Scanner(System.in);
	
	
    //funcion para borrar la consola de control
    public static void eraseScreen(){
 
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    //function para imprimir la lista de los pacientes del hospital en parametro, usando la funcion toString de la clase Paciente 
    public static void imprimirPacientes(Hospital h){
        System.out.println("Lista de pacientes en el hospital hoy\n");
        if (h.pacientes.size() == 0)
            System.out.println("No hay nigun pacientes en el hosiptal");
        
        for(int i = 0; i<h.pacientes.size();i++){
            System.out.println(h.pacientes.get(i).toString()+"");
        }

        //System.out.println("\nPressiona ENTER para volver al menu");
    }

    //funcion para imprimir el menu principal de la applicacion
    public static void imprimirMenu(Hospital h){
        System.out.println("Bienvenido en el Hospital \u001B[34m" + h.getNombre() +"\u001B[0m");
        System.out.println("---- MENU ----");
        
        System.out.println("Entrar 1 para agendar cita             || Funcionalidad 1");
        System.out.println("Entrar 2 para generar orden medica     || Funcionalidad 2");
        System.out.println("Entrar 3 para asignar habitación       || Funcionalidad 3");
        System.out.println("Entrar 4 para generar rutina/terapia   || Funcionalidad 4");
        System.out.println("Entrar 5 para acceder a facturación    || Funcionalidad 5"); 
        System.out.println("Entrar 0 para administrar el Hospital  || No funcionalidad");
        System.out.println("Entrar \"quit\" para salir             || No funcionalidad");
    }
    

    //funcion grafica que imprime las habitaciones y sus habitantes en un plan y la lista de los pacientes
    public static void imprimirHospital(Hospital h){
        String espacio;
        System.out.println("Hospital : " +h.getNombre());
        System.out.println(" ________________________________________ ");
        for(int i = 0;i<h.habitaciones.size();i+=2){
            if(h.habitaciones.get(i).getId()<8)
                System.out.println("|       " + h.habitaciones.get(i).getId()+"       |        |       "+h.habitaciones.get(i+1).getId()+"       |");
            
            else if(h.habitaciones.get(i).getId()==9)
                System.out.println("|       " + h.habitaciones.get(i).getId()+"       |        |       "+h.habitaciones.get(i+1).getId()+"      |");
            else
                System.out.println("|       " + h.habitaciones.get(i).getId()+"      |        |       "+h.habitaciones.get(i+1).getId()+"      |");
            System.out.println("|               |        |               |");
            
            System.out.println("|    "+h.habitaciones.get(i).printOcupada()+"    |        |    "+h.habitaciones.get(i+1).printOcupada()+"    |");
            System.out.println("|               |        |               |");

            if(h.habitaciones.get(i).isOccupada() && h.habitaciones.get(i+1).isOccupada())
                System.out.println("|"+h.habitaciones.get(i).getPaciente().spaceNombreLeft() +h.habitaciones.get(i).getPaciente().getNombre()+ h.habitaciones.get(i).getPaciente().spaceNombreRight()+"|        |"+h.habitaciones.get(i+1).getPaciente().spaceNombreLeft()+ h.habitaciones.get(i+1).getPaciente().getNombre()+ h.habitaciones.get(i+1).getPaciente().spaceNombreRight()+"|");
            else if((h.habitaciones.get(i).isOccupada()) && h.habitaciones.get(i+1).isOccupada() == false)
                System.out.println("|"+h.habitaciones.get(i).getPaciente().spaceNombreLeft() +h.habitaciones.get(i).getPaciente().getNombre()+ h.habitaciones.get(i).getPaciente().spaceNombreRight()+"|        |               |");
            else if(h.habitaciones.get(i).isOccupada() == false && h.habitaciones.get(i+1).isOccupada())
                System.out.println("|               |        |"+h.habitaciones.get(i+1).getPaciente().spaceNombreLeft() +h.habitaciones.get(i+1).getPaciente().getNombre()+ h.habitaciones.get(i+1).getPaciente().spaceNombreRight()+"|");
            else
                System.out.println("|               |        |               |");

            if(i+2<h.habitaciones.size())
                System.out.println(" ________________        ________________ ");
            else
                System.out.println("|________________________________________|");
        }
        System.out.println("\n");

        for(int i = 0; i<h.habitaciones.size();i++){
            if (i < 9){
                espacio = " ";
            }
            else
                espacio = "";
    
            if(h.habitaciones.get(i).isOccupada())
                System.out.println("Habitacion n° : " +espacio+ (i+1) +" "+h.habitaciones.get(i).printOcupada() + h.habitaciones.get(i).getPaciente().toString());
            else
                System.out.println("Habitacion n° : " +espacio+ (i+1)+" "+h.habitaciones.get(i).printOcupada());
        }
        System.out.println("(Pressiona ENTER para volver al menu)");
    }

    //funcion que imprime la lista de todos los Medicos del hospital
    public static  void imprimirProfesionales(){
        for (int i = 0; i<ListaProfesionales.profesionales.size();i++){
            System.out.println(ListaProfesionales.profesionales.get(i).toString());
            System.out.println("\n");
        }
    }
    
    // funcion para pedir genero
    public static String pedirSexo() {
    	String sexo;
        Scanner SCANNER = new Scanner(System.in);

    	do {
    		System.out.println("Entra el sexo del paciente, elige entre M para masculino o F para femenino:");
    		sexo = SCANNER.nextLine().toUpperCase();
    		
    		if (!sexo.equals("F") && !sexo.equals("M")) {
        		System.out.println("Entrada inválida, por favor intente de nuevo.");
    		}

    	} while(!sexo.equals("F") && !sexo.equals("M"));
    	
    	return sexo;
    }

    public static void main(String[] args ){

        Screen.eraseScreen();
        final int maxHabitacion = 17;

        Scanner SCANNER = new Scanner(System.in);
        
        int id;
        String sexo;
        int peso;
        int talla;
        String nombreEnfermedad;
        int cantidad;
        String tipologia;
        String sintomas;
        String recomendaciones;
        

        Hospital h = HOSPITAL;
        
        // algunos Medicos- caso de prueba.
        Medico ortopedista = new Medico(Categoria.ALTO_RENDIMIENTO, 78964, "Dr. Pérez", Especialidad.ORTOPEDISTA);
        Medico fisioterapeuta = new Medico(Categoria.OLIMPICO, 789013, "Dr. Pepe", Especialidad.FISIOTERAPEUTA);
        Medico nutricionista = new Medico(Categoria.AFICIONADOS, 789014, "Dra. Molly", Especialidad.NUTRICIONISTA);
        Medico optometrista = new Medico(Categoria.OLIMPICO, 789015, "Dra. Margarita", Especialidad.OPTOMETRISTA);

        //Los medicos de prueba se guaradan en una lista.
        ListaProfesionales.agregarProfesional(ortopedista);
        ListaProfesionales.agregarProfesional(fisioterapeuta);
        ListaProfesionales.agregarProfesional(nutricionista);
        ListaProfesionales.agregarProfesional(optometrista);

        Paciente pacientePrueba1 = new Paciente(Categoria.AFICIONADOS, 345, "Tartaglia", "M", 68, 179); 
		Paciente pacientePrueba2 = new Paciente(Categoria.ALTO_RENDIMIENTO, 567, "Zhongli", "M", 80, 190); 
		Paciente pacientePrueba3 = new Paciente(Categoria.OLIMPICO, 789, "Furina", "F", 50, 150); 

		HOSPITAL.anadirPaciente(pacientePrueba3);
		HOSPITAL.anadirPaciente(pacientePrueba2);
		HOSPITAL.anadirPaciente(pacientePrueba1);
		
		pacientePrueba3.getCuentaBancaria().setSaldo(20000);
		pacientePrueba1.getCuentaBancaria().setSaldo(10000);
		pacientePrueba1.getCuentaBancaria().setEstadoDeReporte(true);
		pacientePrueba2.getCuentaBancaria().setSaldo(0);
		pacientePrueba2.getCuentaBancaria().setEstadoDeReporte(false);
		
		
		Enfermedad enfermedad1 = new Enfermedad("Eleazar", 3, Especialidad.FISIOTERAPEUTA, "ConocmientoProhibido", "Escamas");
		Enfermedad enfermedad2 = new Enfermedad("PilarCelestial", 4, Especialidad.OPTOMETRISTA, "ConocmientoProhibido", "Muerte instantanea");
		Enfermedad enfermedad3 = new Enfermedad("DesastreKaenheria", 5, Especialidad.NUTRICIONISTA, "ConocmientoProhibido", "Maldiciones:inmortalidad, convertirse en monstruo");
        Enfermedad enfermedad4 = new Enfermedad("InundacionRemuria", 6, Especialidad.ORTOPEDISTA, "ConocmientoProhibido", "Ahogamiento");


        Fecha fecha1 = new Fecha(4,5,2023,10);
        Fecha fecha2 = new Fecha(19,7,2023,14);
        Fecha fecha3 = new Fecha(1,1,2023,8);
        Fecha fecha4 = new Fecha(23,9,2023,17);
        Fecha fecha5 = new Fecha(30,12,2023,12);
        Fecha fecha6 = new Fecha(13,10,2023,13);
        
        Cita cita1 = pacientePrueba1.agendarCita(ortopedista, fecha1 , Tipo.CIRUGIA, Especialidad.ORTOPEDISTA); //Cirugia
		Cita cita2 = pacientePrueba2.agendarCita(ortopedista, fecha2 , Tipo.CIRUGIA, Especialidad.ORTOPEDISTA); //Cirugia
        Cita cita3 = pacientePrueba2.agendarCita(optometrista, fecha3, Tipo.TERAPIA, Especialidad.OPTOMETRISTA); //Terapia
		Cita cita4 = pacientePrueba3.agendarCita(ortopedista, fecha4, Tipo.CIRUGIA, Especialidad.ORTOPEDISTA); //Cirugia
		Cita cita5 = pacientePrueba3.agendarCita(nutricionista , fecha5, Tipo.CONSULTA, Especialidad.NUTRICIONISTA); //Consulta
		Cita cita6 = pacientePrueba3.agendarCita(fisioterapeuta, fecha6, Tipo.CONSULTA, Especialidad.FISIOTERAPEUTA); //Consulta

        Cirugia cirugia1 = new Cirugia(Especialidad.ORTOPEDISTA, enfermedad4, cita6);
		Cirugia cirugia2 = new Cirugia(Especialidad.ORTOPEDISTA, enfermedad4, cita1);
		Cirugia cirugia3 = new Cirugia(Especialidad.ORTOPEDISTA, enfermedad4, cita3);
		Terapia terapia1 = new Terapia(Especialidad.OPTOMETRISTA, enfermedad2, cita2, 60);
		Consulta consulta1 = new Consulta(Especialidad.NUTRICIONISTA, enfermedad3, cita4);
		Consulta consulta2 = new Consulta(Especialidad.FISIOTERAPEUTA, enfermedad1, cita5);
		
		
		pacientePrueba1.actualizarHistorialCirugias(cirugia2);
        pacientePrueba2.actualizarHistorialTerapias(terapia1);
		pacientePrueba2.actualizarHistorialCirugias(cirugia3);
        pacientePrueba3.actualizarHistorialCirugias(cirugia1);
		pacientePrueba3.actualizarHistorialConsultas(consulta1);
		pacientePrueba3.actualizarHistorialConsultas(consulta2);
		

        for (int i = 1;i<maxHabitacion;i++){
            h.habitaciones.add(new Habitacion());
        }

		Paciente p=null;
		int loop = 1;

        String eleccionExterna = "";
        String eleccionInterna = "";
        
        do {
            Screen.eraseScreen();
            Screen.imprimirMenu(h);
            eleccionExterna = SCANNER.nextLine();
            Screen.eraseScreen();
            

            switch (eleccionExterna) {
                case "1":
                    screenAgendarCita();
                    break;
                    
                case "2":
                    screenOrdenMedica();
                    break;

                case "3":
                    screenAsignarHabitacion();
                    break;

                case "4":
                    screenGenerarRutinas();
                    break;

                case "5":
                    screenFacturacion();
                    break;
                
                case "0":
                	System.out.println("Entrar 1 para agregar un paciente");
                    System.out.println("Entrar 2 para agregar un medico");
                    System.out.println("Entrar 3 para agregar una enfermedad");
                    eleccionInterna = SCANNER.nextLine();
                    switch (eleccionInterna) {
                    case "1":
                    	screenAgregarPaciente();
                    	break;
                    case "2":
                    	screenAgregarMedico();
                    	break;
                    case "3":
                    	screenAgregarEnfermedad();
                    	break;
                    }
                    
                    
                case "quit":
                    System.out.println("Gracias por uso ! Hasta Pronto en nuestro hospital \u001B[34m" + h.getNombre() +"\u001B[0m");
                    loop = 0;
                    Screen.eraseScreen();
                    break;
                    
                default:
                	System.out.println("Opción no válida, intente de nuevo");
                	break;
            } 
            
            if (loop == 1) {
                String continuar = F0.obtenerEleccionDeSioNo("Deseas hacer algo más en la aplicación?");
                if (continuar.equals("N")) {
                	System.out.println("Gracias por uso ! Hasta Pronto en nuestro hospital \u001B[34m" + h.getNombre() +"\u001B[0m");
                	loop = 0;
                }

            }
            
        }while (loop == 1);

        SCANNER.close();
    }


    // Metodos menu

    public static void screenAgendarCita() {
		imprimirPacientes(HOSPITAL);
        Paciente paciente = F0.obtenerPacientePorInput();
		F1.generarCita(paciente);
    }
    
    public static void screenOrdenMedica(){
    	Paciente paciente = F0.obtenerPacientePorInput();
    	Cita cita = paciente.getUltimaCita();
    	if (cita == null) {
    		System.out.println("El paciente no tiene citas en el registro");
    		return;
    	} 
    	Especialidad especialidad = cita.getMedico().getEspecialidad();
    	Enfermedad enfermedad = F0.obtenerEnfermedadPorInput();
    	int peso = F0.obtenerEnteroPorInput("Entrar el peso del paciente:");
    	paciente.setPeso(peso);
    	int talla = F0.obtenerEnteroPorInput("Entrar la talla del paciente:");
	 	paciente.setTalla(talla);
	 	
	 	Consulta consulta = new Consulta(especialidad, enfermedad, cita);
	 	F2.screenOrdenMedica(consulta);
    }
      
    public static void screenAsignarHabitacion() {
    	Screen.imprimirHospital(h);
        choice = SCANNER.nextLine();
        
        Screen.imprimirProfesionales();
        choice = SCANNER.nextLine();
        
        System.out.println("Entrar nombre del paciente");
        String nombre = SCANNER.nextLine();
        id = F0.obtenerEnteroPorInput("Entrar el id del paciente:");
        System.out.println("Entrar el sexo del paciente");
        sexo = pedirSexo();
        peso = F0.obtenerEnteroPorInput("Entrar el peso del paciente:");
        talla = F0.obtenerEnteroPorInput("Entrar la talla del paciente:");

        p = new Paciente(F0.obtenerCategoriaPorInput(),id,nombre,sexo,peso,talla);
        h.anadirPaciente(p);
        h.asignarHabitacion(p);
        choice = SCANNER.nextLine();
    }
    
    public static void screenGenerarRutinas () {
		imprimirPacientes(HOSPITAL);
        Paciente paciente = F0.obtenerPacientePorInput();
        F4.screenRutina(paciente);
        
    }
    
    public static void screenFacturacion () {
    	Screen.imprimirPacientes(HOSPITAL);
        F5.facturacion(HOSPITAL, BANCO);
    }

  
    public static void screenAgregarPaciente() {
        System.out.println("Entrar nombre del paciente: ");
        String nombre = SCANNER.nextLine();
        int id = F0.obtenerEnteroPorInput("Ingresar el num de identificacion: ");
        String sexo = pedirSexo();
        int peso = F0.obtenerEnteroPorInput("Entrar el peso del paciente:");
        int talla = F0.obtenerEnteroPorInput("Entrar la talla del paciente:");
        Categoria categoria = F0.obtenerCategoriaPorInput();
        
        Paciente paciente = new Paciente(categoria,id,nombre,sexo,peso,talla);
        HOSPITAL.anadirPaciente(paciente);
        HOSPITAL.asignarHabitacion(paciente);
    }
    
    public static void screenAgregarMedico() {
        System.out.println("Entrar nombre del medico: ");
        String nombre = SCANNER.nextLine();
        int id = F0.obtenerEnteroPorInput("Ingresar el num de identificacion: ");
        Categoria categoria = F0.obtenerCategoriaPorInput();
        Especialidad especialidad = F0.obtenerEnumPorInput(Especialidad.class, "Ingrese la especidalidad");
        
        Medico medico = new Medico(categoria, id, nombre, especialidad);
        HOSPITAL.addMedicos(medico);
    }
    
    public static void screenAgregarEnfermedad() {
        System.out.println("Entrar nombre de la enfermedad: ");
        String nombre = SCANNER.nextLine();
        int cantidad = F0.obtenerEnteroPorInput("Ingresar la cantidad: ");
        Especialidad especialidad = F0.obtenerEnumPorInput(Especialidad.class, "Ingrese la especidalidad");
        System.out.println("Entrar nombre de la tipologia: ");
        String tipologia = SCANNER.nextLine();
        System.out.println("Entrar los sintomas: ");
        String sintomas = SCANNER.nextLine();
        Restriccion restriccion = F0.obtenerEnumPorInput(Restriccion.class, "Ingrese la restriccion: ");
         
        
       Enfermedad enfermedad = new Enfermedad(nombre, cantidad, especialidad, tipologia, sintomas, restriccion);
       HOSPITAL.addEnfermedad(enfermedad);
    }
    
    
}
    
