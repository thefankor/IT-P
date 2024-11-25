package lab6;

class Sale {
    private final String name;
    private final double price;

    public Sale(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getProductName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}