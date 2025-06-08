
package com.proyecto.clasificadorbio.personas;


public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private double sueldoHora;
    private String cargo;

    public Persona(String nombre, String apellido, int edad, String genero, double sueldoHora, String cargo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.sueldoHora = sueldoHora;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public String getCargo() {
        return cargo;
    }
}
