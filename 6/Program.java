public class Program {

    /**
     * TODO: Переработать приложение в рамках принципа SRP
     * @param args
     */
    public static void main(String[] args) {

        // ЧЕРЕЗ КОНСТРУКТОР
        // SafeOrderTo safeOrderTo = new SafeOrderTo();  // сохранялка
        // Order createOrder = new Order("www", "qqq", 3, 12);  // создать заказ при объявлении
        // safeOrderTo.toJson(createOrder);  // сохранить в Json
        // // safeOrderTo.toTxt(order);  // сохранить в Txt

        // ЧЕРЕЗ СКАНЕР
        CreateOrder createOrder = new CreateOrder();  // ввод данных заказа + сохранялка
        createOrder.inputFromConsole();  // создать заказ через сканер
        createOrder.toTxt();  // сохранить в Txt
        // createOrder.toJson();  // сохранить в Json
    }

}
