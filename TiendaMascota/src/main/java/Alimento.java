import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Alimento extends Producto{
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private String tipoAnimal;
    private double cantidadEnKg;

    public Alimento(int codigo, int precio, String nombre, String descripcion, Date fechaElaboracion, Date fechaVencimiento, String tipoAnimal, double cantidadEnKg) {
        super(codigo, precio, nombre, descripcion);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoAnimal = tipoAnimal;
        this.cantidadEnKg = cantidadEnKg;
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
        Alimento alimento = pGson.fromJson(stringJson, Alimento.class);
        System.out.println("alimento = " + alimento);
        FileWriter writer;
        try{
            writer = new FileWriter("alimento.json");
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
        return "Alimento{" +
                "fechaElaboracion=" + fechaElaboracion +
                ", fechaVencimiento=" + fechaVencimiento +
                ", tipoAnimal='" + tipoAnimal + '\'' +
                ", cantidadEnKg=" + cantidadEnKg +
                "} " + super.toString();
    }
}
