package Personas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    Cliente c1;
    @BeforeEach
    void setUp() {
       c1 = new Cliente("'20489916-9'", "'cliente1'", 30);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void agregarStatico() {
        c1.agregarStatico();
        assertFalse(Cliente.getStaticCliente().isEmpty());
    }
}