/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.adminHospitalaria;

//Descripción: Esta clase se encarga ...
public interface Pago {
    static final double IVA = 0.19; // 19% de IVA

    private static double valorIncluidoIVA(double total) {
        return total + (total * IVA);
    }

    default double calcularTotalConIVA(double total) {
        return valorIncluidoIVA(total);
    }
    
    public abstract String obtenerServiciosSinPagar();
}
