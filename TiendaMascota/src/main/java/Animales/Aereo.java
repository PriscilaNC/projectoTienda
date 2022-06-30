package Animales;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Aereo extends Animal {

    public Aereo(int codido, String nombre, String raza, String especie, String color, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion) {
        super(codido, nombre, raza, especie, color, masa, edad, valor, sexo, paisOrigen, tipoAlimentacion);
        agregarStock();
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
        Aereo aereo = pGson.fromJson(stringJson, Aereo.class);
        System.out.println("accesorio = " + aereo);
        FileWriter writer;
        try{
            writer = new FileWriter("aereo.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    @Override
    public boolean isDisponible() {if (this.getStock() != 0) {
        return true;
    }else{
        System.out.println("No hay stock");
        return false;
        }
    }

    @Override
    public void quitarStock() {
        if (isDisponible()) {
            this.setStock(this.getStock() - 1);
        }else{
            System.out.println("No se pudo realizar la venta");
        }
    }

    @Override
    public void agregarStock() {
        this.setStock(this.getStock()+1);
    }

    @Override
    public void agregarNStock(int cantidad){
        this.setStock(this.getStock() + cantidad);
    }

    @Override
    public void actualizarDB() {

    }

    @Override
    public String toString() {
        return "Aereo{} " + super.toString();
    }
}
