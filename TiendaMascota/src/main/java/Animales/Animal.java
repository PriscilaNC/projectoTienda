package Animales;

import Interface.Comprable;

import java.util.List;

public abstract class Animal implements Comprable {
    protected int codigo;
    protected String nombre;
    protected String raza;
    protected String especie;
    protected String color;
    protected int stock;
    protected double masa;
    protected int edad;
    protected int valor;
    protected boolean sexo;
    protected String paisOrigen;
    protected String tipoAlimentacion;
    static final String DB_URL = "jdbc:mysql://localhost/tienda_mascota";
    static final String USER = "uwu";
    static final String PASS = "12345678qwerty";

    public Animal(int codigo, String nombre, String raza, String especie,String color, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.raza = raza;
        this.especie = especie;
        this.color = color;
        this.masa = masa;
        this.edad = edad;
        this.valor = valor;
        this.sexo = sexo;
        this.paisOrigen = paisOrigen;
        this.tipoAlimentacion = tipoAlimentacion;
        agregarStock();
    }

    public abstract void agregarStatico();

    public int getCodigo() {
        return codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Animal esteAnimal(){
        return this;
    }

    public String sexo(){
        if (this.sexo == true){
            return "hembra";
        }else {
            return "macho";
        }
    }

    public abstract void actualizarDB();

    @Override
    public String toString() {
        return codigo + nombre + raza + especie +color + masa + edad + valor + sexo() + paisOrigen + tipoAlimentacion ;
    }
}
