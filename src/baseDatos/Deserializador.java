/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */


package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

//Importar las clases de las cuales sus objetos voy a deserializar
//En dichas clases debe ir:
//import baseDatos.Deserializador;

public class Deserializador {
	//Este atributo es para definir la ruta al directorio temp que contiene las clases
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	//Estee metodo se encarga de cargar las listas de objetos que hay almacenados (serializados)
	public static void deserializar() { //tiene como parametros mis clases
		File [] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for (File file : docs) {
			if(file.getAbsolutePath().contains("cosas")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					//asignar como atributo de la clase las cosas que lea
					//dpto.setAsignaturas((List<Asignatura> ois.readObject());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} 
				}else if (file.getAbsolutePath().contains("cosas")) {
					try {
						fis = new FileInputStream(file);
						ois = new ObjectInputStream(fis);
						
						//asignar como atributo de la clase las cosas que lea
						//dpto.setAsignaturas((List<Asignatura> ois.readObject());
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}	
			}
		}
}
