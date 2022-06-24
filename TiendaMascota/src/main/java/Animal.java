import java.util.ArrayList;

abstract class Animal implements Vendible{
    private String nombre;
    private String raza;
    private String especie;
    private int stock;
    private double masa;
    private int edad;
    private int valor;
    private boolean sexo;
    private String paisOrigen;
    private String tipoAlimentacion;

    public abstract void crearJSON();
}
