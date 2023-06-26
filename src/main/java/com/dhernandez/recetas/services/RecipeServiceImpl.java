package com.dhernandez.recetas.services;

import com.dhernandez.recetas.dtos.RecipeDto;
import com.dhernandez.recetas.mappers.RecipeMapper;
import com.dhernandez.recetas.repositories.RecipeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{
    private Log LOG = LogFactory.getLog(RecipeServiceImpl.class);
    private RecipeRepository recipeRepository;

    private RecipeMapper recipeMapper;
    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    @Override
    public List<RecipeDto> listAllRecipes() {
        LOG.info("starting listAllRecipes method");
        List<RecipeDto> recipeDtoList = recipeMapper.toRecipesDto(recipeRepository.findAll());
        LOG.info("finishing listAllRecipes method");
        return recipeDtoList;
    }

    @Override
    public List<RecipeDto> listAllRecipesByName(String name) {
        LOG.info("starting listAllRecipesByName method");
        List<RecipeDto> recipeDtoList = recipeMapper.toRecipesDto(recipeRepository.findByNameLike(name));
        LOG.info("finishing listAllRecipesByName method");
        return recipeDtoList;

    }

    @Override
    public Optional<RecipeDto> getRecipeById(String id) {
        return recipeRepository.findById(id).map(recipe -> recipeMapper.toRecipeDto(recipe));
    }

    @Override
    public RecipeDto saveRecipe(RecipeDto recipeDto) {
        LOG.info("starting saveRecipe method"+recipeDto);
        RecipeDto recipeDtoDB = recipeMapper.toRecipeDto(recipeRepository.save(recipeMapper.toRecipe(recipeDto)));
        LOG.info("finishing saveRecipe method"+recipeDto);
        return recipeDtoDB;
    }

    @Override
    public void deleteRecipeById(String id) {
        LOG.info("starting deleteRecipeById method"+id);
        recipeRepository.deleteById(id);
        LOG.info("finishing deleteRecipeById method"+id);
    }
}
