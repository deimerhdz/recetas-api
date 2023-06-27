package com.dhernandez.recetas.entities;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTest {

    @Test
    public void test(){
        Measure measure2 = new Measure(null,"Al gusto");
        Ingredient ingredient1 = new Ingredient("1ss","Al gusto",2,measure2);
        Ingredient ingredient2 = new Ingredient("1ss","Al gusto",2,measure2);
        List<Ingredient> ingredients = Arrays.asList(ingredient1,ingredient2);


        Step step1 = new Step("1ss","Al gusto");
        Step step2 = new Step("1ss","Al gusto");
        List<Step> steps = Arrays.asList(step1,step2);

        Recipe recipe = new Recipe("bdshf6","Pasta","Pasta description",1,ingredients,steps);
        assertEquals("bdshf6",recipe.getId());
        assertEquals("Pasta description",recipe.getDescription());
        assertEquals("Pasta",recipe.getName());
        assertEquals(2,recipe.getIngredients().size());
        assertEquals(2,recipe.getSteps().size());
    }
}
