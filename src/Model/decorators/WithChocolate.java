package Model.decorators;

import Model.coffees.Coffee;
import Model.coffees.Ingredient;

import java.util.List;

public class WithChocolate extends CoffeeDecorator {

    public WithChocolate(Coffee coffee){
        super(coffee);
    }

    @Override
    public String getTitle(){ return this.coffee.getTitle() + " with Chocolate"; }

    @Override
    public int getPrice(){
        return this.coffee.getPrice() + 20;
    }

    @Override
    public List<Ingredient> getIngredientList(){
        List<Ingredient>  ingredients = this.coffee.getIngredientList();
        ingredients.add(new Ingredient("Chocolate",20));
        return ingredients;
    }
}

