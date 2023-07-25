/* Абстрактный класс Actor
хранит в себе параметры Actor-a, включая состояние готовности сделать заказ и факт получения заказа
сделать методы-геттеры для имени и прочих “персональных данных” abstract */

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


    /** гетер name */
    public String getName() {
        return name;
    }

    /** сетер name */
    public void setName(String name) {
        this.name = name;
    }
}

