package Productos;

import Interface.Comprable;

public abstract class Producto implements Comprable {
    private int codigo;
    private int precio;
    private String nombre;
    private int stock;
    private String descripcion;

    public Producto(int codigo, int precio, String nombre, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        agregarStock();
    }

    public abstract void crearJSON();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto esteProducto(){
        return this;
    }

    @Override
    public String toString() {
        return  "Codigo: " + codigo +
                "" + nombre + '\n' +
                "$ " + precio +"\n"+
                "Stock: " + stock +
                "Descripcion: " + descripcion+"\n";
    }
}
