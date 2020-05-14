package Model.states;

import Model.command.Order;

public abstract class State {

    public abstract void doAction(Order order);
    public abstract void displayState();
}
