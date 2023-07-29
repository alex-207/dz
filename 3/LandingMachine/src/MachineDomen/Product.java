package MachineDomen;

import java.util.Calendar;

public abstract class Product {

    // protected - ДОСТУП ДЛЯ ДАННОГО И ДОЧЕРНИХ КЛАССОВ
    protected int price;
    protected String name;
    protected int quantity;  // количество
    protected Calendar bestBefore;  // годен до

    /**
     * конструктор
     * @param name  название продукта
     * @param price  цена продукта
     * @param quantity  количество
     * @param bestBefore  срок годности
     */
    public Product(String name, int price, int quantity, Calendar bestBefore) {  // принять значения из main
        
        // ИНИЦИАЛИЗАЦИЯ ПРИВАТНЫХ ПОЛЕЙ ДАННОГО КЛАССА ЧЕРЕЗ КОНСТРУКТОР
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.bestBefore = bestBefore;
    }

    /** МЕТОДЫ ВОЗВРАЩАЮТ ПРИВАТНЫЕ ПОЛЯ КЛАССА - СНИПЕД "get" */
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Calendar getBestBefore() {
        return bestBefore;
    }

    /** МЕТОДЫ ИНИЦИАЛИЗИРУЮТ ПРИВАТНЫЕ ПОЛЯ КЛАССА - СНИПЕД "set" */
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBestBefore(Calendar bestBefore) {
        this.bestBefore = bestBefore;
    }

    @Override
    public String toString() {  // полиморфизм - переделать стандартное поведение
        return "Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", bestBefore=" + bestBefore.get(Calendar.MONTH) + "." + bestBefore.get(Calendar.YEAR) + "]";
    }
}
