/* Autores: Maria P. Ardila, Jose N. Duque, 
 * Ronal Y. Castro, Daniela C. García y Leopold P. Lanard
 */

package gestorAplicacion.sujeto;

import java.util.ArrayList;

import gestorAplicacion.adminHospitalaria.*;
import gestorAplicacion.instalaciones.*;
import gestorAplicacion.serviciosOfrecidos.*;

public class Paciente extends Persona implements Pago{

	private ArrayList<Tratamiento> serviciosSinPagar = new ArrayList<>();
	private ArrayList<Tratamiento> serviciosSeleccionados = new ArrayList<>();

	// Atributos
        private HistoriaClinica historiaClinica;
        
        /*Aplica ligadura dinamica porque entran objetos de tipo consulta, terapia y cirugia */
        private final ArrayList<Consulta> consultas; 
        private Habitacion habitacionAsignada;
        private CuentaBancaria cuentaBancaria; 
        private String sexo;
        private int peso;
        private int talla;


    
    // Constructor principal
    public Paciente(Categoria categoria, int numeroIdentificacion, String nombre,String sexo,int peso,int talla) {
		super(categoria, numeroIdentificacion, nombre);
		this.historiaClinica = new HistoriaClinica(this); 
		this.cuentaBancaria =  new CuentaBancaria();
        this.consultas = new ArrayList<>();
        this.sexo = sexo;
        this.peso = peso;
        this.talla = talla;
	} 

    @Override
    public String toString() {
        return "nombre : \u001B[34m"+this.nombre +"\u001B[0m id : \u001B[34m"+ this.numeroIdentificacion +"\u001B[0m categoria \u001B[34m" + this.categoria+"\u001B[0m peso : \u001B[34m"+ this.peso +"\u001B[0m sexo : \u001B[34m"+ this.sexo +"\u001B[0m talla : \u001B[34m"+ this.talla+"\u001B[0m";
    }
    
    // ----------------------------------------------------------------------------- //
    
    @Override
    public String obtenerServiciosSinPagar() {
        StringBuilder infoServiciosSinPagar = new StringBuilder();
        serviciosSinPagar.clear(); // Limpia la lista en caso de llamadas múltiples

        // Recorre las consultas sin pagar y agrega al listado de servicios sin pagar
        for (Consulta consulta : historiaClinica.getHistorialConsultas()) {
            if (!consulta.isPagada()) {
                serviciosSinPagar.add(consulta);
            }
        }

        // Recorre las cirugías sin pagar y agrega al listado de servicios sin pagar
        for (Cirugia cirugia : historiaClinica.getHistorialCirugias()) {
            if (!cirugia.isPagada()) {
                serviciosSinPagar.add(cirugia);
            }
        }

        // Recorre las terapias sin pagar y agrega al listado de servicios sin pagar
        for (Terapia terapia : historiaClinica.getHistorialTerapias()) {
            if (!terapia.isPagada()) {
                serviciosSinPagar.add(terapia);
            }
        }

        // Verifica si hay servicios sin pagar
        if (!serviciosSinPagar.isEmpty()) {
            infoServiciosSinPagar.append("Total de servicios sin Pagar: ").append(serviciosSinPagar.size()).append("\n");

            // Recorre la lista de servicios sin pagar y agrega la información al StringBuilder
            for (int i = 0; i < serviciosSinPagar.size(); i++) {
                Tratamiento servicio = serviciosSinPagar.get(i);
                infoServiciosSinPagar.append("Servicio N°").append(i).append("\n").append(servicio.toString());
            }
        } else {
            return "No hay servicios pendientes de pago";
        }

        return infoServiciosSinPagar.toString();
    }
    
