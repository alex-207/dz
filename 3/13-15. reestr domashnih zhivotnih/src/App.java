import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли
        
        // ЭКЗЕМПЛЯР КЛАССА
        Product product1 = new Product();  // Product() - конструктор без параметров (по умолчанию)
        product1.name = "Product1";
        product1.brand = "Brand1";
        product1.price = 200.00;

        System.out.println(product1.name);
    }
}
