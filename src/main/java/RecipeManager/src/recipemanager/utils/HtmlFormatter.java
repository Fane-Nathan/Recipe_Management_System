package RecipeManager.src.recipemanager.utils;

import RecipeManager.src.recipemanager.model.Recipe;

public class HtmlFormatter implements Formatter {
    @Override
    public String format(Recipe recipe) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='recipe'>\n");
        sb.append("  <h1>").append(recipe.getTitle()).append("</h1>\n");
        sb.append("  <div class='meta'>\n");
        sb.append("    <p>ID: ").append(recipe.getId()).append("</p>\n");
        sb.append("    <p>Category: ").append(recipe.getCategory()).append("</p>\n");
        sb.append("    <p>Dietary: ").append(recipe.getDietaryPreferences()).append("</p>\n");
        sb.append("    <p>Total Time: ").append(recipe.calculateTotalTime()).append(" minutes</p>\n");
        sb.append("  </div>\n");
        sb.append("  <h2>Ingredients</h2>\n<ul>\n");
        recipe.getIngredients().forEach(i -> sb.append("    <li>")
                .append(i.getQuantity()).append(" ")
                .append(i.getUnit()).append(" ")
                .append(i.getName()).append("</li>\n"));
        sb.append("</ul>\n<h2>Steps</h2>\n<ol>\n");
        recipe.getSteps().forEach(s -> sb.append("    <li>")
                .append(s.getDescription())
                .append(" <em>(").append(s.getDurationMinutes()).append(" minutes)</em></li>\n"));
        sb.append("</ol>\n</div>");
        return sb.toString();
    }
}