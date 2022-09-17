package guru.springframework.spring5_03_recipe.repositories;

import guru.springframework.spring5_03_recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
