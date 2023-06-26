package com.dhernandez.recetas.repositories;

import com.dhernandez.recetas.entities.Measure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MeasureRepository extends MongoRepository<Measure,Long> {
}
