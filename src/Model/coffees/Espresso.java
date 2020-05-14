package Model.coffees;

import java.util.ArrayList;
import java.util.List;

public class Espresso extends Coffee{

    @Override
    public String getTitle(){
        return "Espresso";
    }

    @Override
    public int getPrice(){
        return 30;
    }

    @Override
    public List<Ingredient> getIngredientList(){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("coffee beans", 40));
        ingredients.add(new Ingredient("water", 10));
        return ingredients;
    }
}
