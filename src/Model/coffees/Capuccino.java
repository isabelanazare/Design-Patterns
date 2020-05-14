package Model.coffees;

import java.util.ArrayList;
import java.util.List;

public class Capuccino extends Coffee {

    @Override
    public String getTitle(){
        return "Capuccino";
    }

    @Override
    public int getPrice(){
        return 25;
    }

    @Override
    public List<Ingredient> getIngredientList(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("coffee beans", 30));
        ingredients.add(new Ingredient("water", 20));
        return ingredients;
    }
}
