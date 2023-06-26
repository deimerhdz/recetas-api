package com.dhernandez.recetas.mappers;

import com.dhernandez.recetas.dtos.IngredientDto;
import com.dhernandez.recetas.dtos.StepDto;
import com.dhernandez.recetas.entities.Ingredient;
import com.dhernandez.recetas.entities.Step;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface StepMapper {

    List<StepDto> toListStepsDto(List<Step> ingredients);
    List<Step> toListStep(List<StepDto> ingredientsDto);
}
