/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package baseDatos;

//La serializacion es un proceso para convertir objetos 
//en un flujo de bytes de escritura
//Una vez convertidos en un flujo de bytes, estos objetos
//Se pueden escrbir en un archivo

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

//Importar las clases de las cuales sus objetos voy a serializar
//Recordar que si un objeto serializado contiene otros objetos
//Las clases de los objetos contenidos tambien deben implementar:
//java.io.Serializable


public class Serializador {

	
	public void serializar(Object objeto, String nombreArchivo) throws IOException {

		if (!nombreArchivo.endsWith(".dat"))
			nombreArchivo += ".dat";
		
		String rutaBase = "src\\baseDatos\\";
		String nombreArchivoTemp = rutaBase + "temp\\" + nombreArchivo;
		String nombreArchivoFinal = rutaBase + nombreArchivo;
		
		try (
			FileOutputStream fileOut = new FileOutputStream(nombreArchivoTemp);
			ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(objeto);
		}
		
		Files.move(Paths.get(nombreArchivoTemp), Paths.get(nombreArchivoFinal));
	}
	
}
