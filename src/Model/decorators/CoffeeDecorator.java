package Model.decorators;

import Model.coffees.Coffee;
import Model.coffees.Ingredient;

import java.util.List;

public abstract class CoffeeDecorator extends Coffee {
    Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    public abstract String getTitle();
    public abstract int getPrice();
    public abstract List<Ingredient> getIngredientList();


}
