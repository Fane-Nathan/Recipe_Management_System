package RecipeManager.src.recipemanager.model;

public class Step {
    private int stepNumber;
    private String description;
    private int durationMinutes;

    public Step(int stepNumber, String description, int durationMinutes) {
        this.stepNumber = stepNumber;
        this.description = description;
        this.durationMinutes = durationMinutes;
    }

    // Getters
    public int getStepNumber() { return stepNumber; }
    public String getDescription() { return description; }
    public int getDurationMinutes() { return durationMinutes; }
}