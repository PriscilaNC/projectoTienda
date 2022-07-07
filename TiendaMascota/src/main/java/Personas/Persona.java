package Personas;

import Productos.Producto;

import java.util.List;

public abstract class Persona {
    protected String rut;
    protected String nombre;
    protected int edad;
    static final String DB_URL = "jdbc:mysql://localhost/tienda_mascota";
    static final String USER = "uwu";
    static final String PASS = "12345678qwerty";

    public Persona(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void agregarStatico();

    public Persona estaPersona(){
        return this;
    }

    public abstract void actualizarDB();


    @Override
    public String toString() {
        return rut + nombre + edad;
    }
}
