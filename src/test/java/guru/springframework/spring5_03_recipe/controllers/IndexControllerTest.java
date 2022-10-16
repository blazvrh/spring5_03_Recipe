package guru.springframework.spring5_03_recipe.controllers;

import guru.springframework.spring5_03_recipe.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class IndexControllerTest {

    @Mock
    private RecipeService recipeService;
    @Mock
    private Model model;

    IndexController indexController;

    AutoCloseable mockitoClosable;

    @BeforeEach
    void setUp() {
        mockitoClosable = MockitoAnnotations.openMocks(this);

        indexController = new IndexController(recipeService);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoClosable.close();
    }

    @Test
    void getIndexPage() {
        String viewName = indexController.getIndexPage(model);
        assertEquals(viewName, "index");

        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
    }
}