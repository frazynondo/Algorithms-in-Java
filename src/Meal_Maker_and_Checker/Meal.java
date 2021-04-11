package Meal_Maker_and_Checker;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String meal_name;
    private List<String> Recipes = new ArrayList<String>();

    public String getMeal_name() {
        return meal_name;
    }


    public List<String> getRecipes() {
        return Recipes;
    }

    public int getSize() {
        return Recipes.size();
    }

    public String getItemNumber(int number) {
        return Recipes.get(number);
    }

    public String getFirst_Item() {
        return Recipes.get(0);
    }

    private Meal(MealBuilder builder) {
    this.Recipes = builder.Recipes;
    this.meal_name = builder.meal_name;
    }

    public static class MealBuilder{
        private String meal_name;
        private String top = "";
        private List<String> Recipes = new ArrayList<String>();


        public MealBuilder(String meal_name) {
            super();
            this.meal_name = meal_name;
        }
        public MealBuilder addRecipe(String recipe) {
            Recipes.add(recipe);
            return this;
        }

        public MealBuilder getRecipes() {
            return this;
        }

        public MealBuilder changeRecipe(String Exists, String newRecipe) {
            for(int I = 0; I< Recipes.size(); I++){
                if(Exists.toLowerCase().equals(Recipes.get(I).toLowerCase())){
                    this.Recipes.remove(I);
                    this.Recipes.add(newRecipe);
                    return this;
                }
            }
            System.out.println("The topping you entered does not exist. Please enter a valid topping");
            return this;
        }

        public Meal build(){
            return new Meal(this);
        }


    }

}
