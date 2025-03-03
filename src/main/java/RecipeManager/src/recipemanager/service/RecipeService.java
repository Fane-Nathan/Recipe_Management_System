package RecipeManager.src.recipemanager.service;

import RecipeManager.src.recipemanager.repository.CrudRepository;
import RecipeManager.src.recipemanager.model.Recipe;
import RecipeManager.src.recipemanager.enums.Category;
import RecipeManager.src.recipemanager.enums.DietaryPreference;
import java.util.*;

public class RecipeService implements CrudRepository<Recipe> {
    private final Map<String, Recipe> recipes = new HashMap<>();
    private int idCounter = 0;

    @Override
    public Recipe create(Recipe recipe) {
        recipe.setId("R" + ++idCounter);
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public Optional<Recipe> getById(String id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public List<Recipe> getAll() {
        return new ArrayList<>(recipes.values());
    }

    @Override
    public Recipe update(Recipe updatedRecipe) {
        if (recipes.containsKey(updatedRecipe.getId())) {
            recipes.put(updatedRecipe.getId(), updatedRecipe);
            return updatedRecipe;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        recipes.remove(id);
    }

    public List<Recipe> searchByIngredient(String ingredientName) {
        return recipes.values().stream()
                .filter(r -> r.getIngredients().stream()
                        .anyMatch(i -> i.getName().equalsIgnoreCase(ingredientName)))
                .toList();
    }

    public List<Recipe> searchByCategory(Category category) {
        return recipes.values().stream()
                .filter(r -> r.getCategory() == category)
                .toList();
    }

    public List<Recipe> searchByDietaryPreference(DietaryPreference preference) {
        return recipes.values().stream()
                .filter(r -> r.getDietaryPreferences().contains(preference))
                .toList();
    }
}