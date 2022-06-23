import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Medicamento extends Producto{
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private String tipoUso;

    @Override
    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Medicamento medicamento = pGson.fromJson(stringJson, Medicamento.class);
        System.out.println("medicamento = " + medicamento);
        FileWriter writer;
        try{
            writer = new FileWriter("medicamento.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }
}
