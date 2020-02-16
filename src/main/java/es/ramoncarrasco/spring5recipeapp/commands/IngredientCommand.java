package es.ramoncarrasco.spring5recipeapp.commands;

import es.ramoncarrasco.spring5recipeapp.domain.Recipe;
import es.ramoncarrasco.spring5recipeapp.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Ingredient Command
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long Id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;
    private RecipeCommand recipe;
}
