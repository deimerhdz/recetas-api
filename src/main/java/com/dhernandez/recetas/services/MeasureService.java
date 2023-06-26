package com.dhernandez.recetas.services;

import com.dhernandez.recetas.dtos.MeasureDto;

import java.util.List;

public interface MeasureService {

    MeasureDto saveMeasure(MeasureDto measureDto);

    List<MeasureDto> findAllMeasures();
}
