package com.dhernandez.recetas.mappers;

import com.dhernandez.recetas.dtos.IngredientDto;
import com.dhernandez.recetas.entities.Ingredient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface IngredientMapper {

    List<IngredientDto> toListIngredientsDto(List<Ingredient> ingredients);
    List<Ingredient> toListIngredients(List<IngredientDto> ingredientsDto);
}
