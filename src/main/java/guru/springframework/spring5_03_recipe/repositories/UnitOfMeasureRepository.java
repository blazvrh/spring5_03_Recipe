package guru.springframework.spring5_03_recipe.repositories;

import guru.springframework.spring5_03_recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findUnitOfMeasureByDescription(String description);
}
