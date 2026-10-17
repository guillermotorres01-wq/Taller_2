package taller02;

public class Terremoto extends Consumo {
	
	private double litros;
	
	public Terremoto(String consumidor, double litros, String fecha) {
		super(consumidor, fecha);
		this.litros = litros;
	}
	
	public double calcularKcal() {
		return(this.litros * 10.0) / 3.0;
	}
	
	public String FormatoArchivo() {
		return "Terremoto;" + getConsumidor() + ";" + this.litros + ";" + getFecha();
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}	
}

