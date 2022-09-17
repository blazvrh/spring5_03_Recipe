package guru.springframework.spring5_03_recipe.repositories;

import guru.springframework.spring5_03_recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
