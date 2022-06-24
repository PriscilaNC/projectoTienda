import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Acuatico extends Animal{
    private boolean isDulce;
    private int temperaturaIdeal;


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

    //todo crear
    @Override
    public boolean isDisponible() {
        return false;
    }

    //todo crear
    @Override
    public void quitarDeStock() {
    }

    @Override
    public void vender() {
        isDisponible();
        quitarDeStock();
    }
}
