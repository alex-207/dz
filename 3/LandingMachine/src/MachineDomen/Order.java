package MachineDomen;

import java.util.Calendar;
import java.util.List;

/** заказ */
public class Order {
    private List<Product> listResult;  // итоговый список -> нужный продукт/ его наличие в автомате
    private Human client;  // клиент

    
    @Override  //(показывать состав заказа, заказчика и общую стоимость продуктов)
    public String toString() {  // полиморфизм - переделать стандартное поведение
        return "Order [" + listResult + ", client=" + client + ", price=" + Product.price + "]";
    }
}

