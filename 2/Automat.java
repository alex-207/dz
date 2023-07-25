import java.util.ArrayList;
import java.util.List;

public class Automat {

    /** пустой список наличия */
    List<Product> listProducts = new ArrayList<>();

    /**
     * метод - инициализация списка наличия
     * @param listProducts  список наличия
     */
    public void initProduct(List<Product> listProducts){
        this.listProducts = listProducts;
    }

    /**
     * метод выдачи нужного продукта
     * @param name  нужный продукт
     * @param listProducts  список наличия
     * @return  нужный продукт или null
     */
    public Product getProduct(String name){
        for (Product prod : listProducts) {
            if (prod.getName().equals(name)) return prod;
        }
        return null;
    }


    /* Реализовать метод оформления заказ createOrder(...):
    -пройти по продуктам, проверить наличие (>0)
    -"запомнить цену"

    Создать объект Order с полями List<Product>  !!! ГДЕ СОЗДАТЬ ???
    -содержит только продукты из наличия
    -поле стоимость (сумма цен продуктов, входящих в заказ)

    Вернуть объект Order.
    В классе Order переопределить метод toString(показывать состав заказа, заказчика и общую стоимость продуктов)
    
    *При заказе от человека учитывать желаемый объем или вес и, для напитков температуру, продуктов.
    + любые доработки по желанию - добавить комментарии к коду */

    /**
     * метод - оформить заказ
     * @param listResult  итоговый список -> нужный продукт/ его наличие
     * @return  итоговый список -> нужный продукт/ его наличие
     */
    Order createdOrder(ArrayList<Product> listResult){
        List<Integer> pricesProducts = new ArrayList<>();  // список цен продуктов

        for (Product product : listResult) {  // пройти по продуктам
            if (product.quantity > 0) pricesProducts.add(product.price);  // проверить наличие (>0) -> запомнить цену
        }

        // КОРОЧЕ ЭТО ВСЕ ЧТО СМОГ... УЖЕ ГОЛОВА ДЫМИТСЯ - НЕ ПОНЯТНО ГДЕ ЕГО СОЗДАТЬ ОЧЕНЬ МНОГО ВСЕГО, МНОГО РАЗНЫХ ФАЙЛОВ, МНЕ ПОСЛЕ ДВУХ СЕМИНАРОВ ТЯЖЕЛО В НИХ ОРИЕНТИРОВАТЬСЯ
        Order myOrder = new Order();
        myOrder.listResult = this.;
        return null;
    }
}
