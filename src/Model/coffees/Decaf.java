package Model.coffees;

import java.util.ArrayList;
import java.util.List;

public class Decaf extends Coffee{

    @Override
    public String getTitle(){
        return "Decaf";
    }

    @Override
    public int getPrice(){
        return 20;
    }

    @Override
    public List<Ingredient> getIngredientList(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("coffee beans", 30));
        ingredients.add(new Ingredient("water", 40));
        return ingredients;
    }
}
