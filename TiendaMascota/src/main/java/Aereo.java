import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Aereo extends Animal{
    private String colorPlumaje;
    private String tipopata;

    public Aereo(String nombre, String raza, String especie, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion, String colorPlumaje, String tipopata) {
        super(nombre, raza, especie, masa, edad, valor, sexo, paisOrigen, tipoAlimentacion);
        this.colorPlumaje = colorPlumaje;
        this.tipopata = tipopata;
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
        Aereo aereo = pGson.fromJson(stringJson, Aereo.class);
        System.out.println("accesorio = " + aereo);
        FileWriter writer;
        try{
            writer = new FileWriter("aereo.json");
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
        return "Aereo{" +
                "colorPlumaje='" + colorPlumaje + '\'' +
                ", tipopata='" + tipopata + '\'' +
                "} " + super.toString();
    }
}
