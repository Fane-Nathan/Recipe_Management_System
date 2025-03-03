package RecipeManager.src.recipemanager.service;

import RecipeManager.src.recipemanager.model.Ingredient;
import RecipeManager.src.recipemanager.model.Recipe;
import java.util.*;

public class ShoppingListService {
    public List<Ingredient> generateShoppingList(List<Recipe> recipes) {
        Map<String, Ingredient> mergedIngredients = new HashMap<>();

        for (Recipe recipe : recipes) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                String key = ingredient.getName().toLowerCase() + "|" + ingredient.getUnit().toLowerCase();
                if (mergedIngredients.containsKey(key)) {
                    Ingredient existing = mergedIngredients.get(key);
                    existing.setQuantity(existing.getQuantity() + ingredient.getQuantity());
                } else {
                    mergedIngredients.put(key, new Ingredient(
                            ingredient.getName(),
                            ingredient.getQuantity(),
                            ingredient.getUnit()
                    ));
                }
            }
        }
        return new ArrayList<>(mergedIngredients.values());
    }
}