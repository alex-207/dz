package MachineDomen;

/* Абстрактный класс Actor
хранит в себе параметры Actor-a, включая состояние готовности сделать заказ и факт получения заказа
сделать геттеры для имени и прочих “персональных данных” abstract */

/** абстрактное действующее лицо */
public abstract class Actor implements ActorBehavoir {

    /** имя */
    private String name;

    /** состояние готовности сделать заказ */
    private boolean isMakeOrder;

    /** факт получения заказа */
    private boolean isTakeOrder;


    /**
     * конструктор
     * @param name  имя
     * @param isMakeOrder  состояние готовности сделать заказ
     * @param isTakeOrder  факт получения заказа
     */
    public Actor (String name, boolean isMakeOrder, boolean isTakeOrder){
        this.name = name;
        this.isMakeOrder = isMakeOrder;
        this.isMakeOrder = isTakeOrder;
    }


    public String getName() {
        return name;
    }

    public boolean isMakeOrder() {
        return isMakeOrder;
    }

    public boolean isTakeOrder() {
        return isTakeOrder;
    }

}


