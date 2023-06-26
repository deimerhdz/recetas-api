package com.dhernandez.recetas.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "steps")
public class Step {
    @Id
    private String id;
    private String description;

    public Step(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Step() {
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
