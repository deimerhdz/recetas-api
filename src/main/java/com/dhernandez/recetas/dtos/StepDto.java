package com.dhernandez.recetas.dtos;

import java.io.Serializable;

public class StepDto implements Serializable {

    private String id;
    private String description;

    public StepDto(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public StepDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
