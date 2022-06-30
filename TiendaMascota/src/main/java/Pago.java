import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

public class Pago implements Mostrable{
    private int codigo;
    private String tipo;
    private int monto;
    private Date fecha;
    private Persona cobrador;
    private Persona pagador;
    private String direccion;

    public Pago(int codigo, String tipo, int monto, Persona cobrador, Persona pagador, String direccion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.monto = monto;
        this.cobrador = cobrador;
        this.pagador = pagador;
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

    @Override
    public void imprimirEnPantalla() {
        System.out.println(this);
    }

    public void setFecha(String s){
      Date date = Date.from(Instant.parse(s));
      this.fecha = date;
    }

    @Override
    public String toString() {
        return
                "Transaccion numero: " + codigo +
                "Pago con " + tipo + '\'' +
                "$ " + monto +
                "Realizado el " + fecha+ ", en" + direccion+".";

    }
}
