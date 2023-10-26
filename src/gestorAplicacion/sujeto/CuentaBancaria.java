package gestorAplicacion.sujeto;

import java.util.HashMap;
import java.util.Random;
import gestorAplicacion.instalaciones.Organos;

public class CuentaBancaria {
	private double saldo;
	private double deuda = 0.0;
	private boolean estadoDeReporte;
	private HashMap <Organos , Integer> organosDonar; 

	public CuentaBancaria() {
		this.saldo = generadorSaldoAleatorio();
		this.organosDonar = new HashMap<>();
		this.estadoDeReporte = generarEstadoDeReporteAleatorio();
		}

	    public void debitar(double monto) {
	        if (monto <= saldo) {
	            saldo -= monto;
	        } 
	    }

		public void depositar(double monto) {
			if (monto > 0) {
				saldo += monto;
			}
		}

		public void agregarDeuda(double cantidad) {
			deuda += cantidad;
		}

		public void agregarOrganoDonar(Organos organo, int cantidad) {
			// Verificar si el órgano ya existe en el diccionario
			if (organosDonar.containsKey(organo)) {
				// Si existe, actualizar la cantidad
				int cantidadExistente = organosDonar.get(organo);
				cantidadExistente += cantidad;
				organosDonar.put(organo, cantidadExistente);
			} else {
				// Si no existe, agregarlo al diccionario
				organosDonar.put(organo, cantidad);
			}
		}

		private boolean generarEstadoDeReporteAleatorio() {
			// Crea una instancia de Random
			Random random = new Random();
			// Genera un valor aleatorio
			return random.nextBoolean();
		}

		public double generadorSaldoAleatorio() {
			// Crea una instancia de Random
			Random random = new Random();
			// Define los límites del rango
			double saldoMinimo = 500000.0;
			double saldoMaximo = 6000000.0;
			// Genera un valor aleatorio dentro del rango
			double saldoAleatorio = saldoMinimo + (saldoMaximo - saldoMinimo) * random.nextDouble();
			return saldoAleatorio;
		}
		
		

	// Getters y setters

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public HashMap<Organos, Integer> getOrganosDonar() {
        return organosDonar;
    }

    public void setOrganosDonar(HashMap<Organos, Integer> organosDonar) {
        this.organosDonar = organosDonar;
    }

	public boolean isEstadoDeReporte() {
        return estadoDeReporte;
    }

    public void setEstadoDeReporte(boolean estadoDeReporte) {
        this.estadoDeReporte = estadoDeReporte;
    }

	public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

}


