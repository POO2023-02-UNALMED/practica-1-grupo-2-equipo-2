/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package uiMain;

import java.util.Scanner;
import java.util.ArrayList;
import gestorAplicacion.sujeto.*;
import gestorAplicacion.serviciosOfrecidos.*;
import gestorAplicacion.adminHospitalaria.OrdenMedica;
import gestorAplicacion.instalaciones.Banco;
import gestorAplicacion.instalaciones.Habitacion;
import gestorAplicacion.instalaciones.Hospital;
import uiMain.Funcionalidades.F1;
import uiMain.Funcionalidades.F2;
import uiMain.Funcionalidades.F4;
import uiMain.Funcionalidades.F5;

public class Screen {
    
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
        System.out.println("Entrar \"quit\" para imprimir el Hospital");
        System.out.println("Entrar 0 para imprimir el Hospital                  , Funcionalidad 3");
        System.out.println("Entrar 1 para imprimir la lista de los Medicos      , Funcionalidad 3");
        System.out.println("Entrar 2 para anadir paciente                       , Funcionalidad 3");
        //System.out.println("Entrar 3 para imprimir la lista de pacientes        , Funcionalidad 3");
        System.out.println("Entrar 4 para generar cita por un paciente          , Funcionalidad 1");
        System.out.println("Entrar 5 para generar una rutina y ejercicios       , Funcionalidad 4"); 
        System.out.println("Entrar 7 para generar la orden medica                , Funcionalidad 2");
        System.out.println("Entrar 6 para la facturacion                        , Funcionalidad 5");

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

    public static void main(String[] args ){

        Screen.eraseScreen();
        final int maxHabitacion = 17;

        Scanner myObj = new Scanner(System.in);
        String choice = "";
        int loop = 1;
        int id;
        String sexo;
        int peso;
        int talla;
        String nombreEnfermedad;
        int cantidad;
        String tipologia;
        String sintomas;
        String recomendaciones;
        
        System.out.println("Entra el nombre del hospital");
        String nombre = myObj.nextLine();
        System.out.println("Entrar la direcion del hospital");
        String direcion = myObj.nextLine();
        Hospital h = new Hospital(nombre,direcion);
        Banco banco = new Banco();

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

        for (int i = 1;i<maxHabitacion;i++){
            h.habitaciones.add(new Habitacion(i));
        }


        do {
            Screen.eraseScreen();
            Screen.imprimirMenu(h);
            choice = myObj.nextLine();
            Screen.eraseScreen();


            switch (choice) {
                case "0":
                    Screen.imprimirHospital(h);
                    choice = myObj.nextLine();
                    break;

                case "1":
                    Screen.imprimirProfesionales();
                    choice = myObj.nextLine();
                    break;

                case "2":
                    System.out.println("Entrar nombre del paciente");
                    nombre = myObj.nextLine();
                    System.out.println("Entrar el id del paciente");
                    id = myObj.nextInt();
                    System.out.println("Entrar el sexo del paciente");
                    sexo = myObj.next();
                    System.out.println("Entrar el peso del paciente");
                    peso = myObj.nextInt();
                    System.out.println("Entrar la talla del paciente");
                    talla = myObj.nextInt();

                    Paciente p = new Paciente(F1.obtenerCategoriaPorInput(),id,nombre,sexo,peso,talla);
                    h.anadirPaciente(p);
                    choice = myObj.nextLine();
                    break;

                case "3":
                    break;

                case "4":
                    Screen.imprimirPacientes(h);
                    System.out.println("Entrar el id del paciente que desea una cita");
                    id = myObj.nextInt();
                    F1.generarCita(h.buscarPaciente(id));

                    choice = myObj.nextLine();

                    break;
                
                case "5":
                    Screen.imprimirPacientes(h);
                    System.out.println("Entrar el id del paciente que desea una cita");
                    id = myObj.nextInt();
                    F4.generarRutina(h.buscarPaciente(id));
                    F4.generarEjerciciosOrdenados();
                    break;
                
                case "6":
                    Screen.imprimirPacientes(h);
                    F5.facturacion(h, banco);
                    break;
                
                case "7":
                	System.out.println("================================================");
                	System.out.println("||   Registrar los datos de la orden medica   ||");
                	System.out.println("================================================");
                	
                	System.out.println(F2.azul + "Generando la orden medica en el sistema...... se tardara unos minutos" + F2.reiniciar);
                    System.out.println("Entrar nombre del paciente");
                    nombre = myObj.nextLine();
                    System.out.println("Entrar el id del paciente");
                    id = myObj.nextInt();
                    System.out.println("Entrar el sexo del paciente");
                    sexo = myObj.next();
                    System.out.println("Entrar el peso del paciente");
                    peso = myObj.nextInt();
                    System.out.println("Entrar la talla del paciente");
                    talla =myObj.nextInt();
                    
                    
                    Paciente paciente=new Paciente(F1.obtenerCategoriaPorInput(),id,nombre,sexo,peso,talla);
                	System.out.println("Nombre de la enfermedad");
                	nombreEnfermedad= myObj.next();
                	System.out.println("Ingrese la cantidad del paciente");
                	cantidad=myObj.nextInt();
                	System.out.println("Ingresar la especialidad del paciente");
                	Especialidad especialidad=F2.obtenerEspecialidad();
                	System.out.print("Ingrese la tipologia del paciente: ");
                	tipologia=myObj.next();
                	
                	
                	System.out.print("Ingrese los sintomas del paciente: ");
                	
                	sintomas=myObj.next();
                
                	
             
                	Medico medico=F2.asignarMedico();
                	System.out.println(medico);
                	
                   	Restriccion restriccion=F2.restriccionPaciente();
                   	Enfermedad enfermedad;
                	if(restriccion==null) {
                		enfermedad=new Enfermedad(nombreEnfermedad,cantidad,especialidad,tipologia,sintomas);
                		
                	}
                	else {
                		 enfermedad=new Enfermedad(nombreEnfermedad,cantidad,especialidad,tipologia,sintomas,restriccion);
                	}	
                	System.out.println("Escribir las recomendaciones que se le daran al paciente");
                	recomendaciones=myObj.next();
                	System.out.println("Generando orden medica......");
                	OrdenMedica ordenMedica= new OrdenMedica(paciente,enfermedad,medico,recomendaciones);
                	OrdenMedica crearOrden= F2.generarOrdenMedica(ordenMedica);
                	break;

                case "quit":
                    System.out.println("Gracias por uso ! Hasta Pronto en nuestro hospital \u001B[34m" + h.getNombre() +"\u001B[0m");
                    loop = 0;
                    choice = myObj.nextLine();
                    Screen.eraseScreen();
                    break;
            } 


        }while (loop == 1);

        myObj.close();
    } 
}
