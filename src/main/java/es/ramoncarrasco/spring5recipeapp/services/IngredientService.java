package es.ramoncarrasco.spring5recipeapp.services;

import es.ramoncarrasco.spring5recipeapp.commands.IngredientCommand;

/**
 * Ingredient service interface
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}
