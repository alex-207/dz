import java.util.Calendar;

/** наследник Product */
public class Food extends Product implements Comparable<Food> {

    /** вес */
    private double weight;

    /**
     * конструктор
     * @param name  название продукта
     * @param price  цена продукта
     * @param quantity  количество
     * @param bestBefore  срок годности
     * @param weight  вес
     */
    public Food (String name, int price, int quantity, Calendar bestBefore, double weight) {  // принять значения из main
        super(name, price, quantity, bestBefore);  // инициализация приватных полей родительского конструктора
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {  // полиморфизм - переделать стандартное поведение
        return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", bestBefore=" + bestBefore.get(Calendar.MONTH) + "." + bestBefore.get(Calendar.YEAR) + ", weight=" + weight + "]";
    }

    @Override
    public int compareTo(Food o) {
        if (this.getWeight() == o.getWeight()) return 0;
        else if (this.getWeight() < o.getWeight()) return -1;
        else return 1;
    }
}

