import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли

        // Product product1 = new Product();
        // product1.name = "Product1";
        // product1.brand = "Brand1";
        // product1.price = 200;
        // System.out.println(product1.displayInfo());

        // Product product2 = new Product(null, "Brand2", 300);
        // System.out.println(product2.displayInfo());
        // product2.setPrice(400);
        // double price = product2.getPrice();
        // System.out.println(price);
        // System.out.println(product2.displayInfo());

        // Product product3 = new Product("Product3");
        // product3.price = -100;
        // product3.name = "A";
        // System.out.println(product3.displayInfo());

        //=======================================================================
        // ДЗ 1
        // 1. Создать новый продукт на основе Product, создать ему хотя бы одно свойство (например, шоколад -> калории) и включить в список продуктов в вендинг машину.
        // 2. Продемонстрировать работу класса по продаже товаров (как мы это делали на семинаре).

        List<Product> products = new ArrayList<>();  // пустой список для всех продуктов

        // СОЗДАТЬ ПРОДУКТЫ
        Product bottleOfMilk = new BottleOfMilk("Молоко", "ООО Молоко", 350, 1.5, 15);
        Product bottleOfWater1 = new BottleOfWater("Вода", "ООО Источник", 350, 1);
        Product bottleOfWater2 = new BottleOfWater("Вода", "ООО Источник", 150, 1.5);
        Product bottleOfWater3 = new BottleOfWater("Вода", "ООО Источник", 250, 2);
        
        Product chocolate1 = new Chocolate("Шоколад", "Twix", 155, 105, 75);
        Product chocolate2 = new Chocolate("Шоколад", "Snikers", 160, 115, 65);
        Product chocolate3 = new Chocolate("Шоколад", "Mars", 155, 107, 75);
        Product chocolate4 = new Chocolate("Шоколад", "Baunty", 170, 110, 70);
        
        // ДОБАВИТЬ ПРОДУКТЫ В СПИСОК
        products.add(bottleOfMilk);
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);

        products.add(chocolate1);
        products.add(chocolate2);
        products.add(chocolate3);
        products.add(chocolate4);

        VendingMachine vendingMachine = new VendingMachine(products);  // заполнить автомат продуктами из списка
        
        // ЗАПРОСЫ ПРОДУКТОВ У АВТОМАТА:
        // ЗАПРОСЫ НАПИТКОВ
        // Product enquiryProduct = vendingMachine.getProduct("Вода", 1.5);   
        // Product enquiryProduct = vendingMachine.getProduct("Молоко", 1.5, 15);   
        
        // if (enquiryProduct != null){
        // System.out.println("Вы получили: ");
        //     System.out.println(enquiryProduct.displayInfo());
        // } else {
        // System.out.println("Такого напитка нет в автомате.");
        // }

        // ЗАПРОСЫ ШОКОЛАДА
        // Product enquiryProduct = vendingMachine.getProduct("Шоколад", 125);
        // Product enquiryProduct = vendingMachine.getProduct("Шоколад", 110, 70);
        Product enquiryProduct = vendingMachine.getProduct("Snikers");
        // Product enquiryProduct = vendingMachine.getProduct("Twix");
        // Product enquiryProduct = vendingMachine.getProduct("Mars");
        // Product enquiryProduct = vendingMachine.getProduct("Baunty"); 
        
        if (enquiryProduct != null){
            System.out.println("Вы получили:");
            System.out.println(enquiryProduct.displayInfo());
        } else {
            System.out.println("Такого шоколада нет в автомате.");
        }
    }
}