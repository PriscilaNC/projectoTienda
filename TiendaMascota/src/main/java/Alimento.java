import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Alimento extends Producto{
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private String tipoAnimal;
    private double cantidadEnKg;

    @Override
    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Alimento alimento = pGson.fromJson(stringJson, Alimento.class);
        System.out.println("alimento = " + alimento);
        FileWriter writer;
        try{
            writer = new FileWriter("alimento.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    @Override
    public boolean isDisponible() {
        return false;
    }

    @Override
    public void quitarDeStock() {

    }


    @Override
    public void vender() {

    }
}
