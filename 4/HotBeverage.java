import java.util.Calendar;

public class HotBeverage extends Beverage {
    
    private int temperature;

    /**
     * конструктор
     * @param name  название
     * @param price  цена
     * @param quantity количество
     * @param bestBefore  срок годности
     * @param volume  объем
     * @param temperature  температура
     */
    public HotBeverage(String name, int price, int quantity, Calendar bestBefore, double volume, int temperature) {
        super(name, price, quantity, bestBefore, volume);  // инициализация приватных полей родительского конструктора
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {  // полиморфизм - переделать стандартное поведение
        return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", bestBefore=" + bestBefore.get(Calendar.MONTH) + "." + bestBefore.get(Calendar.YEAR) + ", volume=" + volume + ", temperature=" + temperature + "]";
    }

    @Override
    public int compareTo(Beverage o) {
        if (this.getTemperature() == ((HotBeverage) o).getTemperature()) return 0;
        else if (this.getTemperature() < ((HotBeverage) o).getTemperature()) return -1;
        else return 1;
    }
}

