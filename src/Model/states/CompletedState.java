package Model.states;

import Model.command.Order;

public class CompletedState extends State{

    @Override
    public void doAction(Order order){
        order.setState(new CompletedState());
    }

    @Override
    public void displayState(){
        System.out.println("order is done");
    }
}
