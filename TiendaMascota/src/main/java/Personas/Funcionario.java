package Personas;

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
    private boolean tipoJornada;

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

    private String tipoContrato(){
        if (this.tipoJornada == true){
            return "completa";
        }else {
            return "parcial";
        }
    }

    @Override
    public String toString() {
        return super.toString()+
                "Cargo: " + cargo + '\n' +
                "Fono: " + fono + '\n' +
                "Correo: " + correo + '\n' +
                "Direccion: " + direccion + '\n' +
                "Sueldo: $" + sueldo + '\n' +
                "Jornada: " + tipoJornada ;
    }
}