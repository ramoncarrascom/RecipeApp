package es.ramoncarrasco.spring5recipeapp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * UnitOfMeasure Entity
 * @author Ramón Carrasco
 * Based on Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

}
