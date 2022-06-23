import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Pago {
    private int codigo;
    private String tipo;
    private int monto;
    private Date fecha;
    private Persona emisor;
    private Persona receptor;
    private String direccion;

    public Pago(int codigo, String tipo, int monto, Date fecha, Persona emisor, Persona receptor, String direccion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.emisor = emisor;
        this.receptor = receptor;
        this.direccion = direccion;
    }

    public void crearJSON() {
        //Serialization
        //Crea el archivo
        Gson pGson = new Gson();
        String stringJson = pGson.toJson(this);
        System.out.println("stringJson = " + stringJson);

        //Deserialization
        //Obtiene datos desde el archivo
        Pago pago = pGson.fromJson(stringJson, Pago.class);
        System.out.println("pago = " + pago);
        FileWriter writer;
        try{
            writer = new FileWriter("pago.json");
            Gson gson = new GsonBuilder().create();
            gson.toJson(this,writer);
            writer.close();
        }catch (IOException e){
            System.out.println("No se pudo guardar el archivo");
        }
    }
}
