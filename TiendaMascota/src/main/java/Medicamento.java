import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Medicamento extends Producto{
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private String tipoUso;

    public Medicamento(int codigo, int precio, String nombre, String descripcion, Date fechaElaboracion, Date fechaVencimiento, String tipoUso) {
        super(codigo, precio, nombre, descripcion);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoUso = tipoUso;
        comprar();
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

    @Override
    public boolean isDisponible() {if (this.getStock() != 0) {
        return true;
    }else{
        System.out.println("No hay stock");
        return false;
        }
    }

    @Override
    public void vender() {
        if (isDisponible()) {
            this.setStock(this.getStock() - 1);
        }else{
            System.out.println("No se pudo realizar la venta");
        }
    }

    @Override
    public void comprar() {
        this.setStock(this.getStock()+1);
    }

    @Override
    public void actualizarDB() {

    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "fechaElaboracion=" + fechaElaboracion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", tipoUso='" + tipoUso + '\'' +
                "} " + super.toString();
    }
}
