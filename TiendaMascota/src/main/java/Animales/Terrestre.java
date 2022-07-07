package Animales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Terrestre extends Animal{
    protected static List<Animal> staticTerrestre = new ArrayList<>();
    static String QUERY = "SELECT * FROM aereo";

    public Terrestre(int codigo, String nombre, String raza, String especie, String color, double masa, int edad, int valor, boolean sexo, String paisOrigen, String tipoAlimentacion) {
        super(codigo, nombre, raza, especie, color, masa, edad, valor, sexo, paisOrigen, tipoAlimentacion);
        agregarStock();
    }

    @Override
    public void agregarStatico() {
        staticTerrestre.add(this);
    }

    public static List<Animal> getStaticAereo() {
        return staticTerrestre;
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


            String sql = "INSERT INTO terrestre (nombre, raza, especie, color, masa, edad, valor, sexo, pais_origen, tipo_alimentacion) values "
                    + "(" + super.nombre + "," + super.raza
                    + "," + super.especie + "," + super.color + "," + super.masa + "," + super.edad
                    + "," + super.valor + "," + super.sexo + "," + super.paisOrigen
                    + "," + super.tipoAlimentacion + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarTerrestre(){
        try {
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()){
                System.out.println("Codigo: " + rs.getInt("codigo"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Raza: " + rs.getString("raza"));
                System.out.println("Especie: " + rs.getString("especie"));
                System.out.println("Color: " + rs.getString("color"));
                System.out.println("Masa: " + rs.getDouble("masa"));
                System.out.println("Edad: " + rs.getInt("edad"));
                System.out.println("Valor: " + rs.getInt("valor"));
                System.out.println("Sexo: " + rs.getString("sexo"));
                System.out.println("PaisOrigen: " + rs.getString("pais_origen"));
                System.out.println("TipoAlimentacion: " + rs.getString("tipo_alimentacion"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
