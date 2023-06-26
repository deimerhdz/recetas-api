package com.dhernandez.recetas.controllers;

import com.dhernandez.recetas.dtos.MeasureDto;
import com.dhernandez.recetas.services.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measures")
public class MeasureController {

    @Autowired
    MeasureService measureService;
    @GetMapping("/list")
    ResponseEntity<List<MeasureDto>> saveMeasure(){
        List<MeasureDto> measureList = measureService.findAllMeasures();
        return new ResponseEntity<>(measureList, HttpStatus.OK);
    }
    @PostMapping("/save")
    ResponseEntity<MeasureDto> saveMeasure(@RequestBody MeasureDto measureDto){
        MeasureDto measure = measureService.saveMeasure(measureDto);

        return new ResponseEntity<>(measure, HttpStatus.OK);
    }
}
