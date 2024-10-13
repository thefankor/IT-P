package lab3;

import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private List<String> dishes;
    private double price;
    private LocalDateTime orderTime;

    public Order(List<String> dishes, double price, LocalDateTime orderTime) {
        this.dishes = dishes;
        this.price = price;
        this.orderTime = orderTime;
    }

    public List<String> getDishes() {
        return dishes;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dishes=" + dishes +
                ", pricet=" + price +
                ", orderTime=" + orderTime +
                '}';
    }
}
