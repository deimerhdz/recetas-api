package com.dhernandez.recetas.controllers;

import com.dhernandez.recetas.dtos.RecipeDto;
import com.dhernandez.recetas.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/list")
    ResponseEntity<List<RecipeDto>> findAllRecipes(){
        return new ResponseEntity<>(recipeService.listAllRecipes(), HttpStatus.OK);
    }
    @GetMapping("/find")
    ResponseEntity<List<RecipeDto>> findAllRecipes(@RequestParam String name){
        return new ResponseEntity<>(recipeService.listAllRecipesByName(name), HttpStatus.OK);
    }


    @PostMapping("/save")
    ResponseEntity<RecipeDto> save(@RequestBody RecipeDto recipeDto){
        return new ResponseEntity<>(recipeService.saveRecipe(recipeDto),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<List<RecipeDto>> findAllRecipes(@PathVariable String id,@RequestBody RecipeDto recipeDto){
        if(recipeService.getRecipeById(id).isPresent()){
            recipeService.saveRecipe(recipeDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<RecipeDto> save(@PathVariable String id){
        if(recipeService.getRecipeById(id).isPresent()){
            recipeService.deleteRecipeById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
