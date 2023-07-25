import java.util.List;

/* Интерфейс ActorBehavoir
содержит описание возможных действий Actor-a в очереди/магазине */
public interface ActorBehavoir {

    /** гетер - флажек - состояние готовности сделать заказ */
    boolean isMakeOrder();

    /**
     * сетер - метод - сделать заказ
     * @param ready  состояние готовности сделать заказ
     */
    void setMakeOrder(boolean ready);

    /** гетер - флажек - факт получения заказа */
    boolean isTakeOrder(); 

    /**
     * сетер - метод - забрать заказ
     * @param took факт получения заказа
     */
    void setTakeOrder(boolean took);
    

    /**
     * метод - создать итоговый список -> нужный продукт/ его наличие
     * @param listShoping  список нужных продуктов
     * @return  итоговый список
     */
    Order makeOrder(List<String> listShoping);
}
