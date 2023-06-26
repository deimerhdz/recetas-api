package com.dhernandez.recetas.services;

import com.dhernandez.recetas.dtos.MeasureDto;
import com.dhernandez.recetas.entities.Measure;
import com.dhernandez.recetas.mappers.MeasureMapper;
import com.dhernandez.recetas.repositories.MeasureRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureServiceImpl implements MeasureService{

    private Log LOG = LogFactory.getLog(MeasureServiceImpl.class);
	private MeasureRepository measureRepository;
  
    private MeasureMapper measureMapper;
    @Autowired
    public MeasureServiceImpl(MeasureRepository measureRepository, MeasureMapper measureMapper) {
		this.measureRepository = measureRepository;
		this.measureMapper = measureMapper;
	}
	@Override
    public MeasureDto saveMeasure(MeasureDto measureDto) {
        LOG.info("starting saveMeasure method measureDto "+measureDto);
        MeasureDto measuredDb = measureMapper.toMeasureDto(measureRepository.save(this.measureMapper.toMeasure(measureDto)));
        LOG.info("Finishing saveMeasure method measureDto ");
        return measuredDb;
    }

    @Override
    public List<MeasureDto> findAllMeasures() {
        LOG.info("starting findAllMeasures method");
        List<MeasureDto> measureList =measureMapper.toMeasureDtos(measureRepository.findAll());
        LOG.info("Finishing findAllMeasures method ");
        return measureList;
    }
}
