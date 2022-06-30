package Transaccion;

import Animales.Animal;
import Interface.Mostrable;
import Personas.Cliente;
import Productos.Producto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
        this.detalleAnimal.add(animal);
    }

    public void agregarProducto(Producto producto){
        this.detalleProducto.add(producto);
    }

    @Override
    public String toString() {
        return "Boleta numero: "+ codigo +"\n"+
                "Cliente: " + cliente +"\n"+
                "Pagos: " + pagos +"\n"+
                "Detalle: " + detalleProducto + detalleAnimal +"\n"+
                "Total $" + total;
    }
}
