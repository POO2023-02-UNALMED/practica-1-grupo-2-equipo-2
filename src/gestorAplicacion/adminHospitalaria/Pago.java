/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.adminHospitalaria;

// Descripción: Esta interfaz representa un conjunto de métodos y constantes relacionados con el cálculo de pagos.
public interface Pago {
    static final double IVA = 0.19; // 19% de IVA

    // Método estático privado utilizado para calcular el valor total con IVA incluido.
    private static double valorIncluidoIVA(double total) {
        return total + (total * IVA);
    }

    // Método por defecto que calcula el valor total de un monto con IVA incluido.
    default double calcularTotalConIVA(double total) {
        return valorIncluidoIVA(total);
    }
    
    /* Método abstracto que debe ser implementado por las clases que implementan 
     la interfaz para obtener servicios pendientes de pago.*/
    public abstract String[] obtenerServiciosSinPagar();
}
