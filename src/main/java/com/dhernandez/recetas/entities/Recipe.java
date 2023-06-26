package com.dhernandez.recetas.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private String id;

    private String name;

    private String description;

    private Integer portion;

    private List<Ingredient> ingredients;

    private List<Step> steps;

    public Recipe(String id, String name, String description, Integer portion, List<Ingredient> ingredients, List<Step> steps) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.portion = portion;
        this.ingredients = ingredients;
        this.steps = steps;
    }
    public Recipe() {
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
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
