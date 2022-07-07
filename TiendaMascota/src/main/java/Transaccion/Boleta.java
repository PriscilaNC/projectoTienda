package Transaccion;


import Animales.Animal;
import Exceptions.ObjectNonOfClassExeption;
import Interface.Mostrable;
import Personas.Cliente;
import Productos.Producto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Boleta implements Mostrable {
    private int codigo;
    private Cliente cliente;
    private ArrayList<Pago> pagos;
    private ArrayList<Producto> detalleProducto;
    private ArrayList<Animal> detalleAnimal;
    private int total;
    static final String DB_URL = "jdbc:mysql://localhost/tienda_mascota";
    static final String USER = "uwu";
    static final String PASS = "12345678qwerty";

    //Constructor completo
    public Boleta(int codigo, Cliente cliente, ArrayList<Pago> pagos, ArrayList<Producto> detalleProducto, ArrayList<Animal> detalleAnimal, int total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.pagos = pagos;
        this.detalleProducto = detalleProducto;
        this.detalleAnimal = detalleAnimal;
        this.total = total;
    }

    //Constructor para detalleProducto
    public Boleta(int codigo, Cliente cliente, ArrayList<Pago> pagos, ArrayList<Producto> detalleProducto, int total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.pagos = pagos;
        this.detalleProducto = detalleProducto;
        this.total = total;
    }

    //Constructor para detalleAnimal
    public Boleta(int codigo, ArrayList<Pago> pagos, Cliente cliente, ArrayList<Animal> detalleAnimal, int total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.pagos = pagos;
        this.detalleAnimal = detalleAnimal;
        this.total = total;
    }

    public ArrayList<Producto> getDetalleProducto() {
        return detalleProducto;
    }

    public ArrayList<Animal> getDetalleAnimal() {
        return detalleAnimal;
    }

    @Override
    public void imprimirEnPantalla() {
        System.out.println(this);
    }

    public void agregarAnimal(Animal animal){
        try {
            this.detalleAnimal.add(animal);
            if (animal.getClass() != Animal.class){
                throw new ObjectNonOfClassExeption();
            }
        }catch (ObjectNonOfClassExeption e){
            e.mensajeError();
        }
    }

    public void agregarProducto(Producto producto){
        try {
            this.detalleProducto.add(producto);
            if (producto.getClass() != Producto.class){
                throw new ObjectNonOfClassExeption();
            }
        }catch (ObjectNonOfClassExeption e){
            e.mensajeError();
        }
    }

    //Map de animales
    Map<Integer,Animal> animalMap = this.detalleAnimal.stream()
            .collect(Collectors.toMap(Animal::getCodigo,Animal::esteAnimal));

    //Map de producto
    Map<Integer,Producto> productoMap = this.detalleProducto.stream()
            .collect(Collectors.toMap(Producto::getCodigo,Producto::esteProducto));

    @Override
    public String toString() {
        return "" + codigo + cliente + pagos + detalleProducto + detalleAnimal + total + "";}
}
