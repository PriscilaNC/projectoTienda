package Transaccion;

import Animales.Acuatico;
import Animales.Animal;
import Personas.Cliente;
import Personas.Funcionario;
import Productos.Accesorio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoletaTest {
    Acuatico a1;
    Accesorio ac2;
    Boleta boletaA;
    Boleta boletaP;
    Pago pago;
    Cliente cliente;
    Funcionario funcionario;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("20489916-9", "jabin", 21);
        funcionario = new Funcionario("20489916-9", "juan", 22, "cajero", "958592674", "correo", "direccion", 10000, true);
        pago = new Pago(1, "efectivo", 1000, "10/11/2000",funcionario, cliente, "direccion2");
        ArrayList<Pago> arrPago = new ArrayList<>();
        arrPago.add(pago);
        boletaA = new Boleta(1, cliente, arrPago,1000);
        boletaP = new Boleta(2, cliente, arrPago,2000);
        a1 = new Acuatico(1,"a1", "a1", "a1", "a1", 1, 1, 1, true, "a1", "a1", true, 1);
        ArrayList<Animal> arrAnimal = new ArrayList<>();
        boletaA.agregarAnimal(a1);
        ac2 = new Accesorio(2,1000,"ac2", "descac2", "ac2", "ac2");
        boletaP.agregarProducto(ac2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void agregarAnimal() {
        assertFalse(boletaA.getDetalleAnimal().isEmpty());
    }

    @Test
    void agregarProducto() {
        assertFalse(boletaP.getDetalleProducto().isEmpty());
    }
}