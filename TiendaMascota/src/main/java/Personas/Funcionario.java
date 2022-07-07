package Personas;

import Animales.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Persona{
    protected String cargo;
    protected String fono;
    protected String correo;
    protected String direccion;
    protected int sueldo;
    protected boolean tipoJornada;
    protected static List<Persona> staticFuncionario = new ArrayList<>();
    static String QUERY = "SELECT * FROM funcionarios";

    public Funcionario(String rut, String nombre, int edad) {
        super(rut, nombre, edad);
    }

    @Override
    public void agregarStatico() {
        staticFuncionario.add(this);
    }

    @Override
    public void actualizarDB() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("Insertando datos en la tabla...");

//todo arreglar
            String sql = "INSERT INTO funcionario (rut, nombre, edad) values " + "(" + super.rut + "," + super.nombre + "," +super.edad + ");";
            stmt.executeUpdate(sql);
            System.out.println(sql);

            System.out.println("Datos insertados en la tabla...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarFuncionario(){
        try {
            Connection con = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()){
                System.out.println("RUT: " + rs.getString("rut"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Edad: " + rs.getInt("edad"));
                System.out.println("Cargo: " + rs.getString("cargo"));
                System.out.println("Fono: " + rs.getString("fono"));
                System.out.println("Correo: " + rs.getString("correo"));
                System.out.println("Direccion: " + rs.getString("direccion"));
                System.out.println("Sueldo: " + rs.getInt("sueldo"));
                System.out.println("TipoJornada: " + rs.getString("tipo_jornada"));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static List<Persona> getStaticFuncionario() {
        return staticFuncionario;
    }

    private String tipoContrato(){
        if (this.tipoJornada == true){
            return "completa";
        }else {
            return "parcial";
        }
    }

    @Override
    public String toString() {
        return super.toString()+
                "Cargo: " + cargo + fono + '\n' +
                "Correo: " + correo + direccion + sueldo + tipoContrato() ;
    }
}
