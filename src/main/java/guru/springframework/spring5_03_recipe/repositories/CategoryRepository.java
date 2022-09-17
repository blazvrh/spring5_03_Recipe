package guru.springframework.spring5_03_recipe.repositories;

import guru.springframework.spring5_03_recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
