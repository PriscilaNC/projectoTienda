package Personas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void agregarStatico() {
        Cliente c1 = new Cliente("'20489916-9'", "'cliente1'", 30);
        c1.agregarStatico();
        assertFalse(Cliente.getStaticCliente().isEmpty());
    }
}