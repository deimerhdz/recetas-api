package com.dhernandez.recetas.dtos;

import com.dhernandez.recetas.entities.Measure;

import java.io.Serializable;

public class IngredientDto implements Serializable {
    private String id;
    private String name;
    private Integer quantity;
    private MeasureDto measure;

    public IngredientDto() {
    }

    public IngredientDto(String id, String name, Integer quantity, MeasureDto measure) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MeasureDto getMeasure() {
        return measure;
    }

    public void setMeasure(MeasureDto measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", measure=" + measure +
                '}';
    }
}
