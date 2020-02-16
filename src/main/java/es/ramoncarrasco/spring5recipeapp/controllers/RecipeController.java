package es.ramoncarrasco.spring5recipeapp.controllers;

import es.ramoncarrasco.spring5recipeapp.commands.RecipeCommand;
import es.ramoncarrasco.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Recipe controller
 * @author Ramón Carrasco
 * From Spring Guru RecipeApp https://github.com/springframeworkguru/spring5-recipe-app
 */
@Controller
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable Long id, Model model) {
        log.debug("Get id:"+id);
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping
    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
        log.debug("New recipe form");
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {

        if (command.getId() == null)
            log.debug("Saving new recipe:" + command.getDescription());
        else
            log.debug("Updating id:" + command.getId());

        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        if (command.getId() == null)
            log.debug("Saved id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable Long id, Model model) {
        log.debug("Updating id:" + id);
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeform";
    }

    @GetMapping
    @RequestMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable Long id, Model model) {
        log.debug("Deleting id:" + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
