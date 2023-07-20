import java.util.Calendar;

/** наследник Product */
public class Beverage extends Product {
    
    protected double volume;

    /**
     * конструктор
     * @param name  название продукта
     * @param price  цена продукта
     * @param quantity  количество
     * @param bestBefore  срок годности
     * @param volume  объем
     */
    public Beverage (String name, int price, int quantity, Calendar bestBefore, double volume) {  // принять значения из main
        super(name, price, quantity, bestBefore);  // инициализация приватных полей родительского конструктора
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {  // полиморфизм - переделать стандартное поведение
        return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", bestBefore=" + bestBefore.get(Calendar.MONTH) + "." + bestBefore.get(Calendar.YEAR) + ", volume=" + volume + "]";
    }
}
