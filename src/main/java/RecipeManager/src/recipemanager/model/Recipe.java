package RecipeManager.src.recipemanager.model;

import RecipeManager.src.recipemanager.enums.Category;
import RecipeManager.src.recipemanager.enums.DietaryPreference;
import java.util.*;

public class Recipe {
    private String id;
    private String title;
    private Category category;
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Step> steps = new ArrayList<>();
    private Set<DietaryPreference> dietaryPreferences = new HashSet<>();

    public int calculateTotalTime() {
        return steps.stream().mapToInt(Step::getDurationMinutes).sum();
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public List<Ingredient> getIngredients() { return ingredients; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }
    public List<Step> getSteps() { return steps; }
    public void setSteps(List<Step> steps) { this.steps = steps; }
    public Set<DietaryPreference> getDietaryPreferences() { return dietaryPreferences; }
    public void setDietaryPreferences(Set<DietaryPreference> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }
}