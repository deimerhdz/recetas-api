package com.dhernandez.recetas.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepTest {

    @Test
    void test(){
        Step step = new Step("sad","hervir agua");

        assertEquals("sad",step.getId());
        assertEquals("Cebolla",step.getDescription());

    }
}
