import Animales.Acuatico;
import Animales.Aereo;
import Animales.Animal;
import Animales.Terrestre;
import Personas.Cliente;
import Personas.Funcionario;
import Personas.Persona;
import Personas.Proveedor;
import Productos.Accesorio;
import Productos.Alimento;
import Productos.Medicamento;
import Productos.Producto;
import Transaccion.Pago;

public class Pruebas {
    public static void main(String[] args) {

        Persona c1 = new Cliente("20489916-9", "JabinEjemplo", 21);
        Persona p1 = new Proveedor("12345678-9", "NombreEjemplo", 30);
        Persona f1 = new Funcionario("98765432-1", "FuncionarioEjemplo", 40);

        Pago pay1 = new Pago(12625,"efectivo",10000,"2022-06-30",p1,f1,"tienda");

        /*
        Animal acuatico = new Acuatico();
        Animal aereo = new Aereo();
        Animal terrestre = new Terrestre();
        Producto accesorio = new Accesorio();
        Producto alimento = new Alimento();
        Producto medicamento = new Medicamento();

         */
    }
}