package Model.coffees;

import java.util.List;

public abstract class Coffee {
    public abstract String getTitle();
    public abstract int getPrice();
    public abstract List<Ingredient> getIngredientList();
}
