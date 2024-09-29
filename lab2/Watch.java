package lab2;
import java.time.LocalTime;

public class Watch extends Gadget{
    private String color;
    private String strap;
    private Boolean waterResistance;

    public Watch() {
        super();
        this.color = "silver";
        this.strap = "silicon";
        this.waterResistance = true;
        System.out.println("Создан объект Watch");
    }

    public Watch(String brand, String model, double price, String color, String strap, Boolean waterResistance) {
        super(brand, model, price);
        this.color = color;
        this.strap = strap;
        this.waterResistance = waterResistance;
        System.out.println("Создан объект Watch: "+brand+" "+model);
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getStrap() {
        return strap;
    }
    public void setStrap(String strap) {
        this.strap = strap;
    }

    public Boolean getWaterResisteance() {
        return waterResistance;
    }
    public void setWaterResisteance(boolean waterResistance) {
        this.waterResistance = waterResistance;
    }

    
    @Override
    public void displayInfo() {
        System.out.println("Часы: "+ getBrand() + " "+ getModel() + "\nЦена: $"+ getPrice() +
         "\nХарактеристики: Цвет: " +  color + "; Ремешок: " + strap+ "; Водонипроницаемость: " + (waterResistance ? "да":"нет")+ ";\n");
    }
    
    public void forwardTime(int hours) {
        if (hours != 0) {
            System.out.println("Время переведено на " + hours + " часов вперед.");
        } else {
            System.out.println("Время не переведено.");
        }
    }

    public void checkTime() {
        System.out.println("Время на часах - " + LocalTime.now());
    }
    
        
}
