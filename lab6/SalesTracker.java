package lab6;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.HashMap;
import java.util.Map;


public class SalesTracker {

    private CopyOnWriteArrayList<Sale> sales = new CopyOnWriteArrayList<>();

    public void addSale(String productName, double price) {
        sales.add(new Sale(productName, price));
    }

    public void displaySales() {
        System.out.println("Список проданных товаров:");
        for (Sale sale : sales) {
            System.out.println("Товар: " + sale.getProductName() + ", Цена: " + sale.getPrice());
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Sale sale : sales) {
            total += sale.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        Map<String, Integer> productCount = new HashMap<>();

        for (Sale sale : sales) {
            productCount.put(sale.getProductName(), productCount.getOrDefault(sale.getProductName(), 0) + 1);
        }

        String mostPopular = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }

        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSale("Телефон", 599.99);
        tracker.addSale("Ноутбук", 999.99);
        tracker.addSale("Телефон", 599.99);
        tracker.addSale("Наушники", 199.99);
        tracker.addSale("Телефон", 599.99);

        tracker.displaySales();

        System.out.println("Общая сумма продаж: " + tracker.getTotalSales());

        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularProduct());
    }
}
