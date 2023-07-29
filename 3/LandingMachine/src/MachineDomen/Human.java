package MachineDomen;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/* Класс Human
должен наследоваться от Actor и реализовывать ActorBehavoir */

/** клиент */
public class Human extends Actor {
    
    /** количество денег */
    private double money;

    /** подойти к конкретному автомату */
    private Automat thisAutomat;

    /**
     * конструктор
     * @param name  имя Humen
     * @param isMakeOrder  состояние готовности сделать заказ
     * @param isTakeOrder  факт получения заказа
     * @param money  количество денег у Humen
     */
    public Human(String name, boolean isMakeOrder, boolean isTakeOrder, double money) {
        super(name, isMakeOrder, isTakeOrder);
        this.money = money;
    }

    /**
     * реализация объявленного метода makeOrder, из интерфейса ActorBehavoir - формирование итогового списка нужный продукт/ его наличие и отправка его в создание заказа
     * @param listShoping  список нужных продуктов
     * @param listResult  итоговый список -> нужный продукт/ его наличие
     * @param CurrentProductFromAutomat  текущий продукт из автомата
     * @return  итоговый список -> нужный продукт/ его наличие
    */
    @Override
    public Order makeOrder(List<String> listShoping) {  // принять список нужных продуктов
        ArrayList<Product> listResult = new ArrayList<>();  // пустой итоговый список
        Product CurrentProductFromAutomat;  // объявить продукт из списка нужных продуктов
        for (String product : listShoping) {  // пройти по списку нужных продуктов
            CurrentProductFromAutomat = thisAutomat.getProduct(product);  // инициализировать продукт из списка нужных продуктов
            if (CurrentProductFromAutomat != null) {  // если нужный продукт есть в автомате
                listResult.add(CurrentProductFromAutomat);  // добавить нужный продукт в итоговый список
            }
        }
        setMakeOrder(true);  // сделать заказ (готовность сделать заказ = true)
        return thisAutomat.createdOrder(listResult);
    }

    /** метод поиска автомата */
    void findThisAutomat(){
        List<Product> listProducts = new ArrayList<>();  // ссписок всех продуктов
        
        // ЗАПОЛНИТЬ СПИСОК ПРОДУКТОВ ДЛЯ АВТОМАТА
        listProducts.add(new Food("Twix", 80, 11, new GregorianCalendar(2023,10, 10), 50.0)); 
        listProducts.add(new Food("Mars", 90, 23, new GregorianCalendar(2023,10, 10), 45.0));
        listProducts.add(new Food("Snikers", 70, 33, new GregorianCalendar(2023,10, 10), 55.5));
        listProducts.add(new HotBeverage("espresso", 20, 10, new GregorianCalendar(2023,10, 10), 25.0, 45));
        listProducts.add(new HotBeverage("americano", 15, 32, new GregorianCalendar(2023,10, 10), 40.0, 50));
        listProducts.add(new HotBeverage("classic_coffee", 10, 22, new GregorianCalendar(2023,10, 10), 45.0, 50));

        // ЗАПОЛНИТЬ КОНКРЕТНЫЙ АВТОМАТ ИЗ СПИСКА
        Automat automat = new Automat();  // пустой автомат
        automat.initProduct(listProducts);
        this.thisAutomat = automat;
    }


    /** гетер money */
    public double getMoney() {
        return money;
    }

    /** сетер money */
    public void setMoney(double money) {
        this.money = money;
    }

    /** переопределение гетера из интерфейса ActorBehavoir - флажек - состояние готовности сделать заказ */
    @Override
    public boolean isMakeOrder() {
        return false;
    }

    /** переопределение сетера из интерфейса ActorBehavoir - метод - сделать заказ */
    @Override
    public void setMakeOrder(boolean ready) {
        
    }

    /** переопределение гетера из интерфейса ActorBehavoir - флажек - факт получения заказа */
    @Override
    public boolean isTakeOrder() {
        return false;
    }

    /** переопределение сетера из интерфейса ActorBehavoir - метод - забрать заказ */
    @Override
    public void setTakeOrder(boolean took) {
        
    }
}

