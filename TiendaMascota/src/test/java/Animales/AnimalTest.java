package Animales;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Terrestre a1;

    @BeforeEach
    void setUp() {

        a1 = new Terrestre (2233,"cat","angora","felino","negro",2,2,99999,true,"desconocido","carne y pescado");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void esteAnimal() {
        assertEquals(a1, a1.esteAnimal());
    }

    @Test
   void sexo(){
        assertEquals("hembra",a1.sexo());
    }

    @Test
    void testToString() {
    }
}