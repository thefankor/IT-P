package lab3;
import lab3.Order;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Order order1 = new Order(Arrays.asList("Pasta", "Salad"), 15.50, LocalDateTime.now());
        Order order2 = new Order(Arrays.asList("Pizza", "Soda"), 20.00, LocalDateTime.now());
        Order order3 = new Order(Arrays.asList("Burger", "Fries", "Cola"), 12.75, LocalDateTime.now());

        restaurant.addOrder(1, order1);
        restaurant.addOrder(2, order2);
        restaurant.addOrder(3, order3);

        int tableNumber = 2;
        Order foundOrder = restaurant.getOrder(tableNumber);
        System.out.println("Заказ для столика " + tableNumber + ": " + foundOrder);

        restaurant.removeOrder(1);
        System.out.println("Заказ для столика 1 удален.");

        System.out.println("Существует ли заказ для столика 3? " + restaurant.containsOrder(3));
        System.out.println("Существует ли заказ для столика 1? " + restaurant.containsOrder(1));

        System.out.println("Общее количество заказов: " + restaurant.getOrderCount());
        // System.out.println("=======\n\n\n");

        // HashTable<Integer, Order> customHashTable = new HashTable<>();

        // customHashTable.put(1, order1);
        // customHashTable.put(2, order2);
        // customHashTable.put(3, order3);

        // System.out.println("Заказ для столика 2: " + customHashTable.get(2));

        // customHashTable.remove(1);
        // System.out.println("Заказ для столика 1 удален.");
        // System.out.println("Существует ли заказ для столика 1? " + (customHashTable.get(1) != null));
        
        // System.out.println("Общее количество заказов: " + customHashTable.size());


        // // @SuppressWarnings("unchecked")
        // // public HashTable() {
        // //     table = (LinkedList<Entry<K, V>>[]) new LinkedList[DEFAULT_CAPACITY];
        // //     size = 0;
        // // }
    }
}

