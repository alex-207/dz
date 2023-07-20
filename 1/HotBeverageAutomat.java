import java.util.ArrayList;
import java.util.List;

public class HotBeverageAutomat extends Automat {

    List<HotBeverage> hotBeverageList = new ArrayList<>();

    /** МЕТОД, ИНИЦИАЛИЗАЦИИ СПИСКА ГОРЯЧИХ НАПИТКОВ */
    public void initHotBeverage(List<HotBeverage> hotBeverageList){
        this.hotBeverageList = hotBeverageList;
    }

    /** перегрузка getProduct */
    public HotBeverage getProduct(String name, double volume, int temperature){
        for (HotBeverage prod : hotBeverageList) {
            if (prod.getName().equals(name) && prod.getVolume() == volume && prod.getTemperature() == temperature) return prod;
        }
        return null;
    }
}
