package Meal_Maker_and_Checker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SameMealCheck<T extends Comparable> {

    public static void main(String [] args){

        MealOptions Stew_chicken = new MealOptions.Build("Stew With Chicken").addRecipe("chicken breasts")
                .addRecipe("ground turmeric").addRecipe("peanut butter").addRecipe("onion")
                .addRecipe("diced tomatoes").Create();
        MealOptions Lamb_tagine = new MealOptions.Build("Lamb Tagine")
                .addRecipe("ground turmeric")
                .addRecipe("cardamom")
                .addRecipe("ground coriander").Create();
        MealOptions pizza = new MealOptions.Build("pizza").addRecipe("chicken breasts")
                .addRecipe("ground turmeric").addRecipe("peanut butter").addRecipe("onion")
                .addRecipe("diced tomatoes").Create();
        MealOptions burger = new MealOptions.Build("burger")
                .addRecipe("ground turmeric")
                .addRecipe("cardamom")
                .addRecipe("ground coriander").Create();
        List<MealOptions> mealOption = new ArrayList<MealOptions>();
        mealOption.add(Stew_chicken);
        mealOption.add(Lamb_tagine);
        mealOption.add(pizza);
        mealOption.add(burger);
        StringBuilder SB = sameMeal_checker(mealOption);
        System.out.println(SB.toString());

    }

    public static StringBuilder sameMeal_checker(List<MealOptions> meals){
        if(meals.size() == 0) return new StringBuilder("No selected meals");
        if(meals.size() == 1) return new StringBuilder("Only one order = " + meals.get(0).getMeal_name());

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

    public static String mealCheck_Helper(MealOptions temp1, MealOptions temp2){

        String temps = temp1.getFirst_Item();
        for(int I = 1; I < temp1.getSize(); I++){
            if(temp1.getItemNumber(I) != temp2.getItemNumber(I)) return "0";
            temps += ", "+ temp1.getItemNumber(I);
        }
        return temps;
    }
}
