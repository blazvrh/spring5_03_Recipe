package guru.springframework.spring5_03_recipe.bootstrap;

import guru.springframework.spring5_03_recipe.domain.*;
import guru.springframework.spring5_03_recipe.repositories.CategoryRepository;
import guru.springframework.spring5_03_recipe.repositories.RecipeRepository;
import guru.springframework.spring5_03_recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        Optional<Category> americanCategoryOptional = categoryRepository.findCategoryByDescription("American");
        if (americanCategoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found;");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findCategoryByDescription("Mexican");
        if (mexicanCategoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found;");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Optional<UnitOfMeasure> uomTeaspoonOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Teaspoon");
        if (uomTeaspoonOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }
        Optional<UnitOfMeasure> uomTablespoonOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Tablespoon");
        if (uomTablespoonOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }
        Optional<UnitOfMeasure> uomPinchOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Pinch");
        if (uomPinchOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }
        Optional<UnitOfMeasure> uomCloveOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Clove");
        if (uomCloveOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }
        Optional<UnitOfMeasure> uomCupOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Cup");
        if (uomCupOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }
        Optional<UnitOfMeasure> uomPintOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Pint");
        if (uomPintOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }
        Optional<UnitOfMeasure> uomEachOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Each");
        if (uomEachOptional.isEmpty()) {
            throw new RuntimeException("Unit of measure not found;");
        }

        UnitOfMeasure uomTeaspoon = uomTeaspoonOptional.get();
        UnitOfMeasure uomTablespoon = uomTablespoonOptional.get();
        UnitOfMeasure uomPinch = uomPinchOptional.get();
        UnitOfMeasure uomClove = uomCloveOptional.get();
        UnitOfMeasure uomCup = uomCupOptional.get();
        UnitOfMeasure uomPint = uomPintOptional.get();
        UnitOfMeasure uomEach = uomEachOptional.get();

        Recipe guacamoleRecipe = new Recipe();
        Recipe tacoRecipe = new Recipe();

        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.getCategories().add(mexicanCategory);
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setServings(4);
        guacamoleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamoleRecipe.setSource("Simply Recipes");

        tacoRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacoRecipe.setDifficulty(Difficulty.KIND_OF_HARD);
        tacoRecipe.getCategories().add(mexicanCategory);
        tacoRecipe.getCategories().add(americanCategory);
        tacoRecipe.setPrepTime(20);
        tacoRecipe.setCookTime(15);
        tacoRecipe.setServings(6);
        tacoRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacoRecipe.setSource("Simply Recipes");

        Ingredient avocado = new Ingredient("ripe avocados", BigDecimal.valueOf(2), uomEach, guacamoleRecipe);
        Ingredient kosherSalt = new Ingredient("kosher salt, plus more to taste", BigDecimal.valueOf(0.5), uomTeaspoon, guacamoleRecipe);
        Ingredient lemonJuice = new Ingredient("fresh lime or lemon juice", BigDecimal.valueOf(1), uomTablespoon, guacamoleRecipe);
        Ingredient onion = new Ingredient("minced red onion or thinly sliced green onion", BigDecimal.valueOf(3), uomTablespoon, guacamoleRecipe);
        Ingredient chili = new Ingredient("serrano (or jalapeño) chilis, stems and seeds removed, minced", BigDecimal.valueOf(2), uomEach, guacamoleRecipe);
        Ingredient cilantro = new Ingredient("cilantro (leaves and tender stems), finely chopped", BigDecimal.valueOf(2), uomTablespoon, guacamoleRecipe);
        Ingredient blackPepper = new Ingredient("freshly ground black pepper", BigDecimal.valueOf(1), uomPinch, guacamoleRecipe);
        Ingredient tomato = new Ingredient("ripe tomato, chopped (optional)", BigDecimal.valueOf(0.5), uomEach, guacamoleRecipe);
        Ingredient radish = new Ingredient("Red radish or jicama slices for garnish (optional)", BigDecimal.valueOf(1), uomEach, guacamoleRecipe);
        Ingredient tortilla = new Ingredient("Tortilla chips, to serve", BigDecimal.valueOf(6), uomEach, guacamoleRecipe);

        guacamoleRecipe.getIngredients().add(avocado);
        guacamoleRecipe.getIngredients().add(kosherSalt);
        guacamoleRecipe.getIngredients().add(lemonJuice);
        guacamoleRecipe.getIngredients().add(onion);
        guacamoleRecipe.getIngredients().add(chili);
        guacamoleRecipe.getIngredients().add(cilantro);
        guacamoleRecipe.getIngredients().add(blackPepper);
        guacamoleRecipe.getIngredients().add(tomato);
        guacamoleRecipe.getIngredients().add(radish);
        guacamoleRecipe.getIngredients().add(tortilla);

        Ingredient chiliPowder = new Ingredient("ancho chili powder", BigDecimal.valueOf(2), uomTablespoon, tacoRecipe);
        Ingredient driedOregano = new Ingredient("dried oregano", BigDecimal.valueOf(1), uomTablespoon, tacoRecipe);
        Ingredient driedCumin = new Ingredient("dried cumin", BigDecimal.valueOf(1), uomTablespoon, tacoRecipe);
        Ingredient sugar = new Ingredient("sugar", BigDecimal.valueOf(1), uomTeaspoon, tacoRecipe);
        Ingredient salt = new Ingredient("kosher salt", BigDecimal.valueOf(0.5), uomTeaspoon, tacoRecipe);
        Ingredient garlic = new Ingredient("garlic, finely chopped", BigDecimal.valueOf(1), uomClove, tacoRecipe);
        Ingredient orangeZest = new Ingredient("finely grated orange zest", BigDecimal.valueOf(1), uomTablespoon, tacoRecipe);
        Ingredient orangeJuice = new Ingredient("fresh-squeezed orange juice", BigDecimal.valueOf(3), uomTablespoon, tacoRecipe);
        Ingredient oliveOil = new Ingredient("olive oil", BigDecimal.valueOf(2), uomTablespoon, tacoRecipe);
        Ingredient chickenThighs = new Ingredient("skinless, boneless chicken thighs (1 1/4 pounds)", BigDecimal.valueOf(6), uomEach, tacoRecipe);
        Ingredient cornTortillas = new Ingredient("small corn tortillas", BigDecimal.valueOf(8), uomEach, tacoRecipe);
        Ingredient babyArugula = new Ingredient("packed baby arugula (3 ounces)", BigDecimal.valueOf(3), uomCup, tacoRecipe);
        Ingredient avocadoTaco = new Ingredient("medium ripe avocados, sliced", BigDecimal.valueOf(2), uomEach, tacoRecipe);
        Ingredient radishTaco = new Ingredient("radishes, thinly sliced", BigDecimal.valueOf(4), uomEach, tacoRecipe);
        Ingredient cheryTomato = new Ingredient("cherry tomatoes, halved", BigDecimal.valueOf(0.5), uomPint, tacoRecipe);
        Ingredient redOnion = new Ingredient("red onion, thinly sliced", BigDecimal.valueOf(0.25), uomEach, tacoRecipe);
        Ingredient cilantroTaco = new Ingredient("Roughly chopped cilantro", BigDecimal.valueOf(1), uomEach, tacoRecipe);
        Ingredient sourCream = new Ingredient("sour cream", BigDecimal.valueOf(0.5), uomCup, tacoRecipe);
        Ingredient milk = new Ingredient("milk", BigDecimal.valueOf(0.25), uomCup, tacoRecipe);
        Ingredient lime = new Ingredient("lime, cut into wedges", BigDecimal.valueOf(1), uomEach, tacoRecipe);

        tacoRecipe.getIngredients().add(chiliPowder);
        tacoRecipe.getIngredients().add(driedOregano);
        tacoRecipe.getIngredients().add(driedCumin);
        tacoRecipe.getIngredients().add(sugar);
        tacoRecipe.getIngredients().add(salt);
        tacoRecipe.getIngredients().add(garlic);
        tacoRecipe.getIngredients().add(orangeZest);
        tacoRecipe.getIngredients().add(orangeJuice);
        tacoRecipe.getIngredients().add(oliveOil);
        tacoRecipe.getIngredients().add(chickenThighs);
        tacoRecipe.getIngredients().add(cornTortillas);
        tacoRecipe.getIngredients().add(babyArugula);
        tacoRecipe.getIngredients().add(avocadoTaco);
        tacoRecipe.getIngredients().add(radishTaco);
        tacoRecipe.getIngredients().add(cheryTomato);
        tacoRecipe.getIngredients().add(redOnion);
        tacoRecipe.getIngredients().add(cilantroTaco);
        tacoRecipe.getIngredients().add(sourCream);
        tacoRecipe.getIngredients().add(milk);
        tacoRecipe.getIngredients().add(lime);

        Note guacamoleNote = new Note();
        guacamoleNote.setRecipeNotes("The best guacamole keeps it simple: just ripe avocados and a handful of flavorful mix-ins. Serve it as a dip at your next party or spoon it on top of tacos for an easy dinner upgrade.");
        guacamoleNote.setRecipe(guacamoleRecipe);
        guacamoleRecipe.setNotes(guacamoleNote);

        Note tacoNote = new Note();
        tacoNote.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
        tacoNote.setRecipe(tacoRecipe);
        tacoRecipe.setNotes(tacoNote);

        tacoRecipe.setNotes(tacoNote);

        String guacamoleDirections = "1. Cut the avocado:\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "\n2. Mash the avocado flesh:\n" +
                "Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n3. Add the remaining ingredients to taste:\n" +
                "Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste." +
                "\n4.Serve immediately:\n" +
                "If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)\n" +
                "Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "Refrigerate leftover guacamole up to 3 days.\n" +
                "Note: Chilling tomatoes hurts their flavor. So, if you want to add chopped tomato to your guacamole, add it just before serving.";
        guacamoleRecipe.setDirections(guacamoleDirections);

        String tacoDirections = "1. Prepare the grill:\n" +
                "Prepare either a gas or charcoal grill for medium-high, direct heat." +
                "\n2. Make the marinade and coat the chicken:\n" +
                "In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "\n3. Grill the chicken:\n" +
                "Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165°F. Transfer to a plate and rest for 5 minutes." +
                "\n4. Thin the sour cream with milk:\n" +
                "Stir together the sour cream and milk to thin out the sour cream to make it easy to drizzle." +
                "\n5. Assemble the tacos:\n" +
                "Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges." +
                "\n6. Warm the tortillas:\n" +
                "Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.";
        tacoRecipe.setDirections(tacoDirections);

        recipes.add(guacamoleRecipe);
        recipes.add(tacoRecipe);

        return recipes;
    }
}
