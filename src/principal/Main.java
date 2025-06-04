package principal;

import com.proyecto.clasificadorbio.animales.ClasificadorAnimales;
import com.proyecto.clasificadorbio.personas.ProcesadorPersonas;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClasificadorAnimales clasificadorAnimales = new ClasificadorAnimales(scanner);
        clasificadorAnimales.ingresarAnimales();
        clasificadorAnimales.mostrarClasificacion();

        ProcesadorPersonas procesadorPersonas = new ProcesadorPersonas(scanner);
        procesadorPersonas.ingresarPersonas();
        procesadorPersonas.procesarYMostrarDatos();
    }
}
