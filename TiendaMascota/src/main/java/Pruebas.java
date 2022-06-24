import java.util.Date;

public class Pruebas {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("204899169", "Jabin", 21);
        c1.crearJSON();
        Persona sujeto1 = new Cliente("11240881-9", "Juan", 30);

        Pago p1 = new Pago(1234567, "efectivo", 5000,(122,7,22),sujeto1,sujeto1," un lugar");
    }
}