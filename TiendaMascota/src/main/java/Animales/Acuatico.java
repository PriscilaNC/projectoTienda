package Animales;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Acuatico extends Animal {
    private boolean isDulce;
    private int temperaturaIdeal;

    public Acuatico(int codido, String nombre, String raza, String especie, String color, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion, boolean isDulce, int temperaturaIdeal) {
        super(codido, nombre, raza, especie, color, masa, edad, valor, sexo, paisOrigen, tipoAlimentacion);
        this.isDulce = isDulce;
        this.temperaturaIdeal = temperaturaIdeal;
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
        Acuatico acuatico = pGson.fromJson(stringJson, Acuatico.class);
        System.out.println("acuatico = " + acuatico);
        FileWriter writer;
        try{
            writer = new FileWriter("acuatico.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    @Override
    public boolean isDisponible() {
        //Metodo ternario
        /*
        boolean i = this.getStock() != 0 ? true : false;
        return i;
         */

        //Metodo if/else
        if (this.getStock() != 0) {
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

    private String isDulce(){
        if (this.isDulce == true){
            return "dulce";
        }else {
            return "salada";
        }
    }

    @Override
    public String toString() {
        return super.toString()+
                "Tipo agua: " + isDulce() + "\n" +
                "Temperatura del agua: " + temperaturaIdeal +"°C";
    }
}
