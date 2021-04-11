package Meal_Maker_and_Checker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SameMealCheck<T extends Comparable> {

    public static void main(String [] args){

        Meal Stew_chicken = new Meal.MealBuilder("Stew With Chicken").addRecipe("chicken breasts")
                .addRecipe("ground turmeric").addRecipe("peanut butter").addRecipe("onion")
                .addRecipe("diced tomatoes").build();
        Meal Lamb_tagine = new Meal.MealBuilder("Lamb Tagine")
                .addRecipe("ground turmeric")
                .addRecipe("cardamom")
                .addRecipe("ground coriander").build();
        Meal pizza = new Meal.MealBuilder("pizza").addRecipe("chicken breasts")
                .addRecipe("ground turmeric").addRecipe("peanut butter").addRecipe("onion")
                .addRecipe("diced tomatoes").build();
        Meal burger = new Meal.MealBuilder("burger")
                .addRecipe("ground turmeric")
                .addRecipe("cardamom")
                .addRecipe("ground coriander").build();
        List<Meal> meals = new ArrayList<Meal>();
        meals.add(Stew_chicken);
        meals.add(Lamb_tagine);
        meals.add(pizza);
        meals.add(burger);
        StringBuilder SB = sameMeal_checker(meals);
        System.out.println(SB.toString());

    }

    public static StringBuilder sameMeal_checker(List<Meal> meals){

        for(int I = 0; I< meals.size(); I++) {
            Collections.sort(meals.get(I).getRecipes());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("FOUND LIST OF SAME MEALS: ");
        int count = 0;
        for(int I = 0; I< meals.size() - 1; I++) {
            for(int J = I + 1; J < meals.size(); J++){

                if(meals.get(I).getSize() == meals.get(J).getSize()
                        && meals.get(I).getItemNumber(0) == meals.get(J).getItemNumber(0)){
                    String check = mealCheck_Helper(meals.get(I), meals.get(J));

                    if(check != "0"){
                        count += 1;
                        sb.append("\n" + count + ". "
                                +meals.get(I).getMeal_name() + " and "+ meals.get(J).getMeal_name()
                                + " are the same meals \n")
                                .append("==> Same recipes: "+ check);
                    }
                }
            }
        }
        if(sb.length() == 0) return new StringBuilder("Every meal is unique");
        return sb;
    }

    public static String mealCheck_Helper(Meal temp1, Meal temp2){

        String temps = temp1.getFirst_Item();
        for(int I = 1; I < temp1.getSize(); I++){
            if(temp1.getItemNumber(I) != temp2.getItemNumber(I)) return "0";
            temps += ", "+ temp1.getItemNumber(I);
        }
        return temps;
    }
}
