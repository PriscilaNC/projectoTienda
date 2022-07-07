package Productos;

import Animales.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Alimento extends Producto{
    protected String fechaElaboracion;
    protected String fechaVencimiento;
    protected String tipoAnimal;
    protected double cantidadEnKg;
    protected static List<Producto> staticAlimento = new ArrayList<>();
    static String QUERY = "SELECT * FROM alimento";

    public Alimento(int codigo, int precio, String nombre, String descripcion, String fechaElaboracion, String fechaVencimiento, String tipoAnimal, double cantidadEnKg) {
        super(codigo, precio, nombre, descripcion);
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoAnimal = tipoAnimal;
        this.cantidadEnKg = cantidadEnKg;
        agregarStock();
    }

    @Override
    public void agregarStatico() {
        staticAlimento.add(this);
    }

    public static List<Producto> getStaticAlimento() {
        return staticAlimento;
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


            String sql = "INSERT INTO alimento (precio, nombre, descripcion, fecha_elab, fecha_caduc, tipo_animal, cantidadkg) values "
                    + "(" + super.precio + "," + super.nombre
                    + "," + super.descripcion + "," + fechaElaboracion
                    + "," + fechaVencimiento + "," + tipoAnimal + ","
                    + cantidadEnKg + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarAlimento(){
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
                System.out.println("TipoAnimal: " + rs.getString("tipo_animal"));
                System.out.println("CantidadKg: " + rs.getDouble("cantidadkg"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + fechaElaboracion + fechaVencimiento + tipoAnimal + cantidadEnKg ;
    }
}
