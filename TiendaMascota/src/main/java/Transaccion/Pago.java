package Transaccion;

import Interface.Mostrable;
import Personas.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Pago implements Mostrable {
    private int codigo;
    private String tipo;
    private int monto;
    private String fecha;
    private Persona cobrador;
    private Persona pagador;
    private String direccion;
    static final String DB_URL = "jdbc:mysql://localhost/tienda_mascota";
    static final String USER = "uwu";
    static final String PASS = "12345678qwerty";

    public Pago(int codigo, String tipo, int monto, String fecha, Persona cobrador, Persona pagador, String direccion) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
        this.cobrador = cobrador;
        this.pagador = pagador;
        this.direccion = direccion;
    }

    @Override
    public void imprimirEnPantalla() {
        System.out.println(this);
    }

    public void actualizarDB(){

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("Insertando datos en la tabla...");


            String sql = "INSERT INTO cliente tipo, monto, fecha, cobrador, pagador, direccion) values "
                    + "(" + tipo + "," + fecha + "," + cobrador
                    + "," + pagador + "," + direccion +");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return
                 codigo + tipo + monto + fecha + cobrador + pagador + direccion;

    }
}
