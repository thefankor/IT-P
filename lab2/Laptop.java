package lab2;

public class Laptop extends Gadget{
    private String cpu;
    private int ram;
    private int ssd;


    public Laptop() {
        super();
        this.cpu = "M3";
        this.ram = 8;
        this.ssd = 256;
        System.out.println("Создан объект Laptop: "+brand+" "+model);
    }

    public Laptop(String brand, String model, double price, String cpu, int ram, int ssd) {
        super(brand, model, price);
        this.cpu = cpu;
        this.ram = ram;
        this.ssd = ssd;
        System.out.println("Создан объект Laptop: "+brand+" "+model);
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    @Override
    public void displayInfo() {
        System.out.println("Ноутбук: "+ getBrand() + " "+ getModel() + "\nЦена: $"+ getPrice() +
         "\nХарактеристики: Процессор: " + cpu + "; ОЗУ: " + ram + "; SSD: " + ssd+ ";\n");
    }

    public void upgrade() {
        this.ram = ram*2;
        System.out.println("Вы увеличили количество ОЗУ до " + ram + "GB.\n");
        // this.displayInfo();
    }
    public void reinstallOS() {
        this.ram = ram*2;
        System.out.println("Вы переустановили ОС\n");
        // this.displayInfo();
    }
}

