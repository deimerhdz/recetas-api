package com.dhernandez.recetas.services;

import com.dhernandez.recetas.dtos.IngredientDto;
import com.dhernandez.recetas.dtos.MeasureDto;
import com.dhernandez.recetas.dtos.RecipeDto;
import com.dhernandez.recetas.dtos.StepDto;
import com.dhernandez.recetas.entities.Ingredient;
import com.dhernandez.recetas.entities.Measure;
import com.dhernandez.recetas.entities.Recipe;
import com.dhernandez.recetas.entities.Step;
import com.dhernandez.recetas.mappers.RecipeMapper;
import com.dhernandez.recetas.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {
    @Mock
    private RecipeRepository recipeRepository;
    @InjectMocks
    private RecipeServiceImpl recipeServiceImpl;

    private Recipe recipe;
    private List<Ingredient> ingredientsObject;

    private List<Step> stepsObject;
    private List<IngredientDto> ingredients;
    private List<StepDto> steps;
    private RecipeDto recipeDto;

    @Mock
    RecipeMapper recipeMapper;
    @BeforeEach
    void setup(){
        //object
         ingredientsObject = Arrays.asList( new Ingredient("1ss","Al gusto",2,new Measure(null,"Al gusto")), new Ingredient("1ss","Al gusto",2,new Measure(null,"Al gusto")));
         stepsObject = Arrays.asList(new Step("1ss","Al gusto"),new Step("1ss","Al gusto"));
        //dtos
         ingredients = Arrays.asList(new IngredientDto("1ss","Al gusto",2,new MeasureDto(null,"Al gusto")),new IngredientDto("1ss","Al gusto",2,new MeasureDto(null,"Al gusto")));
         steps = Arrays.asList(new StepDto("1ss","Al gusto"),new StepDto("1ss","Al gusto"));

         recipe  = new Recipe("1l","pasta","pasta description",2,ingredientsObject,stepsObject);
         recipeDto= new RecipeDto("1l","pasta","pasta description",2,ingredients,steps);
    }
    @DisplayName("Test for recipe save")
    @Test
    void saveRecipetest(){
        //given
        RecipeDto newRecipe = new RecipeDto("1asl","pasta","pasta description",2,ingredients,steps);;
        given(recipeRepository.save(recipe)).willReturn(recipe);
        given(recipeMapper.toRecipe(any())).willReturn(recipe);
        given(recipeMapper.toRecipeDto(any())).willReturn(recipeDto);

        //when
        RecipeDto recipeDB = recipeServiceImpl.saveRecipe(newRecipe);
        //then
        assertThat(recipeDB).isNotNull();
    }


    @DisplayName("Test for recipe list")
    @Test

    void lisRecipeTest(){
        //give
        RecipeDto recipeDto1 = new RecipeDto("1asl","pasta","pasta description",2,ingredients,steps);
        List<RecipeDto> recipeDtoList =  Arrays.asList(recipeDto,recipeDto1);
        Recipe recipe1 = new Recipe("1asl","pasta","pasta description",2,ingredientsObject,stepsObject);
        List<Recipe> recipeList =  Arrays.asList(recipe,recipe1);

        given(recipeRepository.findAll()).willReturn(recipeList);
        given(recipeMapper.toRecipesDto(any())).willReturn(recipeDtoList);
        //when
        List<RecipeDto> recipeListDB = recipeServiceImpl.listAllRecipes();
        //then
        assertThat(recipeListDB).isNotNull();
        assertThat(recipeListDB.size()).isGreaterThan(0);
    }

    @DisplayName("Test for recipe list by name")
    @Test

    void lisRecipeTestByName(){
        //give
        RecipeDto recipeDto1 = new RecipeDto("1asl","pasta","pasta description",2,ingredients,steps);
        List<RecipeDto> recipeDtoList =  Arrays.asList(recipeDto);
        Recipe recipe1 = new Recipe("1asl","pasta","pasta description",2,ingredientsObject,stepsObject);
        List<Recipe> recipeList =  Arrays.asList(recipe);

        given(recipeRepository.findByNameLike("pasta")).willReturn(recipeList);
        given(recipeMapper.toRecipesDto(any())).willReturn(recipeDtoList);
        //when
        List<RecipeDto> recipeListDB = recipeServiceImpl.listAllRecipesByName("pasta");
        //then
        assertThat(recipeListDB).isNotNull();
        assertThat(recipeListDB.size()).isGreaterThan(0);
        assertThat(recipeListDB.size()).isEqualTo(1);
    }

    @Test
    void deleteRecipeByIdTest(){
        //give
        willDoNothing().given(recipeRepository).deleteById("1l");
        //when
        recipeServiceImpl.deleteRecipeById("1l");
        //then
        verify(recipeRepository,times(1)).deleteById("1l");
    }

    @DisplayName("get recipe by id")
    @Test
    void getRecipeTest(){
        //given
        given(recipeMapper.toRecipeDto(any())).willReturn(recipeDto);
        given(recipeRepository.findById("1L")).willReturn(Optional.of(recipe));
        //when
        RecipeDto recipeDto1 = recipeServiceImpl.getRecipeById("1L").get();
        //then
        assertThat(recipeDto1).isNotNull();
    }



}
