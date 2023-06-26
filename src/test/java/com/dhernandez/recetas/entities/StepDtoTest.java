package com.dhernandez.recetas.entities;

import com.dhernandez.recetas.dtos.StepDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDtoTest {

    @Test
    void test(){
        StepDto stepDto = new StepDto("sad","hervir agua");

        assertEquals("sad",stepDto.getId());
        assertEquals("hervir agua",stepDto.getDescription());

    }
}
