package RecipeManager.src.recipemanager.utils;

import RecipeManager.src.recipemanager.model.Recipe;

public class TextFormatter implements Formatter {
    @Override
    public String format(Recipe recipe) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(recipe.getTitle()).append(" ===\n");
        sb.append("ID: ").append(recipe.getId()).append("\n");
        sb.append("Category: ").append(recipe.getCategory()).append("\n");
        sb.append("Dietary Preferences: ").append(recipe.getDietaryPreferences()).append("\n");
        sb.append("Total Time: ").append(recipe.calculateTotalTime()).append(" minutes\n\n");
        sb.append("Ingredients:\n");
        recipe.getIngredients().forEach(i -> sb.append("- ")
                .append(i.getQuantity()).append(" ")
                .append(i.getUnit()).append(" ")
                .append(i.getName()).append("\n"));
        sb.append("\nSteps:\n");
        recipe.getSteps().forEach(s -> sb.append(s.getStepNumber())
                .append(". ").append(s.getDescription())
                .append(" (").append(s.getDurationMinutes()).append(" mins)\n"));
        return sb.toString();
    }
}