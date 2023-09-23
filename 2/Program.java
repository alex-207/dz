import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли
        
        /* ДЗ 2. 
        1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
        Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

        2. Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

        3. Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

        4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя. */

        //=======================================================================

        // 1.
        System.out.println(first());

        // 2.
        // second();

        // 3.
        /* try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
        
        try{
        third(13, 234);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } 
        
        try{
            int[] abc = { 1, 2 };
            abc[1] = 1;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } */
    
        // 4.
        // fourth();
    }

    // 1.
    static float first(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Введите дробное число: ");
            Float div = sc.nextFloat();  // считать дробное число в переменную div
            sc.close();
            
            if(div instanceof Float) 
                return div;
            else
                // return 0;
                throw new Exception();
        }
        catch(Exception e){
            return first();
        }
    }

    // 2.
    static void second(){
        try {
            int d = 0;
            int[] intArray = { 23, 5, 45, 1, 345, -45, 23, 13, 43};
            double catchedRes1 = intArray[8] / 0;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    // 3.
    static void third(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

    // 4.
    static void fourth(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Введите что-нибудь: ");
            String div = sc.nextLine();  // считать дробное число в переменную div
            sc.close();
            
            if(div != "") 
                System.out.printf("Вы ввели: %s", div);
            else
                throw new IllegalArgumentException("Пустые строки вводить нельзя");
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
} 
