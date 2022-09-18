package guru.springframework.spring5_03_recipe.controllers;

import guru.springframework.spring5_03_recipe.domain.Category;
import guru.springframework.spring5_03_recipe.domain.UnitOfMeasure;
import guru.springframework.spring5_03_recipe.repositories.CategoryRepository;
import guru.springframework.spring5_03_recipe.repositories.UnitOfMeasureRepository;
import guru.springframework.spring5_03_recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