    // ----------------------------------------------------------------------------- //

 
    public double[] seleccionarServiciosAPagar(String indices) {
        // Divide la cadena de índices en un array de strings
        String[] indicesArray = indices.split(",");
        
        // Inicializa el costo total en 0.0
        double costoTotal = 0.0;

        // Limpia los servicios seleccionados antes de agregar los nuevos
        serviciosSeleccionados.clear();

        // Recorre los índices especificados por el usuario
        for (String indiceStr : indicesArray) {
            // Convierte el índice en un número entero
            int indice = Integer.parseInt(indiceStr);
        
            // Verifica que el índice esté dentro del rango de serviciosSinPagar
            if (indice >= 0 && indice < serviciosSinPagar.size()) {
                // Obtiene el servicio correspondiente al índice
                Tratamiento servicio = serviciosSinPagar.get(indice);
            
                // Agrega el servicio seleccionado a serviciosSeleccionados
                serviciosSeleccionados.add(servicio);

                // Calcula el costo del servicio y lo agrega al costo total
                double costoServicio = servicio.calcularPrecio(this);
                costoTotal += costoServicio;
        }
    }

        // Aplica descuento si se cumplen ciertas condiciones
        if (indicesArray.length >= 5) {
            double descuento = 0.0;
            if (indicesArray.length >= 20) {
                descuento = 0.5;  // Descuento del 50% para 20 o más servicios
            } else if (indicesArray.length >= 15) {
                descuento = 0.4;  // Descuento del 40% para 15 o más servicios
            } else if (indicesArray.length >= 10) {
                descuento = 0.3;  // Descuento del 30% para 10 o más servicios
            } else if (indicesArray.length >= 5) {
                descuento = 0.2;  // Descuento del 20% para 5 o más servicios
            }

        // Aplica el descuento al costo total
        double costoTotalConDescuento = costoTotal - costoTotal * descuento;

        // Calcula el costo total con IVA incluido
        double costoTotalConIVA = calcularTotalConIVA(costoTotalConDescuento);
        
        // Retorna los tres costos
        return new double[] { costoTotal, costoTotalConDescuento, costoTotalConIVA };
    } else {
        // No se aplica descuento, por lo que el costo total con descuento es igual al costo total
        // Calcula el costo total con IVA incluido
        double costoTotalConIVA = calcularTotalConIVA(costoTotal);
        return new double[] { costoTotal, costoTotal, costoTotalConIVA };
    }
}
    
    // ----------------------------------------------------------------------------- //

    public void marcarServiciosComoPagados() {
        for (Tratamiento servicio : serviciosSeleccionados) {
            servicio.marcarComoPagada();
        }
    }
    

//funcion grafica utilisada en la clase Screen

    public String spaceNombreLeft(){
        String s = "";
        for(int i = 15;i>this.getNombre().length();i-=2){
            s = s +" ";
        }
        return s;
    }

//funcion grafica utilisada en la clase Screen
    public String spaceNombreRight(){
        String s = "";
        if(this.getNombre().length()%2 == 0){
            for(int i = 14;i>this.getNombre().length();i-=2){
                s = s +" ";
            }
        }else
            for(int i = 15;i>this.getNombre().length();i-=2){
                s = s +" ";
            }
        return s;
    }

    //Mas metodos...
    public Medico buscarMedico (Categoria categoria, Especialidad especialidad, Tipo tipoServicio){
		return null;
    }
    
    public Cita agendarCita (Medico medico, String fecha) {
    	return null;
    }
    
    public void actualizarHistorialEnfermedades(Enfermedad nuevaEnfermedad) {
    	historiaClinica.getHistorialEnfermedades().add(nuevaEnfermedad);
    }
    
    public void actualizarHistorialOrdenes(OrdenMedica nuevaOrden) {
    	historiaClinica.getHistorialOrdenes().add(nuevaOrden);
    }

    public void actualizarHistorialTerapias(Terapia nuevaTerapia) {
    	historiaClinica.getHistorialTerapias().add(nuevaTerapia);
    }

    public void actualizarHistorialCirugias(Cirugia nuevaCirugia) {
    	historiaClinica.getHistorialCirugias().add(nuevaCirugia);
    }

    public void actualizarHistorialConsultas(Consulta nuevaConsulta) {
    	historiaClinica.getHistorialConsultas().add(nuevaConsulta);
    }
    
    
    
    
    
    // Getters y setters

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public Habitacion getHabitacionAsignada() {
        return habitacionAsignada;
    }

    public void setHabitacionAsignada(Habitacion habitacionAsignada) {
        this.habitacionAsignada = habitacionAsignada;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public ArrayList<Tratamiento> getServiciosSinPagar() {
        return serviciosSinPagar;
    }

    public void setServiciosSinPagar(ArrayList<Tratamiento> serviciosSinPagar) {
        this.serviciosSinPagar = serviciosSinPagar;
    }
    
    public ArrayList<Tratamiento> getServiciosSeleccionados() {
        return serviciosSeleccionados;
    }

    public void setServiciosSeleccionados(ArrayList<Tratamiento> serviciosSeleccionados) {
        this.serviciosSeleccionados = serviciosSeleccionados;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }
}
