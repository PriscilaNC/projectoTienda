package Personas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Persona {
    private String rut;
    private String nombre;
    private int edad;

    public Persona(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void crearJSON();

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n"+
                "Rut: " + rut + "\n"+
                "Edad: " + edad + " años\n";
    }
}
