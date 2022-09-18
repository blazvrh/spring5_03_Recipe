package guru.springframework.spring5_03_recipe.services;

import guru.springframework.spring5_03_recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
