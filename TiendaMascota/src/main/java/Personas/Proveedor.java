package Personas;

import Animales.Animal;
import Productos.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona{
    protected String organizacion;
    protected String tipoProveedor;
    protected static List<Persona> staticProveedor = new ArrayList<>();
    static String QUERY = "SELECT * FROM proveedor";

    public Proveedor(String rut, String nombre, int edad) {
        super(rut, nombre, edad);
        this.actualizarDB();
    }

    @Override
    public void agregarStatico() {
        staticProveedor.add(this);
    }

    @Override
    public void actualizarDB() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("Insertando datos en la tabla...");

            String sql = "INSERT INTO proveedor (rut, nombre, edad, organizacion, tipo_proveedor) values "
                    + "(" + super.rut + "," +super.nombre + "," + super.edad
                    + "," + organizacion + "," + tipoProveedor + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarProveedor(){
        try {
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()){
                System.out.println("RUT: " + rs.getString("rut"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Edad: " + rs.getInt("edad"));
                System.out.println("Organizacion: " + rs.getString("organizacion"));
                System.out.println("TipoProveedor: " + rs.getString("tipo_proveedor"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static List<Persona> getStaticProveedor() {
        return staticProveedor;
    }

    public void agregarProducto(Producto producto, int cantidad){
        producto.agregarNStock(cantidad);
    }

    @Override
    public String toString() {
        return super.toString() + organizacion + tipoProveedor;
    }
}
