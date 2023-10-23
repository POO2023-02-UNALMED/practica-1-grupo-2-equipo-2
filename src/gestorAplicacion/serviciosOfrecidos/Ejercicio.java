/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */
package gestorAplicacion.serviciosOfrecidos;
import gestorAplicacion.sujeto.Restriccion;


public enum Ejercicio {
	
	/*Este Enum contiene el nombre de los ejercicios en primer lugar, tiene un constructor privado
	 * que le asiga como atributo a cada elemento del Enum un objeto de tipo caracteristicasEjercicio
	 * y un ID basado en su posicion en el Enum*/
	
	ZANCADAS(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	HIP_THRUST(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	SENTADILLA_BULGARA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	SENTADILLA_SUMO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	PRENSA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	EXTENSION_CUADRICEPS_ARRIBA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.EQUILIBRIO)),
	EXTENSION_CUADRICEPS_ABAJO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.EQUILIBRIO)),
	HIP_ABDUCTOR_INTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.EQUILIBRIO)),
	HIP_ABDUCTOR_EXTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.EQUILIBRIO)),
	ZANCADA_UNILATERAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.EQUILIBRIO)),
	MARIPOSA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	PINZA_DE_PIE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	TRIANGULO_EXTENDIDO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	RUEDA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	LOTO_ELEVADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	LATERAL_INTENSO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	ARADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	CURL_DE_BICEPS(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.AUMENTO_RESISTENCIA_CARDIOVASCULAR, Restriccion.RESPIRATORIA)),
	NATACION_EXPUESTA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.RESPIRATORIA)),
	BRAZADAS_LATERALES(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.AUMENTO_RESISTENCIA_CARDIOVASCULAR, Restriccion.RESPIRATORIA)),
	BRAZADAS_TRASERAS(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.RESPIRATORIA)),
	CARRERA_LARGA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.AUMENTO_RESISTENCIA_CARDIOVASCULAR, Restriccion.RESPIRATORIA)),
	EXTENSION_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.AUMENTO_RESISTENCIA_CARDIOVASCULAR, Restriccion.RESPIRATORIA)),
	CARRERA_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.AUMENTO_RESISTENCIA_CARDIOVASCULAR, Restriccion.RESPIRATORIA)),
	FLEXIONES_DIAMANTE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	ESTIRAMIENTO_CRUZADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	ESTIRAMIENTO_PIERNA_LATERAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	ESTIRAMIENTO_INTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.RESPIRATORIA)),
	EXTENSION_CADERA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	PRESS_DE_HOMBRO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	PRESS_DE_HOMBRO_INCLINADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	PLANCHA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FUERZA)),
	PLANCHA_LATERAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.EQUILIBRIO));
	
	
	private CaracteristicasEjercicio ejercicio; //Este atributo hace que relacionemos un objeto de tipo Ejercicio con el objeto ubicado en el Enum Ejercicios.
	private final int ID;
	
	//Constructor de tipo privado porque pertenece a un Enum
	private Ejercicio(CaracteristicasEjercicio ejercicio) { //
		this.ejercicio = ejercicio;
		this.ID = ordinal(); //Ordinal: funcion de los Enum que devuelve la posicion de un objeto dentro del Enum
	}
	
	public CaracteristicasEjercicio getEjercicio() {
		return ejercicio;
	}
	
	public int getID() {
		return ID;
	}
	
	@Override
	public String toString() {
		return name();
	}
}
