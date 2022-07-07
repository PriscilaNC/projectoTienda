package Transaccion;


import Animales.Animal;
import Exceptions.ObjectNonOfClassExeption;
import Interface.Mostrable;
import Personas.Cliente;
import Productos.Producto;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

//todo hacer que total se consiga a travez de metodos
public class Boleta implements Mostrable {
    private int codigo;
    private Cliente cliente;
    private ArrayList<Pago> pagos;
    private ArrayList<Producto> detalleProducto = new ArrayList<>();
    private ArrayList<Animal> detalleAnimal = new ArrayList<>();
    private int total;

    //Constructor para detalleProducto
    public Boleta(int codigo, Cliente cliente, ArrayList<Pago> pagos, int total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.pagos = pagos;
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
            System.err.println(e.mensajeError());
        }
    }

    public void agregarProducto(Producto producto){
        try {
            this.detalleProducto.add(producto);
            if (producto.getClass() != Producto.class){
                throw new ObjectNonOfClassExeption();
            }
        }catch (ObjectNonOfClassExeption e){
            System.err.println(e.mensajeError());
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
