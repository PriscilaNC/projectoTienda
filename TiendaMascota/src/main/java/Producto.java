import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

abstract class Producto {
    private int codigo;
    private int precio;
    private String nombre;
    private int stock;
    private String descripcion;

    public abstract void crearJSON();
}
