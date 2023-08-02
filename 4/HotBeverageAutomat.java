import java.util.ArrayList;
import java.util.List;

public class HotBeverageAutomat extends Automat implements ProductAdded<HotBeverage>{

    List<HotBeverage> hotBeverageList = new ArrayList<>();

    /** МЕТОД, ИНИЦИАЛИЗАЦИИ СПИСКА ГОРЯЧИХ НАПИТКОВ */
    public void initHotBeverage(List<HotBeverage> hotBeverageList){
        this.hotBeverageList = hotBeverageList;
    }

    /** перегрузка getProduct */
    public Product getProduct(String name, double volume, int temperature){
        for (HotBeverage prod : hotBeverageList) {
            if (prod.getName().equals(name) && prod.getVolume() == volume && prod.getTemperature() == temperature) return prod;
        }
        return null;
    }

    @Override
    public void addProduct<HotBeverage>(Automat a, Product p) {
        a.addProduct<HotBeverage>(a, p);
    }
}

