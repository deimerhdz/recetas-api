package com.dhernandez.recetas.dtos;

import com.dhernandez.recetas.entities.Ingredient;
import com.dhernandez.recetas.entities.Step;

import java.io.Serializable;
import java.util.List;

public class RecipeDto implements Serializable {
    private String id;

    private String name;

    private String description;

    private Integer portion;

    private List<IngredientDto> ingredients;

    private List<StepDto> steps;

    public RecipeDto(String id, String name, String description, Integer portion, List<IngredientDto> ingredients, List<StepDto> steps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.portion = portion;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public RecipeDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPortion() {
        return portion;
    }

    public void setPortion(Integer portion) {
        this.portion = portion;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public List<StepDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDto> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", portion=" + portion +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                '}';
    }
}
