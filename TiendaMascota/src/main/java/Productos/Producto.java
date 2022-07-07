package Productos;

import Interface.Comprable;

import java.util.List;

public abstract class Producto implements Comprable {
    protected int codigo;
    protected int precio;
    protected String nombre;
    protected String descripcion;
    protected int stock;
    static final String DB_URL = "jdbc:mysql://localhost/tienda_mascota";
    static final String USER = "uwu";
    static final String PASS = "12345678qwerty";

    public Producto(int codigo, int precio, String nombre, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        agregarStock();
    }

    public abstract void agregarStatico();

    public int getCodigo() {
        return codigo;
    }

    public int getStock() {return stock;}

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract void actualizarDB();

    public Producto esteProducto(){
        return this;
    }

    @Override
    public String toString() {
        return  codigo + precio + nombre + descripcion;
    }
}
