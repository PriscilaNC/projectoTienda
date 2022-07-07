package Productos;

import Animales.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Medicamento extends Producto{
    protected String fechaElaboracion;
    protected String fechaVencimiento;
    protected String tipoUso;
    protected static List<Producto> staticProducto = new ArrayList<>();
    static String QUERY = "SELECT * FROM medicamento";

    public Medicamento(int codigo, int precio, String nombre, String descripcion, String fechaElaboracion, String fechaVencimiento, String tipoUso) {
        super(codigo, precio, nombre, descripcion);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoUso = tipoUso;
        agregarStock();
    }

    @Override
    public void agregarStatico() {
        staticProducto.add(this);
    }

    public static List<Producto> getStaticMedicamento() {
        return staticProducto;
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
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("Insertando datos en la tabla...");


            String sql = "INSERT INTO medicamento (precio, nombre, descripcion, fecha_elab, fecha_caduc, tipo_uso) values "
                    + "(" + super.precio + "," + super.nombre
                    + "," + super.descripcion + "," + fechaElaboracion
                    + "," + fechaVencimiento + "," + tipoUso + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarMedicamento(){
        try {
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()){
                System.out.println("Codigo: " + rs.getInt("codigo"));
                System.out.println("Precio: " + rs.getInt("precio"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("FechaElaboracion: " + rs.getString("fecha_elab"));
                System.out.println("FechaCaduc: " + rs.getString("fecha_caduc"));
                System.out.println("TipoUso: " + rs.getString("tipo_uso"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return  super.toString() + fechaElaboracion + fechaVencimiento + tipoUso;
    }
}
