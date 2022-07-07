package Personas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {
    protected static List<Persona> staticCliente = new ArrayList<>();
    static String QUERY = "SELECT * FROM clientes";


    public Cliente(String rut, String nombre, int edad) {
        super(rut, nombre, edad);
        this.actualizarDB();
    }



    @Override
    public void agregarStatico() {
        staticCliente.add(this);
    }

    @Override
    public void actualizarDB() {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("Insertando datos en la tabla...");


            String sql = "INSERT INTO cliente (rut, nombre, edad) values " + "(" + super.rut + "," + super.nombre + "," + super.edad + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarCliente(){
        try {
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        while (rs.next()){
            System.out.println("RUT: " + rs.getString("rut"));
            System.out.println("Nombre: " + rs.getString("nombre"));
            System.out.println("Edad: " + rs.getInt("edad"));
        }
    }catch (SQLException e){
        System.out.println(e);
        }
    }

    public static List<Persona> getStaticCliente() {
        return staticCliente;
    }

    @Override
    public String toString () {
        return super.toString();
    }
}

