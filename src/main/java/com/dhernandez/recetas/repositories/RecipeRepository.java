package com.dhernandez.recetas.repositories;

import com.dhernandez.recetas.entities.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe,String> {

    List<Recipe> findByNameLike(String name);
}
