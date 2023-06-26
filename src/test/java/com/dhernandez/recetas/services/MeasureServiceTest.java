package com.dhernandez.recetas.services;

import com.dhernandez.recetas.dtos.MeasureDto;
import com.dhernandez.recetas.entities.Measure;
import com.dhernandez.recetas.mappers.MeasureMapper;
import com.dhernandez.recetas.repositories.MeasureRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MeasureServiceTest {

    @InjectMocks
    private MeasureServiceImpl measureServiceImpl;
    @Mock
    private MeasureRepository measureRepository;

    private Measure measure;
    private MeasureDto measureDto;

    @Mock
    MeasureMapper measureMapper;

    @BeforeEach
    void setup(){

        measure  = new Measure("1l","Kilogramo");
        measureDto= new MeasureDto("1l","Kilogramo");
    }

    @DisplayName("Test for measure save")
    @Test
    void saveMeasureTest(){
        //give
        MeasureDto measureDto = new MeasureDto(null,"Al gusto");
        given(measureRepository.save(measure)).willReturn(measure);
        given(measureMapper.toMeasure(any())).willReturn(measure);
        given(measureMapper.toMeasureDto(any())).willReturn(measureDto);
        //when
        MeasureDto measureDB = measureServiceImpl.saveMeasure(measureDto);
        //then
        assertThat(measureDB).isNotNull();
    }

    @DisplayName("Test for  measures list")
    @Test
    void testMeasuresList(){
        //give
        MeasureDto measureDto2 = new MeasureDto(null,"Al gusto");
        List<MeasureDto> measuresList = Arrays.asList(measureDto,measureDto2);

        Measure measure2 = new Measure(null,"Al gusto");
        List<Measure> measuresList2 = Arrays.asList(measure2,measure);

        given(measureRepository.findAll()).willReturn(measuresList2);
        given(measureMapper.toMeasureDtos(any())).willReturn(measuresList);
        //when
        List<MeasureDto> measuresListDB = measureServiceImpl.findAllMeasures();
        //then
        assertThat(measuresListDB).isNotNull();
        assertThat(measuresListDB.size()).isGreaterThan(0);
    }
}
