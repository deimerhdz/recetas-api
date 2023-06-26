package com.dhernandez.recetas.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MesureTest {

    @Test
    void test(){

        Measure measure = new Measure();
        measure.setId("1l");
        measure.setName("Kilogramo");

        assertEquals("1l",measure.getId());
        assertEquals("Kilogramo",measure.getName());
    }
}
