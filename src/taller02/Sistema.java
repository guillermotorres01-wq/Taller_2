package taller02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Sistema {

    private Participante[] participantes = new Participante[200];
    private int cantParticipantes = 0;

    private Consumo[] consumos = new Consumo[200];
    private int cantConsumos = 0;

    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        cargarParticipantes();
        cargarConsumidos();
        menuPrincipal();
    }

    private void cargarParticipantes() {
        try {
            File archivo = new File("Participantes.txt");
            if (!archivo.exists()) {
                System.out.println("No se encontro Participantes.txt");
                return;
            }

            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (!linea.isEmpty()) {
                    participantes[cantParticipantes] = new Participante(linea);
                    cantParticipantes++;
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer Participantes.txt");
        }
    }

    private void cargarConsumidos() {
        try {
            File archivo = new File("Consumido.txt");
            if (!archivo.exists()) {
                System.out.println("No se encontro Consumido.txt");
                return;
            }

            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(";");
                String tipo = partes[0];

                if (tipo.equalsIgnoreCase("Choripan")) {
                    String consumidor = partes[1];
                    double largo = Double.parseDouble(partes[2]);
                    double ancho = Double.parseDouble(partes[3]);
                    String fecha = partes[4];

                    consumos[cantConsumos] = new Choripan(consumidor, largo, ancho, fecha);
                    cantConsumos++;
                } else if (tipo.equalsIgnoreCase("Terremoto")) {
                    String consumidor = partes[1];
                    double litros = Double.parseDouble(partes[2]);
                    String fecha = partes[3];

                    consumos[cantConsumos] = new Terremoto(consumidor, litros, fecha);
                    cantConsumos++;
                }
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer Consumido.txt");
        }
    }

    private void menuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("============================================");
            System.out.println("           LA FONDA DEL PAPU");
            System.out.println("============================================");
            System.out.println("  Registros cargados: " + cantConsumos);
            System.out.println("--------------------------------------------");
            System.out.println("  [1] Ver registros");
            System.out.println("  [2] Actualizar registros");
            System.out.println("  [3] Calcular metricas");
            System.out.println("  [4] Salir");
            System.out.println("============================================");
            System.out.print("Seleccione una opcion: ");

            try {
                String entrada = scanner.nextLine();
                opcion = Integer.parseInt(entrada);
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    menuVerRegistros();
                    break;
                case 2:
                    System.out.println("Opcion en construccion...");
                    break;
                case 3:
                    System.out.println("Opcion en construccion...");
                    break;
                case 4:
                    System.out.println(">> Hasta luego...");
                    break;
                default:
                    System.out.println(">> Error: opcion fuera de rango. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 4);
    }

    private void menuVerRegistros() {
        int opcion = 0;
        do {
            System.out.println("============ VER REGISTROS =================");
            System.out.println("  [1] Choripanes");
            System.out.println("  [2] Terremotos");
            System.out.println("  [3] Volver al menu principal");
            System.out.println("============================================");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            if (opcion == 1) {
                verChoripanes();
            } else if (opcion == 2) {
                verTerremotos();
            } else if (opcion != 3) {
                System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 3);
    }

    private void verChoripanes() {
        System.out.println("=============== CHORIPANES =================");
        System.out.println("  #\tConsumidor\tLargo\tAncho\tFecha\t\tKCal");

        int count = 0;
        for (int i = 0; i < cantConsumos; i++) {
            if (consumos[i] instanceof Choripan) {
                count++;
                Choripan ch = (Choripan) consumos[i];
                double kcal = ch.calcularKcal();
                System.out.println("  " + count + "\t" + ch.getConsumidor() + "\t\t" + (int) ch.getLargo() + " cm\t" + (int) ch.getAncho() + " cm\t" + ch.getFecha() + "\t" + kcal);
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("  Total: " + count + " choripanes registrados");
        System.out.println("==================================================");
        System.out.print("Presione ENTER para continuar...");
        scanner.nextLine();
    }

    private void verTerremotos() {
        System.out.println("=============== TERREMOTOS =================");
        System.out.println("  #\tConsumidor\tLitros\tFecha\t\tKCal");

        int count = 0;
        double litrosTotales = 0;
        for (int i = 0; i < cantConsumos; i++) {
            if (consumos[i] instanceof Terremoto) {
                count++;
                Terremoto t = (Terremoto) consumos[i];
                litrosTotales = litrosTotales + t.getLitros();
                double kcal = t.calcularKcal();
                System.out.println("  " + count + "\t" + t.getConsumidor() + "\t\t" + t.getLitros() + " L\t" + t.getFecha() + "\t" + kcal);
            }
        }
        litrosTotales = Math.round(litrosTotales * 100.0) / 100.0;
        System.out.println("--------------------------------------------------");
        System.out.println("  Total: " + count + " terremotos registrados (" + litrosTotales + " L)");
        System.out.println("==================================================");
        System.out.print("Presione ENTER para continuar...");
        scanner.nextLine();
    }
}