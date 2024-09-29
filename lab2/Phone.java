package lab2;

public class Phone extends Gadget{
    private int batteryCapacity;
    private double screenDiagonal;
    private String color;

    public Phone() {
        super();
        this.batteryCapacity = 3000;
        this.screenDiagonal = 6.1;
        this.color = "black";
        System.out.println("Создан объект Phone");
    }


    public Phone(String brand, String model, double price, int batteryCapacity, double screenDiagonal, String color) {
        super(brand, model, price);
        this.batteryCapacity = batteryCapacity;
        this.screenDiagonal = screenDiagonal;
        this.color = color;
        System.out.println("Создан объект Phone: "+brand+" "+model);
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }
    public void setBatteryCapacity(int batCap) {
        this.batteryCapacity = batCap;
    }

    public double getScreenDiagonal() {
        return screenDiagonal;
    }
    public void setScreenDiagonal(double diagonal) {
        this.screenDiagonal = diagonal;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Смартфон: "+ getBrand() + " "+ getModel() + "\nЦена: $"+ getPrice() +
         "\nХарактеристики: Емкость батареи: " + batteryCapacity + "; Диагональ экрана: " + screenDiagonal+"; Цвет: " + color+ ";\n");
    }
    
    public void call(String number) {
        System.out.println("Вы позвонили на номер: " + number +",с помощью устройства "+ getBrand() + " " + getModel()+"\n");
    }
    public void sms(String number, String text) {
        System.out.println("Вы отправили сообщение ["+text+"] на номер: " + number +",с помощью устройства "+ getBrand() + " " + getModel()+"\n");
    }
}
