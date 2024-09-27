package lab2;

public abstract class Gadget{
    private String brand;
    private String model;
    private double price;

    private static int counter = 0; 

    // Конструктор по умолчанию
    public Gadget() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.price = 0.0;
        counter++;
    }

    // Конструктор с параметрами
    public Gadget(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        counter++;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getCounter() {
        return counter;
    }

    // Абстрактный метод для вывода информации о гаджете
    public abstract void displayInfo();

}
