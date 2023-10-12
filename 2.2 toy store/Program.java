import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException, Exception {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли
    
        /* В программе должен быть
        1. Минимум один класс со следующими свойствами:
        -id игрушки,
        -текстовое название,
        -количество
        -частота выпадения игрушки (вес в % от 100)
 
        2. Метод добавление новых игрушек в обычный список, для последующего розыгрыша
        3. Возможность изменения веса (частоты выпадения игрушки)
        
        Розыгрыш игрушек:
        4. Метод выбора призовой игрушки.
        Мы разыгрываем игрушку, записываем ее в Queue для призовых игрушек, которые ожидают выдачи.
        5. Метод – выдачи призовой игрушки.
        После его вызова – мы удаляем из списка первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
        6. Не забываем уменьшить количество игрушек */

        // 1.
        Toy toy1 = new Toy(1, "constructor", 20);
        Toy toy2 = new Toy(2, "robot", 20);
        Toy toy3 = new Toy(3, "doll", 60);

        // 3. РЕГУЛИРОВАНИЕ ШАНСОВ ДЛЯ КАЖДОЙ ИГРУШКИ - В СОВОКУПНОСТИ ДОЛЖНО ДАВАТЬ ЦИФРУ 100
        toy1.setOdds(33);
        toy2.setOdds(33);
        toy3.setOdds(34);
        int complete = toy1.getCount() + toy2.getCount() + toy3.getCount();
        if(complete != 100) throw new Exception("Неправильно распределенны шансы");  // проверка корректности распределения шансов

        // 2. ДОБАВИТЬ 100 НОВЫХ ИГРУШЕК В СПИСОК, РАСПРЕДЕЛЕНИЕ - СОГЛАСНО ШАНСАМ
        List<Toy> toys = new ArrayList<>();
        for (int i = 0; i < toy1.getCount(); i++) toys.add(toy1);
        for (int i = 0; i < toy2.getCount(); i++) toys.add(toy2);
        for (int i = 0; i < toy3.getCount(); i++) toys.add(toy3);

        // ВЫВОД ДИАПАЗОНОВ ДЛЯ id КАЖДОЙ ИГРУШКИ
        System.out.println("id_1; constructor; диапазон:" + " 0.." + (toys.size() - (toy2.getOdds() + toy3.getOdds())));
        System.out.println("id_2; robot;       диапазон:" + " " + (toy1.getOdds() + 1) + ".." + (toys.size() - (toy3.getOdds())));
        System.out.println("id_3; doll;        диапазон:" + " " + (toys.size() - (toy3.getOdds()) + 1) + ".." + toys.size());

        Shop shop = new Shop(toys);  // отправить список в магазин, для последующего проведения розыгрыша
        
        int winId = 0;
        Toy winnerToy = new Toy(winId);
        Queue<String> strWinnerToy = new LinkedList<>();

        // ПЕРВЫЙ РОЗЫГРЫШ
        System.out.println();
        System.out.println("Размер списка до первого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("1-ый победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после первого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ВТОРОЙ РОЗЫГРЫШ
        System.out.println("Размер списка до второго розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("2-ой победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после второго розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ТРЕТИЙ РОЗЫГРЫШ
        System.out.println("Размер списка до третьего розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("3-ий победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после третьего розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ЧЕТВЕРТЫЙ РОЗЫГРЫШ
        System.out.println("Размер списка до четвертого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("4-ый победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после четвертого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ПЯТЫЙ РОЗЫГРЫШ
        System.out.println("Размер списка до пятого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("5-ый победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после пятого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ШЕСТОЙ РОЗЫГРЫШ
        System.out.println("Размер списка до шестого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("6-ой победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после шестого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // СЕДЬМОЙ РОЗЫГРЫШ
        System.out.println("Размер списка до седьмого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("7-ой победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после седьмого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ВОСЬМОЙ РОЗЫГРЫШ
        System.out.println("Размер списка до восьмого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("8-ой победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после восьмого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ДЕВЯТЫЙ РОЗЫГРЫШ
        System.out.println("Размер списка до девятого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("9-ый победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после девятого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ДЕСЯТЫЙ РОЗЫГРЫШ
        System.out.println("Размер списка до десятого розыгрыша=" + shop.getToys().size());
        winId = shop.RaffleToy();  // провести розыгрыш - узнать id выпавшей игрушки
        System.out.printf("10-ый победитель имеет id=%d -> ", winId);
        if(winId == toy1.getId()) winnerToy = toy1;
        if(winId == toy2.getId()) winnerToy = toy2;
        if(winId == toy3.getId()) winnerToy = toy3;
        winnerToy.getInfoToy();
        strWinnerToy.add(String.valueOf(winnerToy));  // добавить игрушку в список-очередь
        System.out.println("Размер списка после десятого розыгрыша=" + shop.getToys().size());
        System.out.println();

        // ВЫВОД СПИСКА ПРИЗОВЫХ ИГРУШЕК
        System.out.println("Список призовых игрушек, которые ожидают выдачи:");
        for (String toy : strWinnerToy) {
            System.out.println(toy.toString());
        }

        Iterator<String> iter = strWinnerToy.iterator();  // итератор для списка strWinnerToy
        System.out.println();
        System.out.println("Выдача игрушек побкдителям:");
        System.out.printf("Осталось раздать: %d игрушек", strWinnerToy.size());
        while(iter.hasNext()) shop.GetToy(strWinnerToy);  // пока не конец списка - производить выдачу игрушек победителям на руки
    }
}