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
	MARIPOSA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	PINZA_DE_PIE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	TRIANGULO_EXTENDIDO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	RUEDA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	LOTO_ELEVADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	LATERAL_INTENSO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	ARADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	CURL_DE_BICEPS(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	NATACION_EXPUESTA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	BRAZADAS_LATERALES(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	BRAZADAS_TRASERAS(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	CARRERA_MEDIA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	EXTENSION_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.RESPIRATORIA)),
	CARRERA_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.RESPIRATORIA)),
	FLEXIONES_DIAMANTE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.RESPIRATORIA)),
	ESTIRAMIENTO_CRUZADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.RESPIRATORIA)),
	ESTIRAMIENTO_PIERNA_LATERAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.FORTALECIMIENTO_MUSCULAR, Restriccion.RESPIRATORIA)),
	PRESS_DE_PECHO_CON_CABLE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FUERZA)),
	PRESS_DE_BANCA_CON_AGARRE_CERRADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FUERZA)),
	PRESS_DE_BANCA_CON_PIERNAS_ARRIBA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FUERZA)),
	PRESS_DE_BANCA_DECLINADO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FUERZA)),
	ROTACION_INCLINADA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	ROTACION_EXTERNA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	ELEVACION_FRONTAL_CON_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	REMO_POSTERIOR_SIN_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	REMO_INTERIOR_SIN_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.EQUILIBRIO)),
	ESTIRAMIENTO_POSTERIOR_CON_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	REMO_INTERIOR_CON_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	REMO_ELASTICO_CON_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	REMO_HORIZONTAL_CONBARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	ESTIRAMIENTO_INTERIOR_CON_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.FLEXIBILIDAD)),
	ALARGAMIENTO_CON_POLEA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	EXTENSION_CON_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	EXTENSION_SIMPLE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	ALARGAMIENTO_COMPUESTO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	EXTENSION_PECHO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.CARDIOVASCULAR)),
	ALARGAMIENTO_EN_MOVIMIENTO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.RESPIRATORIA)),
	EXTENSION_POLEA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.RESPIRATORIA)),
	CARDIO_DE_TENSION(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.RESPIRATORIA)),
	EXTENSION_LATERAL_EN_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.RESPIRATORIA)),
	ELEVACION_ALTA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_ELASTICIDAD, Restriccion.RESPIRATORIA)),
	CARRERA_MEDIA_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FUERZA)),
	CARRERA_LARGA_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FUERZA)),
	SALTO_CON_AGARRE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FUERZA)),
	ELEVACION_PIERNAS_EXTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FUERZA)),
	ELEVACION_PIERNAS_INTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FUERZA)),
	ELEVACION_PIERNAS_SOBRE_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.EQUILIBRIO)),
	ESTIRAMIENTO_SOBRE_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.EQUILIBRIO)),
	EXTENSION_CUADRICEP_FEMORAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.EQUILIBRIO)),
	ELEVACION_CON_UNA_PIERNA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.EQUILIBRIO)),
	VELOCIDAD_SOBRE_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.EQUILIBRIO)),
	ESTIRAMIENTO_COMPLETO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FLEXIBILIDAD)),
	APERTURA_LATERAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FLEXIBILIDAD)),
	ESTIRAMIENTO_MEDIO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FLEXIBILIDAD)),
	ELEVACION_CADERAS(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FLEXIBILIDAD)),
	EXTENSION_DE_DOMINIO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.FLEXIBILIDAD)),
	CARRERA_ALTA_VELOCIDAD(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.CARDIOVASCULAR)),
	CARRERA_DE_EXTENSION(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.CARDIOVASCULAR)),
	CARRERA_ACELERACION_COMPUESTA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.CARDIOVASCULAR)),
	CARRERA_ACELERACION_CONTINUA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.CARDIOVASCULAR)),
	CARRERA_VELOCIDAD_COMPLEMENTARIA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.CARDIOVASCULAR)),
	CARRERA_EN_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.RESPIRATORIA)),
	TENSION_EN_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.RESPIRATORIA)),
	CARRERA_PROFUNDA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.RESPIRATORIA)),
	CARRERA_DE_CONTENCION(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.RESPIRATORIA)),
	BARRERAS_VELOCIDAD(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.INCREMENTO_VELOCIDAD, Restriccion.RESPIRATORIA)),
	ARBOL_CON_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FUERZA)),
	EXTENSION_LATERAL_CON_PESO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FUERZA)),
	EXTENSION_CON_PESO_SOBRE_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FUERZA)),
	EXTENSION_CON_PESO_SOBRE_BARRA_INCLINADA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FUERZA)),
	CAMINATA_SOBRE_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FUERZA)),
	AGARRE_UNA_MANO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.EQUILIBRIO)),
	GIRO_UN_PIE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.EQUILIBRIO)),
	PIRAMIDE_SOBRE_BARRA_UN_PIE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.EQUILIBRIO)),
	POLEA_UNA_PIERNA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.EQUILIBRIO)),
	MONTANA_UNA_MANO_UNA_PIERNA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.EQUILIBRIO)),
	ALARGAMIENTO_UNA_PIERNA_EXTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	ALARGAMIENTO_UNA_PIERNA_INTERNO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	ELEVACION_PIERNAS_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	EXTENSION_UNA_PIERNA_EN_BARRA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	ELEVACION_CON_DISCO_OLIMPICO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.FLEXIBILIDAD)),
	EQUILIBRIO_EN_BARRA_ALTA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.CARDIOVASCULAR)),
	ELEVACION_EN_BARRA_LATERAL(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.CARDIOVASCULAR)),
	CARRERA_BARRA_UN_PIE(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.CARDIOVASCULAR)),
	INCLINACION_CON_DISCO_OLIMPICO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.CARDIOVASCULAR)),
	INCLINACION_TRASERA_CON_DISCOOLIMPICO(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.CARDIOVASCULAR)),
	ELEVACION_UN_PIE_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.RESPIRATORIA)),
	INCLINACION_EN_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.RESPIRATORIA)),
	EQUILIBRIO_EN_POLEA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.RESPIRATORIA)),
	CONTENCION_UNA_MANO_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.RESPIRATORIA)),
	CARRERA_LARGA_PISCINA(new CaracteristicasEjercicio(TipoTerapia.ACONDICIONAMIENTO, TipoObjetivo.MEJORA_DEL_EQUILIBIRIO, Restriccion.RESPIRATORIA)),
	RECUPERACION_ACTIVA_POLEA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FUERZA)),
	RECUEPACION_ACTIVA_MANCUERNAS(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FUERZA)),
	RECUPERACION_ACTIVA_DISCOS_OLIMPICOS(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FUERZA)),
	RECUPERACION_ACTIVA_TENSION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FUERZA)),
	RECUPERACION_ROPA_DE_COMPRESION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FUERZA)),
	RECUPERACION_UNILATERAL(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.EQUILIBRIO)),
	RECUPERACION_EN_BARRA_DE_EQUILIBRIO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.EQUILIBRIO)),
	INCLINACION_MUSCULAR(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.EQUILIBRIO)),
	SOPORTE_BARRA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.EQUILIBRIO)),
	SOPORTE_COMPRESION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.EQUILIBRIO)),
	REHABILITACION_ESTIRAMIENTO_COMPLETO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	REHABILITACION_DE_EXTENSION_COMPLETA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	REHABILITACION_ALARGAMIENTO_SIN_SOPORTE(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	FISIOTERAPIA_CON_EXTENSION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	EXTENSION_ALTA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.FLEXIBILIDAD)),
	FISIOTERAPIA_CONTROLADA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	CARRERA_CONTROLADA_CON_PESO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	RECUPERACION_DE_PASO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	TERAPIA_DE_MOVILIDAD_COMPLETA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	HIDROTERAPIA_DE_TENSION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.CARDIOVASCULAR)),
	HIDROTERAPIA_DE_ONDAS(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.RESPIRATORIA)),
	RECUPERACION_PIERNAS_PISCINA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.RESPIRATORIA)),
	RECUPERACION_EN_PROFUNDIDAD(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.RESPIRATORIA)),
	HIDROTERAPIA_DE_COMPRESION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.RESPIRATORIA)),
	RECUPERACION_ACTIVA_PISCINA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_MUSCULAR, Restriccion.RESPIRATORIA)),
	FORTALECIMIENTO_ARTICULACION_MANCUERNAS(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FUERZA)),
	FORTALECIMIENTO_ARTICULACION_POLEA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FUERZA)),
	FORTALECIMIENTO_ARTICULACION_DISCOS_OLIMPICOS(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FUERZA)),
	RECUPERACION_OSEA_PESO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FUERZA)),
	RECUPERACION_OSEA_PESO_ELEVADO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FUERZA)),
	INCLINACION_CON_BARRA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.EQUILIBRIO)),
	ELEVACION_DE_PIERNA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.EQUILIBRIO)),
	TENSION_EN_BARRA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.EQUILIBRIO)),
	TENSION_EN_ARTICULACION_BARRA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.EQUILIBRIO)),
	ESTIRAMIENTO_COMPLETO_ARTICULACION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FLEXIBILIDAD)),
	ESTIRAMIENTO_PARCIAL_ARTICULACION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FLEXIBILIDAD)),
	AMPLITUD_SIN_SOPORTE(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FLEXIBILIDAD)),
	AMPLITUD_CON_SOPORTE(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.FLEXIBILIDAD)),
	CIRCUITO_PARCIAL(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.CARDIOVASCULAR)),
	CIRCUITO_COMPLETO(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.CARDIOVASCULAR)),
	RECORRIDO_CON_TENSION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.CARDIOVASCULAR)),
	CIRCUITO_AMPLIO_CON_TENSION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.CARDIOVASCULAR)),
	HIDROTERAPIA_ALTA_TEMPERATURA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.RESPIRATORIA)),
	HIDROTERAPIA_BAJA_TEMPERATUERA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.RESPIRATORIA)),
	FISIOTERAPIA_ACUATICA(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.RESPIRATORIA)),
	FISIOTERAPIA_ACUATICA_CON_TENSION(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.RESPIRATORIA)),
	HIDROTERAPIA_CON_MASAJE(new CaracteristicasEjercicio(TipoTerapia.REHABILITACION, TipoObjetivo.RECUPERACION_LESION_OSEA, Restriccion.RESPIRATORIA));
	
	
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
