package taller02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import sun.nio.cs.ext.MSISO2022JP;

public class Sistema {

	private Participante[] participantes;
	private int cantParticipantes;
	
	private Consumo[] consumos;
	private int cantConsumos;
	
	public Sistema() {
		this.participantes = new Participante[200];
		this.cantParticipantes = 0;
		
		this.consumos = new Consumo[200];
		this.cantConsumos = 0;
	}
	
	public void iniciar() {
		cargarParticipantes();
		cargarConsumidos();
		
		System.out.println("============================================");
        System.out.println("           LA FONDA DEL PAPU                ");
        System.out.println("============================================");
        System.out.println("  Participantes cargados: " + this.cantParticipantes);
        System.out.println("  Registros cargados: " + this.cantConsumos);
        System.out.println("============================================");
	
	}
	
}
