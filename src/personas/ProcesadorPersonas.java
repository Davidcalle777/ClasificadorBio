package com.proyecto.clasificadorbio.personas;

import com.proyecto.clasificadorbio.personas.Persona;

import java.util.*;
import java.util.stream.*;

public class ProcesadorPersonas {
    private List<Persona> personas;
    private Scanner scanner;

    public ProcesadorPersonas(Scanner scanner) {
        this.scanner = scanner;
        personas = new ArrayList<>();
    }

    public void ingresarPersonas() {
        System.out.println("Ingrese cantidad de personas:");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Apellido:");
            String apellido = scanner.nextLine();

            System.out.println("Edad:");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.println("Género (masculino, femenino):");
            String genero = scanner.nextLine().toLowerCase();

            System.out.println("Sueldo por hora:");
            double sueldoHora = Double.parseDouble(scanner.nextLine());

            System.out.println("Cargo:");
            String cargo = scanner.nextLine();



            personas.add(new Persona(nombre, apellido, edad, genero, sueldoHora, cargo));
        }
    }

    public void procesarYMostrarDatos() {
        System.out.println("\nTotal de personas: " + personas.size());

        double promedioEdad = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0);
        System.out.println("Promedio de edad: " + promedioEdad);

        long mayoresEdad = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .count();
        System.out.println("Mayores de edad: " + mayoresEdad);

        System.out.println("\nPersonas cuyo nombre empieza con 'A':");
        personas.stream()
                .filter(p -> p.getNombre().startsWith("A"))
                .forEach(System.out::println);

        System.out.println("\nPersonas cuyo apellido contiene 'M':");
        personas.stream()
                .filter(p -> p.getApellido().toLowerCase().contains("m"))
                .forEach(System.out::println);

        System.out.println("\nDirectores masculinos y su sueldo por 8h:");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("director"))
                .filter(p -> p.getGenero().equalsIgnoreCase("masculino"))
                .peek(p -> System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido() +
                        " | Sueldo por 8 horas: $" + (p.getSueldoHora() * 8)))
                .collect(Collectors.toList());

        System.out.println("\nPrimera desarrolladora:");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .filter(p -> p.getGenero().equalsIgnoreCase("femenino"))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\nDesarrollador que más gana por hora:");
        personas.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desarrollador"))
                .max(Comparator.comparingDouble(Persona::getSueldoHora))
                .ifPresent(p -> System.out.println("Nombre: " + p.getNombre() + " " + p.getApellido() +
                        " | Sueldo por hora: $" + p.getSueldoHora()));

        System.out.println("\nMujeres ordenadas por nombre:");
        personas.stream()
                .filter(p -> p.getGenero().equalsIgnoreCase("femenino"))
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(System.out::println);
    }
}
