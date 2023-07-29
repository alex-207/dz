package MachineDomen;

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
            -"запомнить цену" */
    /**
     * метод - оформить заказ
     * @param listResult  итоговый список -> нужный продукт/ его наличие
     * @return  итоговый список -> нужный продукт/ его наличие
     */
    Order createdOrder(ArrayList<Product> listResult){
        List<Integer> pricesProducts = new ArrayList<>();  // пустой список цен продуктов
        for (Product product : listResult) {  // пройти по продуктам
            if (product.quantity > 0) pricesProducts.add(product.price);  // проверить наличие (>0) -> запомнить цену
        }
        
        // Order myOrder = new Order();
        // myOrder.listResult = this.;
        return null;
    }
}

