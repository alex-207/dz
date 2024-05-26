// 15.Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆ значение внутренней̆int переменной̆на 1 при нажатие “Завести новое животное”
public class Counter {
    
    private static int counter = 0;

    public static void add(){
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
