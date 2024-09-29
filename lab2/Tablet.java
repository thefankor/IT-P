package lab2;

public class Tablet extends Phone{


    public Tablet() {
        super();
        System.out.println("Создан объект Tablet");
    }


    public Tablet(String brand, String model, double price, int batteryCapacity, double screenDiagonal, String color) {
        super(brand, model, price, batteryCapacity, screenDiagonal, color);
        System.out.println("Создан объект Tablet: "+brand+" "+model);
    }

    
}
