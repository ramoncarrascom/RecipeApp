package es.ramoncarrasco.spring5recipeapp.services;

import es.ramoncarrasco.spring5recipeapp.commands.IngredientCommand;
import es.ramoncarrasco.spring5recipeapp.converters.IngredientToIngredientCommand;
import es.ramoncarrasco.spring5recipeapp.domain.Recipe;
import es.ramoncarrasco.spring5recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Ingredient service implementation
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //TODO - Implement error handling
            log.error("Recipe id not found. Id:" + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient))
                .findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //TODO - Implement error handling
            log.error("Ingredient id not found. Id:" + ingredientId + " recipe Id:" + recipeId);
        }

        return ingredientCommandOptional.get();
    }
}
