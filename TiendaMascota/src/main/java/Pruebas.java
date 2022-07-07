
import Animales.Acuatico;
import Personas.Cliente;

import Personas.Persona;


public class Pruebas {
    public static void main(String[] args) {


        //Persona c1 = new Cliente("20489916-9", "JabinEjemplo", 21);
        //Persona p1 = new Proveedor("12345678-9", "NombreEjemplo", 30);
        //Persona f1 = new Funcionario("98765432-1", "FuncionarioEjemplo", 40);

        //Pago pay1 = new Pago(12625,"efectivo",10000,"2022-06-30",p1,f1,"tienda");

        /*
        Acuatico a1 = new Acuatico(1,"a1", "a1", "a1", "a1", 1, 1, 1, true, "a1", "a1", true, 1);
        Acuatico a2 = new Acuatico(2,"a2", "a2", "a2", "a2", 2, 2, 2, true, "a2", "a2", true, 2);
        Acuatico a3 = new Acuatico(3,"a3", "a3", "a3", "a3", 3, 3, 3, true, "a3","a3",true,3);
        a1.agregarStatico();
        a2.agregarStatico();
        a3.agregarStatico();

        System.out.println(Acuatico.getStaticAcuatico());
        */

        Cliente.getStaticCliente().clear();

        Cliente c1 = new Cliente("'20489916-9'", "'cliente1'", 30);
        Cliente c2 = new Cliente("'20489916-9'", "'cliente2'", 40);
        Cliente c3 = new Cliente("'20489916-9'", "'cliente3'", 20);
        Cliente c4 = new Cliente("'20489916-9'", "'cliente4'", 25);

        c1.agregarStatico();
        c2.agregarStatico();
        c3.agregarStatico();
        c4.agregarStatico();

        System.out.println(Cliente.getStaticCliente());

        c1.actualizarDB();
    }
}