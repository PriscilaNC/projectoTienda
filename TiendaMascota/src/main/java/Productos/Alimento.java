package Productos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Alimento extends Producto{
    private String fechaElaboracion;
    private String fechaVencimiento;
    private String tipoAnimal;
    private double cantidadEnKg;

    public Alimento(int codigo, int precio, String nombre, String descripcion, String fechaElaboracion, String fechaVencimiento, String tipoAnimal, double cantidadEnKg) {
        super(codigo, precio, nombre, descripcion);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoAnimal = tipoAnimal;
        this.cantidadEnKg = cantidadEnKg;
        agregarStock();
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
    public void quitarStock() {
        if (isDisponible()) {
            this.setStock(this.getStock() - 1);
        }else{
            System.out.println("No se pudo realizar la venta");
        }
    }

    @Override
    public void agregarStock() {
        this.setStock(this.getStock()+1);
    }

    @Override
    public void agregarNStock(int cantidad){
        this.setStock(this.getStock() + cantidad);
    }

    @Override
    public void actualizarDB() {

    }

    @Override
    public String toString() {
        return super.toString() +
                "Fecha elaboracion: " + fechaElaboracion+"\n"+
                "Fecha caducacion: " + fechaVencimiento +"\n"+
                "Alimento para: " + tipoAnimal + "\n" +
                "Peso neto: " + cantidadEnKg +" kg.";
    }
}
