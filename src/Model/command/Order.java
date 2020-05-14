package Model.command;

import Model.singleton.Barista;
import Model.coffees.Coffee;
import Model.states.State;

public class Order {
    private State currentState;
    private Barista barista;
    private Coffee coffee;

    public Order(Barista barista, Coffee coffee){
        this.coffee = coffee;
        this.barista = barista;
        this.currentState = null;
    }

    public void setState(State state){
        this.currentState = state;
    }

    public State getState(){ return this.currentState;}

    public Coffee getCoffee(){ return this.coffee;}

    public Barista getBarista(){ return this.barista;}

    public void execute() {
        this.barista.makeCoffee(this.coffee);
    }
}
