package Transaccion;


import Animales.Animal;
import Exceptions.MiExepcion;
import Interface.Mostrable;
import Personas.Cliente;
import Productos.Producto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
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

    //todo agregar exepcion personalizada

    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Boleta boleta = pGson.fromJson(stringJson, Boleta.class);
        System.out.println("boleta = " + boleta);
        FileWriter writer;
        try{
            writer = new FileWriter("boleta.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    @Override
    public void imprimirEnPantalla() {
        System.out.println(this);
    }

    //todo agregar un metodo con programacion funcional


    public void agregarAnimal(Animal animal){
        try {
            this.detalleAnimal.add(animal);
            if (animal.getClass() != Animal.class){
                throw new MiExepcion();
            }
        }catch (MiExepcion e){
            e.mensajeError();
        }
    }

    public void agregarProducto(Producto producto){
        try {
            this.detalleProducto.add(producto);
            if (producto.getClass() != Producto.class){
                throw new MiExepcion();
            }
        }catch (MiExepcion e){
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
        return "Boleta numero: "+ codigo +"\n"+
                "Cliente: " + cliente +"\n"+
                "Pagos: " + pagos +"\n"+
                "Detalle: " + detalleProducto + detalleAnimal +"\n"+
                "Total $" + total;
    }
}
