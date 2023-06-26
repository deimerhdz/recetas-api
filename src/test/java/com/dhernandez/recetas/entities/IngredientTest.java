package com.dhernandez.recetas.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {

    @Test
    void test(){
        Ingredient ingredient = new Ingredient("sad","Cebolla",1,new Measure("11","Al gusto"));

        assertEquals("sad",ingredient.getId());
        assertEquals("Cebolla",ingredient.getName());
        assertEquals(1,ingredient.getQuantity());
        assertEquals("11",ingredient.getMeasure().getId());
        assertEquals("Al gusto",ingredient.getMeasure().getName());
    }
}
