import java.util.List;

public class VendingMachine {

    private List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, double volume){
        for (Product product : products) {
            if (product instanceof BottleOfWater){
                BottleOfWater bottleOfWater = (BottleOfWater)product;
                if (bottleOfWater.getName().equals(name) && bottleOfWater.getVolume() == volume){
                    return bottleOfWater;
                }
            }
        }
        return null;
    }

    public Chocolate getChocolate(String name, int callories){
        for (Product product : products) {
            if (product instanceof Chocolate){  // если очередной продукт - шоколад
                Chocolate chocolate = (Chocolate)product;  // создать объект класса шоколад и преобразовать его в тип шоколад
                if (chocolate.getName().equals(name) && chocolate.getCallories() == callories){
                    return chocolate;
                }
            }
        }
        return null;
    }

    public Chocolate getChocolate(String name, int callories, int weight){
        for (Product product : products) {
            if (product instanceof Chocolate){  // если очередной продукт - шоколад
                Chocolate chocolate = (Chocolate)product;  // создать объект класса шоколад и преобразовать его в тип шоколад
                if (chocolate.getName().equals(name) && chocolate.getCallories() == callories && chocolate.getWeight() == weight){
                    return chocolate;
                }
            }
        }
        return null;
    }

    public Chocolate getChocolate(String brand){
        for (Product product : products) {
            if (product instanceof Chocolate){  // если очередной продукт - шоколад
                Chocolate chocolate = (Chocolate)product;  // создать объект класса шоколад и преобразовать его в тип шоколад
                if (chocolate.getBrand().equals(brand)){
                    return chocolate;
                }
            }
        }
        return null;
    }
}