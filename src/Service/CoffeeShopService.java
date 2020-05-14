package Service;

import Model.singleton.Barista;
import Model.command.Order;
import Model.coffees.Capuccino;
import Model.coffees.Coffee;
import Model.coffees.Decaf;
import Model.coffees.Espresso;
import Model.command.*;
import Model.decorators.WithChocolate;
import Model.decorators.WithMilk;
import Model.decorators.WithSyrup;
import Model.states.CompletedState;
import Model.states.ConfirmedState;
import Model.states.InProgressState;
import Model.states.State;
import Repository.CoffeeRepository;

import java.util.List;

public class CoffeeShopService implements CoffeeShop {
    private final CoffeeRepository coffees;

    public CoffeeShopService(CoffeeRepository repo){ this.coffees = repo;}

    @Override
    public void addCoffee(Coffee coffee){
        this.coffees.add(coffee);
    }

    @Override
    public void orderCoffee(Barista barista, Waiter waiter){
        Order order = new Order(barista, waiter.getCoffee());
        State state1 = new ConfirmedState();
        state1.doAction(order);
        order.getState().displayState();
        State state2 = new InProgressState();
        state2.doAction(order);
        order.getState().displayState();
        State state3 = new CompletedState();
        state3.doAction(order);
        order.getState().displayState();
        waiter.deliverOrder();
        waiter.chargeCoffee();
    }

    @Override
    public List<Coffee> getMenu(){
        return this.coffees.getCoffees();
    }

    @Override
    public Coffee getCoffeeByTitle(String title){
        return this.coffees.getByTitle(title);
    }

    @Override
    public void populateMenu(){
        Coffee capuccino = new Capuccino();
        Coffee capuccinoWithSyrupAndMilk = new WithMilk(new WithSyrup(new Capuccino()));
        Coffee espresso = new Espresso();
        Coffee espressoWithMilk = new WithMilk(new Espresso());
        Coffee espressoWithSyrup = new WithSyrup(new Espresso());
        Coffee decaf = new WithChocolate(new Decaf());
        Coffee simpleDecaf = new Decaf();

        this.coffees.add(capuccino);
        this.coffees.add(capuccinoWithSyrupAndMilk);
        this.coffees.add(espresso);
        this.coffees.add(espressoWithMilk);
        this.coffees.add(espressoWithSyrup);
        this.coffees.add(decaf);
        this.coffees.add(simpleDecaf);
    }
}
