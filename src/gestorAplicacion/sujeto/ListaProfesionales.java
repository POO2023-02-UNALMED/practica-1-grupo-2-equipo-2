package gestorAplicacion.sujeto;

import java.util.ArrayList;
import java.util.List;

//Clase para almacenar los medicos del caso de prueba de los cuales se le asignará uno al usuario segun disponibilidad
public class ListaProfesionales {

    public static List<Medico> profesionales = new ArrayList<>();
    
// Se agregan medicos a la lista.
    public static void agregarProfesional(Medico medico) {
        profesionales.add(medico);
    }
//se entrega la lista de medicos
    public static List<Medico> obtenerProfesionales() {
        return profesionales;
    }
//metodo para buscar medicos por medio de su especialidad
    public static Medico buscarMedicoPorEspecialidad(Especialidad especialidad) {
        for (Medico medico : profesionales) {
            if (medico.getEspecialidad() == especialidad) {
                return medico;
            }
        }
        return null;
    }
}