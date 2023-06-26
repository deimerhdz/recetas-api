package com.dhernandez.recetas.entities;

import com.dhernandez.recetas.dtos.IngredientDto;
import com.dhernandez.recetas.dtos.MeasureDto;
import com.dhernandez.recetas.dtos.RecipeDto;
import com.dhernandez.recetas.dtos.StepDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeDtoTest {

    @Test
    public void test(){
        MeasureDto measure2 = new MeasureDto(null,"Al gusto");
        IngredientDto ingredient1 = new IngredientDto("1ss","Al gusto",2,measure2);
        IngredientDto ingredient2 = new IngredientDto("1ss","Al gusto",2,measure2);
        List<IngredientDto> ingredients = Arrays.asList(ingredient1,ingredient2);


        StepDto step1 = new StepDto("1ss","Al gusto");
        StepDto step2 = new StepDto("1ss","Al gusto");
        List<StepDto> steps = Arrays.asList(step1,step2);

        RecipeDto recipe = new RecipeDto("bdshf6","Pasta","Pasta description",1,ingredients,steps);
        assertEquals("bdshf6",recipe.getId());
        assertEquals("Pasta description",recipe.getDescription());
        assertEquals("Pasta",recipe.getName());
        assertEquals(2,recipe.getIngredients().size());
        assertEquals(2,recipe.getSteps().size());

}
}
