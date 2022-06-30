import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Cliente extends Persona{
    private Boleta boleta;

    public Cliente(String rut, String nombre, int edad) {
        super(rut, nombre, edad);
    }

    @Override
    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Cliente cliente = pGson.fromJson(stringJson, Cliente.class);
        System.out.println("cliente = " + cliente);
        FileWriter writer;
        try{
            writer = new FileWriter("cliente.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    //todo
    public void comprarAnimal(Animal animal){
        this.boleta.agregarAnimal(animal);
    }

    //todo
    public void comprarProducto(Producto producto){
        this.boleta.agregarProducto(producto);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "boleta=" + boleta +
                "} " + super.toString();
    }
}
