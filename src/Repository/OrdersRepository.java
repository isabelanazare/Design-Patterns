package Repository;

import Model.command.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersRepository {
    private List<Order> orders;

    public OrdersRepository(){
        this.orders = new ArrayList<>();
    }
    public void addOrder(Order o){
        this.orders.add(o);
    }
    public List<Order> getOrders(){ return this.orders;}
}
