/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */
package gestorAplicacion.serviciosOfrecidos;
import java.util.ArrayList;
import gestorAplicacion.sujeto.*;

public class Rutina{
	
	//Atributos
	private ArrayList<Ejercicio>ejerciciosPosibles = new ArrayList<>();
	private int cantidadEjercicios;
	private ArrayList<Restriccion>restricciones = new ArrayList<>(); 
	private Paciente paciente;
	private ArrayList<Ejercicio>ejerciciosOrdenados = new ArrayList<>();
	private TipoTerapia tipoTerapia;
	private TipoObjetivo tipoObjetivo;
	
	public Rutina(Paciente paciente, TipoTerapia tipoTerapia, TipoObjetivo tipoObjetivo) {
		this.paciente = paciente;
		this.tipoTerapia = tipoTerapia;
		this.tipoObjetivo = tipoObjetivo;
		
		/*Al crear un objeto de esta instancia, se toman las enfermedades del paciente 
		 * que se encuentran dentro de una lista, obtiene su restriccion, esta es almacenada
		 * en la variable restriccionEnfermedad y se agrega en el Array restricciones */
		obtenerRestricciones();
		
		/* Este metodo toma todos los ejercicios del enum Ejercicio y por cada ejercicio comprara su restrccion
	 con todas las restricciones de la lista de restricciones, si la restriccion del 
	 ejercicio no esta en la lista la agrega al ArrayList ejerciciosPosibles  */
		obtenerejerciciosPosibles();
		
		this.cantidadEjercicios = ejerciciosOrdenados.size();
	}
	//Getter cantidadEjercicio
	
	public int getCantidadEjercicios() {
		return cantidadEjercicios;
	}
	
	//Getter ejerciciosPosibles
	public ArrayList<Ejercicio> getEjerciciosPosibles() {
		return ejerciciosPosibles;
	}
	
	//Getter restricciones
	public ArrayList<Restriccion> getRestricciones(){
		return restricciones;
	}
	
	//Setter restricciones
	public void setRestricciones(Restriccion[] args) {
		ArrayList<Restriccion>nuevasRestricciones = new ArrayList<>();
		for(int i = 0; i < args.length; i++) {
			nuevasRestricciones.add(args[i]);
		}
		
		this.restricciones.addAll(nuevasRestricciones);
		this.ejerciciosPosibles = new ArrayList<>();
		
		obtenerejerciciosPosibles();
	}
	
	//Getter paciente
	public Paciente getPaciente() {
		return paciente;
	}
	
	//Getter ejerciciosOrdenados
	public ArrayList<Ejercicio>getEjerciciosOrdenados(){
		return ejerciciosOrdenados;
	}
	
	//Setter ejerciciosOrdenados
	//Reemplaza la lista actual de ejerciciosOrdenados por una nueva lista
	public void setEjerciciosOrdenados(ArrayList<Ejercicio>ejerciciosOrdenados) {		
		this.ejerciciosOrdenados = ejerciciosOrdenados;
	}
	
	//Agraga nuevos elementos a la lista sin eliminarla
	public void agregarEjercicioOrdenado(Ejercicio ejercicio) {
		
		this.ejerciciosOrdenados.add(ejercicio);
	}
	
	//Eliminar ejercicio de la rutina
	//Este loop corre al reves para que pueda revisar cada ejercicio
	public void eliminarEjercicio(Ejercicio ejercicioEliminar) {
		int IDeliminar = ejercicioEliminar.getID();
		for(int i = this.ejerciciosOrdenados.size() -1; i>=0; i--) {
			if(this.ejerciciosOrdenados.get(i).getID() == IDeliminar) {
				ejerciciosOrdenados.remove(i);
			}
		}
	}
	
	private void obtenerRestricciones() {
		ArrayList<Enfermedad>listaEnfermedades = this.paciente.getHistoriaClinica().getHistorialEnfermedades();
		
		
		for (int i = 0; i < listaEnfermedades.size(); i++) {
			Restriccion restriccionEnfermedad = listaEnfermedades.get(i).getRestriccion();
			restricciones.add(restriccionEnfermedad);
			
		}
	}
	
	private void obtenerejerciciosPosibles() {
		Ejercicio[] todosLosEjercicios = Ejercicio.values();
		
		for(int i = 0; i < todosLosEjercicios.length; i++) {
			Ejercicio ejercicioEnum = todosLosEjercicios[i];
			CaracteristicasEjercicio caracteristicasEjercicio = ejercicioEnum.getEjercicio();
			Restriccion restriccionARevisar = caracteristicasEjercicio.getRestriccion();
			
			if(caracteristicasEjercicio.getTipoTerapia() == this.tipoTerapia) {
				if(caracteristicasEjercicio.getTipoObjetivo() == this.tipoObjetivo) {
					if (!restricciones.contains(restriccionARevisar)) {
						this.ejerciciosPosibles.add(ejercicioEnum);
						
					}
				}
			}
		}
	}
}
