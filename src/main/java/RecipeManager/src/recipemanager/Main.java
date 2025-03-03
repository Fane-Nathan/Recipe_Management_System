package RecipeManager.src.recipemanager;

import RecipeManager.src.recipemanager.model.*;
import RecipeManager.src.recipemanager.enums.*;
import RecipeManager.src.recipemanager.service.*;
import RecipeManager.src.recipemanager.utils.*;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        RecipeService recipeService = new RecipeService();
        ShoppingListService shoppingService = new ShoppingListService();

        // Create sample recipe
        Recipe pancake = new Recipe();
        pancake.setTitle("Blueberry Pancakes");
        pancake.setCategory(Category.BREAKFAST);
        pancake.setIngredients(List.of(
                new Ingredient("Flour", 2, "cups"),
                new Ingredient("Milk", 1.5, "cups"),
                new Ingredient("Blueberries", 1, "cup")
        ));
        pancake.setSteps(List.of(
                new Step(1, "Mix dry ingredients", 5),
                new Step(2, "Add wet ingredients", 3),
                new Step(3, "Cook on griddle", 10)
        ));
        pancake.setDietaryPreferences(Set.of(DietaryPreference.VEGETARIAN));
        recipeService.create(pancake);

        // Demonstrate features
        System.out.println("=== ALL RECIPES ===");
        recipeService.getAll().forEach(System.out::println);

        System.out.println("\n=== SHOPPING LIST ===");
        shoppingService.generateShoppingList(recipeService.getAll())
                .forEach(i -> System.out.println(i.getQuantity() + " " + i.getUnit() + " " + i.getName()));

        System.out.println("\n=== FORMATTED RECIPE ===");
        Formatter textFormatter = new TextFormatter();
        Formatter htmlFormatter = new HtmlFormatter();
        System.out.println(textFormatter.format(pancake));
        System.out.println(htmlFormatter.format(pancake));
    }
}