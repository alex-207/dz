import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли
        /*  ДЗ 4
        a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;

        b. Класс Box, в который можно складывать фрукты.
        Коробки условно сортируются по типу фрукта.
        В одну коробку нельзя сложить и яблоки, и апельсины;

        c. Для хранения фруктов внутри коробки можно использовать ArrayList;

        d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
        вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

        e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
        подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
        Можно сравнивать коробки с яблоками и апельсинами;

        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;

        g. Не забываем про метод добавления фрукта в коробку. 
        */

        // СОЗДАТЬ ЯБЛОКИ
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        // System.out.println(apple1.getWeightFruct());

        // СОЗДАТЬ АПЕЛЬСИНЫ
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        // System.out.println(orange1.getWeightFruct());

        // СПИСКИ ФРУКТОВ ДЛЯ ДАЛЬНЕЙШЕГО ДОБАВЛЕНИЯ ФРУКТОВ В КОРОБКИ
        ArrayList<Apple> arrayFructs1 = new ArrayList();
        ArrayList<Orange> arrayFructs2 = new ArrayList();
        ArrayList arrayFructs3 = new ArrayList();  // пустой список

        // ЗАПОЛНЕНИЕ СПИСКА ДЛЯ ПЕРВОЙ КОРОБКИ
        arrayFructs1.add(apple1);
        arrayFructs1.add(apple1);
        arrayFructs1.add(apple1);
        arrayFructs1.add(apple1);
        arrayFructs1.add(apple2);
        arrayFructs1.add(apple3);
        // arrayFructs1.add(orange1);

        // ЗАПОЛНЕНИЕ СПИСКА ДЛЯ ВТОРОЙ КОРОБКИ
        arrayFructs2.add(orange1);
        arrayFructs2.add(orange2);
        arrayFructs2.add(orange3);
        arrayFructs2.add(orange4);
        // arrayFructs2.add(apple1);

        // ЗАПОЛНЕНИЕ ПЕРВОЙ КОРОБКИ
        Box box1 = new Box(arrayFructs1);
        System.out.println("Вес первой коробки: " + box1.getWeightBox(apple1));

        // ЗАПОЛНЕНИЕ ВТОРОЙ КОРОБКИ
        Box box2 = new Box(arrayFructs2);
        System.out.println("Вес второй коробки: " + box2.getWeightBox(orange1));

        // СРАВНЕНИЕ ВЕСА КОРОБОК
        // if(box1.compareTo(box2) == 1) System.out.println("true");
        // else System.out.println("false");

        System.out.println();
        Box box3 = new Box<>(arrayFructs3);  // пустая коробка

        System.out.println("Вес первой коробки до пересыпки: " + box1.getWeightBox(apple1));
        System.out.println("Вес третьей коробки до пересыпки: " + box3.getWeightBox(orange1));
        System.out.println();

        // ПЕРЕСЫПАТЬ ФРУКТЫ
        System.out.println("Вес третьей коробки после пересыпки: " + box1.execute(box3));
    }
}