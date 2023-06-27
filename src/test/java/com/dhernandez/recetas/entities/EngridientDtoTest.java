package com.dhernandez.recetas.entities;

import com.dhernandez.recetas.dtos.IngredientDto;
import com.dhernandez.recetas.dtos.MeasureDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngridientDtoTest {

    @Test
    void test(){
        IngredientDto ingredient = new IngredientDto("sad","Cebolla",1,new MeasureDto("11","Al gusto"));

        assertEquals("sad",ingredient.getId());
        assertEquals("Cebolla",ingredient.getName());
        assertEquals(1,ingredient.getQuantity());
        assertEquals("11",ingredient.getMeasure().getId());
        assertEquals("Al gusto",ingredient.getMeasure().getName());
    }
}
