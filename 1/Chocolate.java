public class Chocolate extends Product {
    private int callories;  // каллорийность
    private int weight;  // вес
    
    public Chocolate(String name, String brand, double price, int callories, int weight) {
        super(name, brand, price);
        this.callories = callories;
        this.weight = weight;
    }

    public double getCallories() {
        return callories;
    }

    public double getWeight() {
        return weight;
    }
    
    @Override
    public String displayInfo() {
        // return String.format("%s - %s - %.2f - callories: %d weight: %d", name, brand, price, callories, weight);
        return "name=" + name + ", brand=" + brand + ", price=" + price + ", callories=" + this.callories + ", weight=" + this.weight;
    }
    


}
