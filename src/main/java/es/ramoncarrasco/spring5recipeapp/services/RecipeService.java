package es.ramoncarrasco.spring5recipeapp.services;

import es.ramoncarrasco.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * Recipe service interface
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public interface RecipeService {

    Set<Recipe> getRecipes();

}
