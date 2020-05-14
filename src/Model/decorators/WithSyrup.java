package Model.decorators;

import Model.coffees.Coffee;
import Model.coffees.Ingredient;

import java.util.List;

public class WithSyrup extends CoffeeDecorator{

    public WithSyrup(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getTitle(){
        return this.coffee.getTitle() + " with Syrup";
    }

    @Override
    public int getPrice(){
        return this.coffee.getPrice() + 30;
    }

    @Override
    public List<Ingredient> getIngredientList(){
        List<Ingredient>  ingredients = this.coffee.getIngredientList();
        ingredients.add(new Ingredient("Syrup",10));
        return ingredients;
    }
}
