package clasificadorbio.animales;

import java.util.*;

public class ClasificadorAnimales {
    private final List<Animal> animales = new ArrayList<>();
    private final Map<String, List<Animal>> clasificacion = new TreeMap<>();
    private final Scanner scanner;

    public ClasificadorAnimales(Scanner scanner) {
        this.scanner = scanner;
    }

    public void ingresarAnimales() {
        System.out.println("Ingrese animales (nombre, tipo [terrestre, aéreo, acuático], genero [masculino, femenino])");
        System.out.println("Escriba 'salir' para terminar.");

        while (true) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) break;

            System.out.print("Tipo (terrestre/aéreo/acuático): ");
            String tipo = scanner.nextLine().toLowerCase();

            System.out.print("Género (masculino/femenino): ");
            String genero = scanner.nextLine().toLowerCase();

            Animal animal = new Animal(nombre, tipo, genero);
            animales.add(animal);
            clasificacion.computeIfAbsent(tipo, k -> new ArrayList<>()).add(animal);
        }
    }

    public void mostrarClasificacion() {
        System.out.println("\nClasificación de Animales:");
        clasificacion.forEach((tipo, lista) -> {
            System.out.println(capitalizar(tipo) + ":");
            lista.forEach(animal -> System.out.println("  - " + animal.getNombre()));
        });
    }

    private String capitalizar(String texto) {
        return texto.substring(0, 1).toUpperCase() + texto.substring(1);
    }
}
