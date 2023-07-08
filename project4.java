import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// Даны два Deque, представляющие два целых числа.
// Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
public class project4 {

    // 1) Умножьте два числа и верните произведение в виде связанного списка.
    private static void ex1() {
        Deque<Integer> dq = new LinkedList<>();
        Scanner sc = new Scanner(System.in);  // инициализация сканнера
        int num = 0;
        for (int i = 0; i < 2; i++) {
            System.out.printf("Введите два целых числа -9..9, одно или оба числа должны быть отрицательными: ");
            num = sc.nextInt();
            dq.addFirst(num);
        }
        sc.close();
        if (dq.getFirst() < 0 || dq.getLast() < 0  && dq.getFirst() >= -9 && dq.getFirst() <= 9 && dq.getLast() >= -9 && dq.getLast() <= 9) {
            dq.addFirst((dq.pollFirst() * dq.pollFirst()));  // премножить элементы и записать результат в список
            System.out.println(dq);
        }
        else System.out.println("Введены некорректные числа!");
    }

    // 2) Сложите два числа и верните сумму в виде связанного списка. 
    private static void ex2() {
        Deque<Integer> dq = new LinkedList<>();
        Scanner sc = new Scanner(System.in);  // инициализация сканнера
        int num = 0;
        for (int i = 0; i < 2; i++) {
            System.out.printf("Введите два целых числа -9..9, одно или оба числа должны быть отрицательными: ");
            num = sc.nextInt();
            dq.addFirst(num);
        }
        sc.close();
        if (dq.getFirst() < 0 || dq.getLast() < 0  && dq.getFirst() >= -9 && dq.getFirst() <= 9 && dq.getLast() >= -9 && dq.getLast() <= 9) {
            dq.addFirst((dq.pollFirst() + dq.pollFirst()));  // сложить элементы и записать результат в список
            System.out.println(dq);
        }
        else System.out.println("Введены некорректные числа!");
    }

    // !!! БУДЕТ ЧУДО ЕСЛИ Я ПРАВИЛЬНО ПОНЯЛ ЗАДАНИЕ, А ИМЕННО:
    // ДАНЫ ДВА ЦЕЛЫХ ЧИСЛА В ДВУХСТОРОННЕЙ ОЧЕРЕДИ, К ЧИСЛАМ ЕСТЬ КРИТЕРИИ (ОБА ЧИСЛА СОСТОЯТ ИЗ ОДНОЙ ЦИФРЫ И ОДНО ИЛИ ОБА ЧИСЛА ДОЛЖНЫ БЫТЬ ОТРИЦАТЕЛЬНЫМИ) - ПРОВЕРЯЕТСЯ СЛОЖНЫМ УСЛОВИЕМ
    // И НУЖНО ИХ УДАЛИТЬ ПРИ ПЕРЕМНОЖЕНИИ/ СЛОЖЕНИИ - ПЕРЕПИСАВ РЕЗУЛЬТАТ В СПИСОК НАШЕЙ ОЧЕРЕДИ
    // !!! ВОЛНУЮСЬ ЧТО НЕ ТАК ПОНЯЛ ЗАДАНИЕ - НА СЕМИНАРЕ БЫЛО МАЛОВАТО ИНФОРМАЦИИ О ТЗ ДЛЯ ДЗ..
    
public static void main(String[] args) {
        ex1();  // 1
        // ex2();  // 2
    }
}