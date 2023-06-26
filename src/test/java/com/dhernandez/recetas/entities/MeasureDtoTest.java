package com.dhernandez.recetas.entities;

import com.dhernandez.recetas.dtos.MeasureDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasureDtoTest {
    @Test
    void test(){

        MeasureDto measureDto = new MeasureDto();
        measureDto.setId("1L");
        measureDto.setName("Kilogramo");

        assertEquals("1L",measureDto.getId());
        assertEquals("Kilogramo",measureDto.getName());
    }
}
