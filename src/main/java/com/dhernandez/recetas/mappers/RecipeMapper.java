package com.dhernandez.recetas.mappers;

import com.dhernandez.recetas.dtos.RecipeDto;
import com.dhernandez.recetas.entities.Recipe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring",uses = {IngredientMapper.class, StepMapper.class})
public interface RecipeMapper {

    public RecipeDto toRecipeDto(Recipe recipe);

    public Recipe toRecipe(RecipeDto recipeDto);

    List<RecipeDto> toRecipesDto(List<Recipe> recipeLis);
}
