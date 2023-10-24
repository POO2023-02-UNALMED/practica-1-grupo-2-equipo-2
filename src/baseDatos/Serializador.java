/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package baseDatos;

//La serializacion es un proceso para convertir objetos 
//en un flujo de bytes de escritura
//Una vez convertidos en un flujo de bytes, estos objetos
//Se pueden escrbir en un archivo

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


//Importar las clases de las cuales sus objetos voy a serializar
//Recordar que si un objeto serializado contiene otros objetos
//Las clases de los objetos contenidos tambien deben implementar:
//java.io.Serializable


public class Serializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	//Este método es el encargado de seralizar las listas que están creadas 
	//en las clases que importe previamente
	//le paso como parametros dichas clases
	
	//Por cada clase debe ir un metodo serializar
	public static void serializar() {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;
		
		//Este método for borra el contenido de los archivos al momento de guardar los objetos para evitar
		//que haya redundancia en los archivos y futuras complicaciones para buscar
		for (File file: docs) {
			try {
				//Al crear este objeto PrintWriterr y pasarle como parámetro, la ruta de cada
				//archivo borra lo que haya en ellos automáticamente.
				
				pw = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		for (File file: docs) {
			if(file.getAbsolutePath().contains("cosas")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					//oos.writeObject(); como parametro va aquello que yo quiero escribir de las clases
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();}
			} else if (file.getAbsolutePath().contains("mas cosas")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					//oos.writeObject(); como parametro va aquello que yo quiero escribir de las clases
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();}
			}
		}	
	}
}
