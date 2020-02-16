package es.ramoncarrasco.spring5recipeapp.commands;

import es.ramoncarrasco.spring5recipeapp.domain.Category;
import es.ramoncarrasco.spring5recipeapp.domain.Ingredient;
import es.ramoncarrasco.spring5recipeapp.domain.Note;
import es.ramoncarrasco.spring5recipeapp.domain.enums.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Recipe Command
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private NoteCommand note;
    private Set<CategoryCommand> categories = new HashSet<>();
    private Difficulty difficulty;
    private String description;
    private String directions;
    private Byte[] image;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
}
