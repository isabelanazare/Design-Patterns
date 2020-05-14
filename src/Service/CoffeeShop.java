package Service;

import Model.coffees.Coffee;
import Model.singleton.Barista;
import Model.command.Waiter;
import java.util.List;

public interface CoffeeShop {

    void addCoffee(Coffee coffee);
    void orderCoffee(Barista barista, Waiter waiter);
    List<Coffee> getMenu();
    Coffee getCoffeeByTitle(String title);
    void populateMenu();
}
