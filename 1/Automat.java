import java.util.ArrayList;
import java.util.List;

public class Automat {
    List<Product> productList = new ArrayList<>();

    /** МЕТОД, ИНИЦИАЛИЗАЦИИ СПИСКА ПРОДУКТОВ */
    public void initProduct(List<Product> productList){
        this.productList = productList;
    }

    /** МЕТОД ИЩЕТ И ВЫДАЕТ НУЖНЫЙ ПРОДУКТ */
    public Product getProduct(String name){
        for (Product prod : productList) {
            if (prod.getName().equals(name)) return prod;
        }
        return null;
    }
}
