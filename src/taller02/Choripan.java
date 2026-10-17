package taller02;

public class Choripan extends Consumo{

	private double largo;
	private double ancho;
	
	public Choripan(String consumidor, double largo, double ancho, String fecha) {
		super(consumidor, fecha);
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public double calcularKcal() {
		return (this.largo * this.ancho) / 3.0;
	}
	
	public String FormatoArchivo() {
		return "Choripan;" + getConsumidor() + ";" + (int) this.largo + ";" + (int) this.ancho + ";" + getFecha();
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}	
}


