package Service;

import Model.coffees.Coffee;
import Model.singleton.Barista;
import Model.command.Waiter;

import java.util.List;

public class CoffeeShopProxy implements CoffeeShop {

    private final CoffeeShopService service;
    private final String userType;

    public CoffeeShopProxy(CoffeeShopService service, String userType) {
        this.service = service;
        this.userType = userType;
    }

    @Override
    public void addCoffee(Coffee coffee) {
        if (this.userType.equals("admin")) {
            this.service.addCoffee(coffee);
        } else {
            System.out.println("Only administrators can add a new coffee in the menu!");
        }
    }

    @Override
    public void orderCoffee(Barista barista, Waiter waiter) {
        if (this.userType.equals("client")) {
            this.service.orderCoffee(barista, waiter);
        } else {
            System.out.println("Administrators can't order coffee!");
        }
    }

    @Override
    public List<Coffee> getMenu() {
        if (this.userType.equals("client") || this.userType.equals("administrator")) {
            return this.service.getMenu();
        } else {
            System.out.println("Unauthorized to see menu");
        }
        return null;
    }

    @Override
    public Coffee getCoffeeByTitle(String title) {
        if (this.userType.equals("client") || this.userType.equals("administrator")) {
            return this.service.getCoffeeByTitle(title);
        } else {
            System.out.println("Unauthorized");
        }
        return null;
    }

    @Override
    public void populateMenu() { this.populateMenu();}
}
