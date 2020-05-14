package Model.states;

import Model.command.Order;

public class InProgressState extends State {

    @Override
    public void doAction(Order order){
        order.setState(new InProgressState());
        order.execute();
    }

    @Override
    public void displayState() {
        System.out.println("order in progress");
    }
}
