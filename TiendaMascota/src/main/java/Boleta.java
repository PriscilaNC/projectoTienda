import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Boleta implements Mostrable{
    private int codigo;
    private ArrayList<Pago> boleta;
    private ArrayList<Producto> detalleProducto;
    private ArrayList<Animal> detalleAnimal;
    private int total;

    //Constructor completo
    public Boleta(int codigo, ArrayList<Pago> boleta, ArrayList<Producto> detalleProducto, ArrayList<Animal> detalleAnimal, int total) {
        this.codigo = codigo;
        this.boleta = boleta;
        this.detalleProducto = detalleProducto;
        this.detalleAnimal = detalleAnimal;
        this.total = total;
    }

    //Constructor para detalleProducto
    public Boleta(int codigo, ArrayList<Pago> boleta, ArrayList<Producto> detalleProducto, int total) {
        this.codigo = codigo;
        this.boleta = boleta;
        this.detalleProducto = detalleProducto;
        this.total = total;
    }

    //Constructor para detalleAnimal
    public Boleta(int codigo, ArrayList<Pago> boleta, int total, ArrayList<Animal> detalleAnimal) {
        this.codigo = codigo;
        this.boleta = boleta;
        this.total = total;
        this.detalleAnimal = detalleAnimal;
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

    //todo
    public void agregarAnimal(Animal animal){
        detalleAnimal.add(animal);
    }
    
    //todo
    public void agregarProducto(Producto producto){
        detalleProducto.add(producto);
    }

    

    @Override
    public String toString() {
        return "Boleta{" +
                "codigo=" + codigo +
                ", boleta=" + boleta +
                ", detalleProducto=" + detalleProducto +
                ", detalleAnimal=" + detalleAnimal +
                ", total=" + total +
                '}';
    }
}
