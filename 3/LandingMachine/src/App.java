import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

import MachineDomen.Automat;
import MachineDomen.Food;
import MachineDomen.HotBeverage;
import MachineDomen.HotBeverageAutomat;
import MachineDomen.Order;
import MachineDomen.Product;

public class App {
   public static void main(String[] args) throws IOException, InterruptedException {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли        
        
    /* 1.1 Абстракция
        Реализуйте класс Товар, содержащий данные о товаре,
        и ТорговыйАвтомат, содержащий в себе методы:
        initProducts (List <Product>) сохраняющий в себе список исходных продуктов          getProduct(String name) 

         Инкапсуляция
        Реализуйте конструкторы, get/set методы
        постройте логику ТорговогоАвтомата на основе кода сделанного в предыдущем задании.
          
        Наследование
        Сделайте класс Товар абстрактным, создайте нескольких наследников (к примеру: БутылкаВоды),
        сделайте интерфейсом ТорговыйАвтомат и реализуйте класс какого-то одного типа
        ТорговогоАвтомата (пример: ПродающийБутылкиВодыАвтомат)
          
        Полиморфизм
        Переопределите метод toString для Товара, запустите программу, после этого переопределите для
        наследника этот метод, после запуска обратите внимание на изменение поведения.
        Создайте:
        getProduct(String name) - перегруженный метод выдачи товара ТорговымАвтоматом, по имени, дополнив его дополнительным входным параметром
        getProduct(String name, int volume) - метод возвращающий товар по имени и какому-либо параметру товара */

    /* 1.2 Необходимо реализовать:
      
        Интерфейс ActorBehavoir
        который будет содержать описание возможных действий Actor-a в очереди/ магазине
          
        Абстрактный класс Actor
        который хранит в себе параметры Actor-a, включая состояние готовности сделать заказ и факт получения заказа.
         
        Дополнение:
        для большего понимания, можно сделать методы-геттеры для имени и прочих “персональных данных” abstract
         
        Класс Human
        который должен наследоваться от Actor и реализовывать ActorBehavoir */

    /* 2. Реализовать метод оформления заказ createOrder(...):
            -пройти по продуктам, проверить наличие (>0)
            -"запомнить цену"

        Создать объект Order с полями List<Product> 
            -содержит только продукты из наличия
            -поле стоимость (сумма цен продуктов, входящих в заказ)

        Вернуть объект Order.
        В классе Order переопределить метод toString(показывать состав заказа, заказчика и общую стоимость продуктов)
    
        *При заказе от человека учитывать желаемый объем или вес и, для напитков температуру, продуктов.
        + любые доработки по желанию - добавить комментарии к коду */

    /* 3. Добавить в классы продуктов и напитков возможность сравнивать их по некоторым критериям (можно сделать пользовательский интерфейс и спрашивать у пользователя по чему отсортировать (по весу, объему, температуре))
        — Добавить проверку в Order (validateOrder()) до оформления заказа: если заказано некоторого товара больше, чем есть в автомате, удалить этот товар из заказа (желательно в одну проходку).
        
        Формат сдачи: ссылка на гитхаб проект */

    Product p1 = new Food("Twix", 80, 11, new GregorianCalendar(2023,10, 10), 50.0);  // создаем экземпляры продуктов через конструктор
    Product p2 = new Food("Mars", 90, 23, new GregorianCalendar(2023,10, 10), 45.0);  
    Product p3 = new Food("Snikers", 70, 33, new GregorianCalendar(2023,10, 10), 55.5);    

    List<Product> myProductList = new ArrayList<>();  // список продуктов
    
    // ДОБАВИТЬ ПРОДУКТЫ В СПИСОК
    myProductList.add(p1);
    myProductList.add(p2);
    myProductList.add(p3);

    Automat a1 = new Automat();  // создаем экземпляр "автомат" через класс
    a1.initProduct(myProductList);  // заполнить автомат продуктами из списка

    String enquiry = "Twix";  // запрос продукта
    // System.out.println(a1.getProduct(enquiry).toString());

    HotBeverage Hb1 = new HotBeverage("espresso", 20, 10, new GregorianCalendar(2023,10, 10), 25.0, 45);
    HotBeverage Hb2 = new HotBeverage("americano", 15, 32, new GregorianCalendar(2023,10, 10), 40.0, 50);
    HotBeverage Hb3 = new HotBeverage("classic_coffee", 10, 22, new GregorianCalendar(2023,10, 10), 45.0, 50);

    List<HotBeverage> hotBeverageList = new ArrayList<>();  // список горячих напитков
    
    // ДОБАВИТЬ НАПИТКИ В СПИСОК
    hotBeverageList.add(Hb1);
    hotBeverageList.add(Hb2);
    hotBeverageList.add(Hb3);

    HotBeverageAutomat a2 = new HotBeverageAutomat();
    a2.initHotBeverage(hotBeverageList);

    String name = "americano";
    double volume = 40.0;
    int temperature = 50;
    // System.out.println(a2.getProduct(name, volume, temperature).toString());

    // Order myOrder = new Order();
    
   } 
}