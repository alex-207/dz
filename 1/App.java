import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        //product3.price = -100;
        //product3.name = "A";
        // System.out.println(product3.displayInfo());

        // Product bottleOfMilk1 = new BottleOfMilk("Бутылка1", "ООО Молоко", 350, 1.5, 15);
        // System.out.println(bottleOfMilk1.displayInfo());

        Product bottleOfWater1 = new BottleOfWater("Бутылка c водой", "ООО Источник", 350, 1);
        // System.out.println(bottleOfWater1.displayInfo());

        Product bottleOfWater2 = new BottleOfWater("Бутылка c водой", "ООО Источник", 150, 1.5);

        Product bottleOfWater3 = new BottleOfWater("Бутылка c водой", "ООО Источник", 250, 2);

        List<Product> products = new ArrayList<>();
        // products.add(bottleOfMilk1);
        products.add(bottleOfWater1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);

        VendingMachine vendingMachine = new VendingMachine(products);
        
        // BottleOfWater bottleOfWater = vendingMachine.getBottleOfWater("Бутылка c водой", 1.5);
        
        // if (bottleOfWater != null){
        // System.out.println("Вы получили: ");
        //     System.out.println(bottleOfWater.displayInfo());
        // } else {
        // System.out.println("Такой бутылки с водой нет в автомате.");
        // }


        //=======================================================================
        // ДЗ 1
        // 1. Создать новый продукт на основе Product, создать ему хотя бы одно свойство (например, шоколад -> калории) и включить в список продуктов в вендинг машину.
        // 2. Продемонстрировать работу класса по продаже товаров (как мы это делали на семинаре).

        Product chocolate1 = new Chocolate("Шоколад", "Twix", 155, 105, 75);
        Product chocolate2 = new Chocolate("Шоколад", "Snikers", 160, 115, 65);
        Product chocolate3 = new Chocolate("Шоколад", "Mars", 155, 107, 75);
        Product chocolate4 = new Chocolate("Шоколад", "Baunty", 170, 110, 70);
        products.add(chocolate1);
        products.add(chocolate2);
        products.add(chocolate3);
        products.add(chocolate4);

        // Chocolate enquiryChocolate = vendingMachine.getChocolate("Шоколад", 125);
        // Chocolate enquiryChocolate = vendingMachine.getChocolate("Шоколад", 110, 70);
        // Chocolate enquiryChocolate = vendingMachine.getChocolate("Snikers");
        // Chocolate enquiryChocolate = vendingMachine.getChocolate("Twix");
        // Chocolate enquiryChocolate = vendingMachine.getChocolate("Mars");
        Chocolate enquiryChocolate = vendingMachine.getChocolate("Baunty");

        if (enquiryChocolate != null){
            System.out.println("Вы получили:");
            System.out.println(enquiryChocolate.displayInfo());
        } else {
            System.out.println("Такого шоколада нет в автомате.");
        }
    }
}