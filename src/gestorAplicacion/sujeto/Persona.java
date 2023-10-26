/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.sujeto;

/*La clase Persona representa a un individuo en el sistema. Contiene información básica como la categoría,
* número de identificación. Además, proporciona una representación detallada de los datos
* de la persona mediante el método "toString"
*/

public abstract class Persona {	
	
//Atributos
	protected Categoria categoria;
	protected int numeroIdentificacion;
	protected String nombre;

//Constructor principal
	public Persona (Categoria categoria, int numeroIdentificacion, String nombre) {
		this.categoria = categoria;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombre = nombre; //max 15 letters, if more needed, tell Léo please :) (some function he uses are based on nombre.lenght())
	}
	
    // Método toString para una representación detallada
    // Se usa el override porque se esta sobreescribien de object
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Número de Identificación: " + numeroIdentificacion + "\n" +
               "Categoría: " + categoria;
    }
    
    // Getters y setters para categoria
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Getters y setters para numeroIdentificacion
    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    // Getters y setters para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

