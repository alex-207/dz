package MachineDomen;

import java.util.List;

/* Интерфейс ActorBehavoir
содержит описание возможных действий Actor-a в очереди/ магазине */
public interface ActorBehavoir {
    boolean isMakeOrder();  // состояние готовности сделать заказ
    void setMakeOrder(boolean ready);  // сделать заказ
    boolean isTakeOrder();  // факт получения заказа
    void setTakeOrder(boolean took);  // забрать заказ
    Order makeOrder(List<String> listShoping);  // создать итоговый список
}

