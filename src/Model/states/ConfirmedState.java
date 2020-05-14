package Model.states;

import Model.command.Order;

public class ConfirmedState extends State {

    @Override
    public void doAction(Order order){ order.setState(new ConfirmedState());}

    @Override
    public void displayState(){ System.out.println("order confirmed");}
}
