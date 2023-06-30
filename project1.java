import java.util.Scanner;  // для считывания данных с терминала

public class project1 {

    static void trinity(){
        // 1.1) Вычислить n-ое треугольного число (сумма чисел от 1 до n)
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите высоту пирамиды: ");
        int n = sc.nextInt();
        sc.close();
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        
        System.out.println(res);
    }

    static void fac(){
        // 1.2) Вычислить n! (произведение чисел от 1 до n)
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число для нахождения факториала: ");
        int n = sc.nextInt();
        sc.close();
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        
        System.out.println(res);
    }

    static void printSimple(){
        // 2) Вывести все простые числа от 1 до 1000
       
        boolean flag = true;
        System.out.printf("2 ");
        for (int i = 3; i <= 1000; i += 2) {  // только нечетные 3..1000
            for (int j = 3; j < i; j += 2) {  // делители 
                if(i % j == 0) flag = false;
            }
            if(flag == true) System.out.printf(i + " ");
            else flag = true;
        }
    }

    static void calc(){
        // 3) Реализовать простой калькулятор
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Выбирите действие: ");
        System.out.println("1 - Сложение");
        System.out.println("2 - Вычитание");
        System.out.println("3 - Умножение");
        System.out.println("4 - Целочисленное деление");
        int n = sc.nextInt();
        if(n == 1 || n == 2 || n == 3 || n == 4){
            System.out.println("Ведите первое число: ");
            int a = sc.nextInt();
            System.out.println("Ведите второе число: ");
            int b = sc.nextInt();
            sc.close();
            if (n == 1) System.out.printf("%d + %d = %d \n", a, b, a + b);
            if (n == 2) System.out.printf("%d - %d = %d \n", a, b, a - b);
            if (n == 3) System.out.printf("%d * %d = %d \n", a, b, a * b);
            if (n == 4) System.out.printf("%d / %d = %d \n", a, b, a / b);
        }
        else System.out.println("Некорректный ввод!");
    }

    static void restore(){
        // 4) Задано уравнение вида q + w = e
        // q, w, e >= 0.
        // Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
        // Требуется восстановить выражение до верного равенства.
        // Предложить хотя бы одно решение или сообщить, что его нет.
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите уравнение для восстановления: ");
        String n = sc.nextLine();
        String[] str = n.split(" ");
        for (int i = 0; i < str.length - 1; i++) {  // все строки, кроме результата
            // if(str[i].length() >= 2) char[] symbol = str[i].split(" ");
            // !!! ХОЧУ РАССПЛИТИТЬ ВСЕ СТРОКИ СОСТОЯЩИЕ ИЗ ДВУХ И БОЛЕЕ СИМВОЛОВ (КРОМЕ АРИФМЕТИЧЕСКИХ ЗНАКОВ И РЕЗУЛЬТАТА), НА СИМВОЛЫ char, ДЛЯ ДАЛЬНЕЙШЕГО ВЫЯВЛЕНИЯ ЗНАКОВ ?-СА И ПРЕОБРАЗОВАНИЯ ОСТАВШИХСЯ ЗНАКОВ-ЦИФР В ЦИФРЫ int, НО НЕ МОГУ РАССПЛИТИТЬ В char - ВЫДАЕТ ОШИБКУ.
        }
    }

    public static void main(String[] args){
        trinity();  // 1.1
        // fac();  // 1.2
        // printSimple();  // 2
        // calc();  // 3
        // restore();  // 4
    }
}