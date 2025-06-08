package principal;

import clasificadorbio.animales.ClasificadorAnimales;
import clasificadorbio.personas.ProcesadorPersonas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Clasificación de animales
        ClasificadorAnimales clasificadorAnimales = new ClasificadorAnimales(scanner);
        clasificadorAnimales.ingresarAnimales();
        clasificadorAnimales.mostrarClasificacion();

        // Procesamiento de personas
        ProcesadorPersonas procesadorPersonas = new ProcesadorPersonas(scanner);
        procesadorPersonas.ingresarPersonas();
        procesadorPersonas.procesarYMostrarDatos();

        scanner.close();
    }
}
