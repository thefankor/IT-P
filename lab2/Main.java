package lab2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tablet p0 = new Tablet("Apple", "ipad 16", 900, 4000, 6, "black");
        p0.displayInfo();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Бренд телефона: ");
        String phone_brand = scanner.nextLine();

        System.out.print("Модель телефона: ");
        String phone_model = scanner.nextLine();

        System.out.print("Цена телефона: ");
        int phone_price = scanner.nextInt();

        System.out.print("Объем батареи телефона: ");
        int phone_battery = scanner.nextInt();

        System.out.print("Диагональ экрана телефона: ");
        int phone_diagonal = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Цвет телефона: ");
        String phone_color = scanner.nextLine();
        System.out.println("\n");

        Phone p1 = new Phone(phone_brand, phone_model, phone_price, phone_battery, phone_diagonal, phone_color);
        p1.displayInfo();

        System.out.print("Бренд ноутбука: ");
        String l_brand = scanner.nextLine();

        System.out.print("Модель ноутбука: ");
        String l_model = scanner.nextLine();

        System.out.print("Цена ноутбука: ");
        int l_price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Процессор: ");
        String l_cpu = scanner.nextLine();

        System.out.print("ОЗУ (Гб): ");
        int l_ram = scanner.nextInt();
        
        System.out.print("SSD (Гб): ");
        int l_ssd = scanner.nextInt();
        System.out.println("\n");

        Laptop l1 = new Laptop(l_brand, l_model, l_price, l_cpu, l_ram, l_ssd);
        l1.displayInfo();


        System.out.print("Бренд часов: ");
        String watch_brand = scanner.nextLine();

        System.out.print("Модель часов: ");
        String watch_model = scanner.nextLine();

        System.out.print("Цена часов: ");
        int watch_price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Цвет часов: ");
        String watch_color = scanner.nextLine();

        System.out.print("Тип ремешка: ");
        String watch_strap = scanner.nextLine();
        
        System.out.print("Есть ли водонипроницаемость (true/false): ");
        Boolean watch_water = scanner.nextBoolean();
        System.out.println("\n");

        Watch w1 = new Watch(watch_brand, watch_model, watch_price, watch_color, watch_strap, watch_water);
        w1.displayInfo();

        scanner.close();

        p1.call("88005553535");
        p1.sms("89002234555", "hello world!");

        l1.upgrade();
        l1.reinstallOS();

        w1.checkTime();
        w1.forwardTime(3);
        // Phone a = new Phone("Apple", "iphone 16", 900, 4000, 6, "black");
        // a.displayInfo();
        // a.call("897878787787");
        // a.sms("897878787787", "hello");

       
        // Laptop m = new Laptop("Apple", "MacBook Pro", 900, "M3", 16, 512);
        // Laptop m2 = new Laptop("Apple", "MacBook Air", 1000, "M2", 8, 256);
        // m.upgrade();
        // m2.displayInfo();
        // m.displayInfo();


        // Watch a = new Watch("Apple", "watch ultrta", 700, "black", "silicon", true);
        // a.displayInfo();
        // a.forwardTime(0);
        // a.forwardTime(10);
        // a.checkTime();

        System.out.println("Всего объектов создано: "+ Gadget.getCounter());        
    }
}



