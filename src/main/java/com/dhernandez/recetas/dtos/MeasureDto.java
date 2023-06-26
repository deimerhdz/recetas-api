package com.dhernandez.recetas.dtos;
import java.io.Serializable;
public class MeasureDto implements Serializable {

    private String id;
    private String name;
    public MeasureDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public MeasureDto() {
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

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
