package es.ramoncarrasco.spring5recipeapp.repositories;

import es.ramoncarrasco.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Category repository
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
