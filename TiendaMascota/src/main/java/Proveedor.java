import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Proveedor extends Persona{
    private String organizacion;
    private String tipoProveedor;

    public Proveedor(String rut, String nombre, int edad) {
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
        Proveedor proveedor = pGson.fromJson(stringJson, Proveedor.class);
        System.out.println("proveedor = " + proveedor);
        FileWriter writer;
        try{
            writer = new FileWriter("proveedor.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "organizacion='" + organizacion + '\'' +
                ", tipoProveedor='" + tipoProveedor + '\'' +
                "} " + super.toString();
    }
}
