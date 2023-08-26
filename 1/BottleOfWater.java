public class BottleOfWater extends Product {

    private double volume; // Объем

    public BottleOfWater(String name, String brand, double price, double volume){
        super(name, brand, price);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String displayInfo() {
        // return String.format("[Бутылка с водой] %s - %s - %.2f - v: %.2f", name, brand, price, volume);
        return super.displayInfo() + ", volume=" + this.volume;
    }
}