package lab3;

import java.util.HashMap;
import lab3.Order;


public class Restaurant {
    private HashMap<Integer, Order> orders;

    public Restaurant() {
        orders = new HashMap<>();
    }

    public void addOrder(int tableNumber, Order order) {
        orders.put(tableNumber, order);
    }

    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public void removeOrder(int tableNumber) {
        orders.remove(tableNumber);
    }

    public boolean containsOrder(int tableNumber) {
        return orders.containsKey(tableNumber);
    }

    public int getOrderCount() {
        return orders.size();
    }


}
