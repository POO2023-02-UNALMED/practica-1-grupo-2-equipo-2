package gestorAplicacion.adminHospitalaria;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Fecha{
	public int hora;
	public int dia;
	public int mes;
	public int año;
	public Date fecha;
	
	public Fecha(int dia, int mes, int año, int hora) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.hora = hora;
	}
	
	@Override
	public String toString() {
		return convertirInt(hora) + "-" + convertirInt(dia) + "-" + convertirInt(mes) + "-" + convertirInt(año);
	}
	
	public String convertirInt (int num) {
		String convertido = String.valueOf(num);
		return convertido;
	}
	
	public boolean comparar(Fecha fecha) {
	    return this.dia == fecha.dia && this.mes == fecha.mes && this.año == fecha.año;
	}
	
	
	public Date formatearFecha() throws ParseException {
		String fechaParaFormatear = this.hora + "/" + this.dia + "/" + this.mes + "/" + this.año; 
		SimpleDateFormat formato = new SimpleDateFormat("HH/dd/MM/yyyy");
		Date fechaFormateada = formato.parse(fechaParaFormatear);
		this.fecha = fechaFormateada;
		return fechaFormateada;
	}
	
	public static Date obtenerFechaActual () {
		Date fechaActual = new Date();
		return fechaActual;
	}
}
