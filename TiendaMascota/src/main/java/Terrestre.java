import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Terrestre extends Animal{
    private int nPatas;
    private int temperaturaIdeal;
    private boolean hasPelaje;

    public Terrestre(String nombre, String raza, String especie, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion, int nPatas, int temperaturaIdeal, boolean hasPelaje) {
        super(nombre, raza, especie, masa, edad, valor, sexo, paisOrigen, tipoAlimentacion);
        this.nPatas = nPatas;
        this.temperaturaIdeal = temperaturaIdeal;
        this.hasPelaje = hasPelaje;
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
        Terrestre terrestre = pGson.fromJson(stringJson, Terrestre.class);
        System.out.println("terrestre = " + terrestre);
        FileWriter writer;
        try{
            writer = new FileWriter("terrestre.json");
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
        return "Terrestre{" +
                "nPatas=" + nPatas +
                ", temperaturaIdeal=" + temperaturaIdeal +
                ", hasPelaje=" + hasPelaje +
                "} " + super.toString();
    }
}
