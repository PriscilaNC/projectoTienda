package Conector;

import Personas.Cliente;

import java.sql.*;

public class SQLtest {
    static final String DB_URL = "jdbc:mysql://localhost/testdb";
    static final String USER = "testUser";
    static final String PASS = "12345678qwerty";
    static String QUERY = "SELECT * FROM Clientes";
    private SQLException e;

    /*public void agregarCliente() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("Insertando datos en la tabla...");

         String a = Cliente.leerJSON();

            String sql = "INSERT INTO cliente (rut,nombre,edad) VALUES ("+a+");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


    public static void consultarCliente(){try {
        Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        while (rs.next()){
            System.out.println("RUT: " + rs.getString("rut"));
            System.out.println("Nombre: " + rs.getString("nombre"));
            System.out.println("Edad: " + rs.getInt("edad"));
            System.out.println("Sexo: " + rs.getString("sexo"));
            System.out.println("Telefono: " + rs.getInt("telefono"));
            System.out.println("cFrecuente: " + rs.getInt("cFrecuente"));
        }
    }catch (SQLException e){
        System.out.println(e);
    }
    }
}
