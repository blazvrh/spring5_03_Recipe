package guru.springframework.spring5_03_recipe.repositories;

import guru.springframework.spring5_03_recipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findUnitOfMeasureByDescription() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    void findUnitOfMeasureByDescriptionCup() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}