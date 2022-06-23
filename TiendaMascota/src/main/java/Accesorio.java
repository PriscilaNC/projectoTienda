import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Accesorio extends Producto{
    private String material;
    private String tipo;


    @Override
    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Accesorio accesorio = pGson.fromJson(stringJson, Accesorio.class);
        System.out.println("accesorio = " + accesorio);
        FileWriter writer;
        try{
            writer = new FileWriter("accesorio.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }
}
