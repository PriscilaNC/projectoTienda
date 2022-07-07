package Transaccion;

import Animales.Acuatico;
import Personas.Persona;
import Productos.Accesorio;
import Productos.Producto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//todo revisar boleta test
class BoletaTest {
    Acuatico a1;
    Accesorio ac2;

    @BeforeEach
    void setUp() {
        a1 = new Acuatico(1,"a1", "a1", "a1", "a1", 1, 1, 1, true, "a1", "a1", true, 1);
       ac2 = new Accesorio(2,1000,"ac2", "descac2", "ac2", "ac2");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void agregarAnimal(Boleta boleta) {
        boleta.agregarAnimal(a1);
        assertFalse(boleta.getDetalleAnimal().isEmpty());
    }

    @Test
    void agregarProducto(Boleta boleta) {
        boleta.agregarProducto(ac2);
        assertFalse(boleta.getDetalleProducto().isEmpty());
    }
}