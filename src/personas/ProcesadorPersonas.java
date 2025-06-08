package clasificadorbio.personas;

import com.proyecto.clasificadorbio.personas.Persona;


import java.util.*;

public class ProcesadorPersonas {
    private final List<Persona> personas = new ArrayList<>();
    private final Scanner scanner;

    public ProcesadorPersonas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void ingresarPersonas() {
        System.out.println("\nIngrese datos de personas (nombre, apellido, edad, genero, sueldo/hora, cargo)");
        System.out.println("Escriba 'salir' como nombre para terminar.");

        while (true) {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("salir")) break;

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();
            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Género (masculino/femenino): ");
            String genero = scanner.nextLine();
            System.out.print("Sueldo por hora: ");
            double sueldoHora = Double.parseDouble(scanner.nextLine());
            System.out.print("Cargo: ");
            String cargo = scanner.nextLine();

            personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
        }
    }

    public void procesarYMostrarDatos() {
        System.out.println("\n--- Estadísticas de Personas ---");
        System.out.println("Cantidad total: " + personas.size());

        double promedioEdad = personas.stream().mapToInt(Persona::getEdad).average().orElse(0);
        System.out.println("Promedio de edad: " + promedioEdad);

        long mayoresEdad = personas.stream().filter(p -> p.getEdad() >= 18).count();
        System.out.println("Mayores de edad: " + mayoresEdad);

        System.out.println("Nombres que empiezan con A:");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));

        System.out.println("Apellidos que contienen 'M':");
        personas.stream()
                .filter(p -> p.getApellido().toLowerCase().contains("m"))
                .forEach(p -> System.out.println(p.getNombre() + " " + p.getApellido()));

        System.out.println("\nSueldo por 8 horas (Directores Masculinos):");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("masculino"))
                .filter(p -> p.getCargo().equalsIgnoreCase("director"))
                .peek(p -> System.out.print("Nombre: " + p.getNombre() + " " + p.getApellido() + " "))
                .forEach(p -> System.out.println("Sueldo por 8 horas: $" + (p.getSueldoHora() * 8)));

        System.out.println("\nPrimera mujer desarrolladora:");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("femenino"))
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .findFirst()
                .ifPresent(p -> System.out.println(p.getNombre() + " " + p.getApellido()));

        System.out.println("\nDesarrollador que más gana por hora:");
        Optional<Persona> masGana = personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .max(Comparator.comparing(Persona::getSueldoHora));

        if (masGana.isPresent()) {
            Persona p = masGana.get();
            System.out.println(p.getNombre() + " " + p.getApellido() + " - $" + p.getSueldoHora() + "/hora");
        } else {
            System.out.println("No hay desarrolladores registrados.");
        }
    }
}
