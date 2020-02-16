package es.ramoncarrasco.spring5recipeapp.services;

import es.ramoncarrasco.spring5recipeapp.commands.IngredientCommand;
import es.ramoncarrasco.spring5recipeapp.converters.IngredientToIngredientCommand;
import es.ramoncarrasco.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import es.ramoncarrasco.spring5recipeapp.domain.Ingredient;
import es.ramoncarrasco.spring5recipeapp.domain.Recipe;
import es.ramoncarrasco.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Ingredient Service test
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public class IngredientServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    IngredientService ingredientService;
    IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
    }

    @Test
    public void findByRecipeIdAndIngredientId() {
    }

    @Test
    public void findByRecipeIdAndIngredientIdHappyPath() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        // when
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L,3L);

        // then
        assertEquals(ingredient3.getId(), ingredientCommand.getId());
        assertEquals(recipe.getId(), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

    @Test(expected = NoSuchElementException.class)
    public void findByRecipeIdAndIngredientIdRecipeNotFound() throws Exception {
        // given
        Optional<Recipe> emptyRecipe = Optional.empty();

        when(recipeRepository.findById(anyLong())).thenReturn(emptyRecipe);

        // when
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(2L,3L);
    }

    @Test(expected = NoSuchElementException.class)
    public void findByRecipeIdAndIngredientIdIngredientNotFound() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        recipe.addIngredient(ingredient1);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        // when
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L,4L);
    }
}