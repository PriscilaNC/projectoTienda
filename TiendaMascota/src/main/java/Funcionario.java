import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Funcionario extends Persona{
    private String cargo;
    private String fono;
    private String correo;
    private String direccion;
    private int sueldo;
    private boolean tipoContrato;

    public Funcionario(String rut, String nombre, int edad) {
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
        Funcionario funcionario = pGson.fromJson(stringJson, Funcionario.class);
        System.out.println("funcionario = " + funcionario);
        FileWriter writer;
        try{
            writer = new FileWriter("funcionario.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cargo='" + cargo + '\'' +
                ", fono='" + fono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", sueldo=" + sueldo +
                ", tipoContrato=" + tipoContrato +
                "} " + super.toString();
    }
}
