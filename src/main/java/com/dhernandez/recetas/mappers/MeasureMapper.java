package com.dhernandez.recetas.mappers;

import com.dhernandez.recetas.dtos.MeasureDto;
import com.dhernandez.recetas.entities.Measure;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "Spring")
public interface MeasureMapper {
    Measure toMeasure(MeasureDto measureDto);
    MeasureDto toMeasureDto(Measure measure);
    List<MeasureDto> toMeasureDtos(List<Measure> measures);
}
