package Productos;

import Animales.Animal;
import Personas.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Accesorio extends Producto{
    protected String material;
    protected String tipo;
    protected static List<Producto> staticAccesorio = new ArrayList<>();
    static String QUERY = "SELECT * FROM accesorio";

    public Accesorio(int codigo, int precio, String nombre, String descripcion, String material, String tipo) {
        super(codigo, precio, nombre, descripcion);
        this.material = material;
        this.tipo = tipo;
        this.agregarStock();
        this.actualizarDB();
    }

    @Override
    public void agregarStatico() {
        staticAccesorio.add(this);
    }

    public static List<Producto> getStaticAccesorio() {
        return staticAccesorio;
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


            String sql = "INSERT INTO accesorio (precio, nombre, descripcion, material, tipo) values "
                    + "(" + super.precio + "," + super.nombre
                    + "," + super.descripcion + ","  + material + ","
                    + tipo + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarAccesorio(){
        try {
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()){
                System.out.println("Codigo: " + rs.getInt("codigo"));
                System.out.println("Precio: " + rs.getInt("precio"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("Material: " + rs.getString("material"));
                System.out.println("Tipo: " + rs.getString("tipo"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }



    @Override
    public String toString() {
        return super.toString()+tipo+material;

    }
}
