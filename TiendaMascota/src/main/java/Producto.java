import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

abstract class Producto implements Vendible{
    private int codigo;
    private int precio;
    private String nombre;
    private int stock;
    private String descripcion;

    public abstract void crearJSON();
}
