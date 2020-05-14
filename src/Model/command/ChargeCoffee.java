package Model.command;

import Model.coffees.Coffee;
import Model.singleton.Barista;

public class ChargeCoffee extends Order {

    public ChargeCoffee(Barista barista, Coffee coffee) { super(barista, coffee); }

    public void execute(){
        System.out.println("Your " + this.getCoffee().getTitle() + " costs " + this.getCoffee().getPrice() + " dollars");
    }

}
