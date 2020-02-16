package es.ramoncarrasco.spring5recipeapp.controllers;

import es.ramoncarrasco.spring5recipeapp.domain.Category;
import es.ramoncarrasco.spring5recipeapp.domain.UnitOfMeasure;
import es.ramoncarrasco.spring5recipeapp.repositories.CategoryRepository;
import es.ramoncarrasco.spring5recipeapp.repositories.UnitOfMeasureRepository;
import es.ramoncarrasco.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Index controller
 * @author Ramón Carrasco
 * From Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        log.debug("IndexController model", model);
        return "index";
    }
}
