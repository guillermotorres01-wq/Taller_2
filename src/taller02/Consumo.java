package taller02;

public abstract class Consumo {
	
	private String consumidor;
	private String fecha;
	
	public Consumo(String consumidor, String fecha) {
		this.consumidor = consumidor;
		this.fecha = fecha;
	}
	
	public abstract double calcularKcal();
	public abstract String FormatoArchivo();

	public String getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(String consumidor) {
		this.consumidor = consumidor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}	
}
