import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Terrestre extends Animal{
    private int nPatas;
    private int temperaturaIdeal;
    private boolean hasPelaje;

    @Override
    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Terrestre terrestre = pGson.fromJson(stringJson, Terrestre.class);
        System.out.println("terrestre = " + terrestre);
        FileWriter writer;
        try{
            writer = new FileWriter("terrestre.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }
}
