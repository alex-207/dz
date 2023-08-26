import java.util.List;

public class VendingMachine {

    private List<Product> products;

    /** ЗАПОЛНЕНИЕ АВТОМАТА ПРОДУКТАМИ ИЗ СПИСКА */
    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    /** ПОИСК БУТЫЛКИ ВОДЫ */
    public BottleOfWater getProduct(String name, double volume){
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

    /** ПЕРЕГРУЗКА - ПОИСК БУТЫЛКИ МОЛОКА */
    public BottleOfMilk getProduct(String name, double volume, int fat){
        for (Product product : products) {
            if (product instanceof BottleOfMilk){
                BottleOfMilk bottleOfMilk = (BottleOfMilk)product;
                if (bottleOfMilk.getName().equals(name) && bottleOfMilk.getVolume() == volume && bottleOfMilk.getFat() == fat){
                    return bottleOfMilk;
                }
            }
        }
        return null;
    }

    /** ПЕРЕГРУЗКА - ПОИСК ШОКОЛАДА */
    public Chocolate getProduct(String name, int callories){
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

    /** ПЕРЕГРУЗКА - ПОИСК ШОКОЛАДА */
    public Chocolate getProduct(String name, int callories, int weight){
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

    /** ПЕРЕГРУЗКА - ПОИСК ШОКОЛАДА */
    public Chocolate getProduct(String brand){
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