package Model.decorators;

import Model.coffees.Coffee;
import Model.coffees.Ingredient;

import java.util.List;

public class WithMilk extends CoffeeDecorator{

    public WithMilk(Coffee coffee){ super(coffee);}

    @Override
    public String getTitle(){
        return this.coffee.getTitle() + " with Milk";
    }

    @Override
    public int getPrice(){
        return this.coffee.getPrice() + 30;
    }

    @Override
    public List<Ingredient> getIngredientList(){
        List<Ingredient>  ingredients = this.coffee.getIngredientList();
        ingredients.add(new Ingredient("Milk",30));
        return ingredients;
    }
}
