package Model.command;

import Model.singleton.Barista;
import Model.coffees.Coffee;

public class DeliverOrder extends Order {

    public DeliverOrder(Barista barista, Coffee coffee) {
        super(barista, coffee);
    }

    public void execute(){
        System.out.println("Your " + this.getCoffee().getTitle()+" is here");
    }

}
