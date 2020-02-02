package es.ramoncarrasco.spring5recipeapp.repositories;

import es.ramoncarrasco.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Recipe repository
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
