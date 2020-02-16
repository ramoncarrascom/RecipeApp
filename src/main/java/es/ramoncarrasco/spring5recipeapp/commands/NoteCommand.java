package es.ramoncarrasco.spring5recipeapp.commands;

import es.ramoncarrasco.spring5recipeapp.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Note Command
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Getter
@Setter
@NoArgsConstructor
public class NoteCommand {
    private Long id;
    private RecipeCommand recipe;
    private String recipeNote;
}
