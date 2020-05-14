package Model.command;

import Model.coffees.Coffee;

public class Waiter {
    private Order order;

    public Waiter(Order order) {
        this.order = order;
    }

    public Coffee getCoffee() {return this.order.getCoffee();}

    public void deliverOrder() {
        DeliverOrder deliverOrder = new DeliverOrder(this.order.getBarista(), this.order.getCoffee());
        deliverOrder.execute();
    }

    public void chargeCoffee() {
        ChargeCoffee chargeCoffee = new ChargeCoffee(this.order.getBarista(), this.order.getCoffee());
        chargeCoffee.execute();
    }
}