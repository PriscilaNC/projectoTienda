abstract class Producto implements Comprable {
    private int codigo;
    private int precio;
    private String nombre;
    private int stock =1;
    private String descripcion;

    public Producto(int codigo, int precio, String nombre, String descripcion) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract void crearJSON();

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", precio=" + precio +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
