import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Aereo extends Animal{
    private String colorPlumaje;
    private String tipopata;

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
