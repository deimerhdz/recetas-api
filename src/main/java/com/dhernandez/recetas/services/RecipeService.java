package com.dhernandez.recetas.services;

import com.dhernandez.recetas.dtos.RecipeDto;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
     List<RecipeDto> listAllRecipes();
     List<RecipeDto> listAllRecipesByName(String name);
     Optional<RecipeDto> getRecipeById(String id);
     RecipeDto saveRecipe(RecipeDto recipeDto);
     void deleteRecipeById(String id);
}
