package Animales;

import Interface.Comprable;

public abstract class Animal implements Comprable {
    private int codigo;
    private String nombre;
    private String raza;
    private String especie;
    private String color;
    private int stock;
    private double masa;
    private int edad;
    private int valor;
    private boolean sexo;
    private String paisOrigen;
    private String tipoAlimentacion;

    public Animal(int codido, String nombre, String raza, String especie,String color, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion) {
        this.codigo = codido;
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

    public abstract void crearJSON();

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private String sexo(){
        if (this.sexo == true){
            return "hembra";
        }else {
            return "macho";
        }
    }

    @Override
    public String toString() {
        return codigo+" "+ nombre + "," + raza + "," + especie + '\n' +
                "Color: "+color+"\n"+
                "Peso: " + masa +"kg.\n" +
                "Edad: " + edad +"años\n" +
                "Valor $" + valor + "\n" +
                "Sexo: " + sexo() + "\n" +
                "Origen: " + paisOrigen + "\n" +
                "Alimentacion: " + tipoAlimentacion + "\n";
    }
}
