import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class project5 {

    static void drawing(){
        System.out.println("1 - Показать все контакты");
        System.out.println("2 - Добавить контакт");
        System.out.println("3 - Удалить контак");
        System.out.println("4 - Выход");
    }

    /* Реализуйте структуру телефонной книги с помощью HashMap.
    Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
    Вывод должен быть отсортирован по убыванию числа телефонов. */
    static void phoneBook(){
        Map<String, LinkedList<String>> phoneNum = new HashMap<>();  // имя, список телефонов
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            drawing();  // отрисовать интерфейс
            System.out.print("Введите цифру 1..4: ");  
            int user_choise = sc.nextInt();  // считать цифру - что хочет сделать пользователь
            
            if (user_choise == 1) System.out.println(phoneNum);
            
            else if (user_choise == 2){
                System.out.println("Введите имя контакта и номер телефона в формате 89.. : ");
                String[] contacts = sc.nextLine().split(" ");  // !!!НЕ СЧИТЫВАЕТ, НЕ СПЛИТИТ, НЕ ЗАПИСЫВАЕТ СТРОКИ В МАССИВ - НЕ ЗНАЮ ПОЧЕМУ.. ПИШУ КОД ПО НАИТИЮ НЕ МОГУ ПРОВЕРИТЬ КАК РАБОТАЕТ, ПОТОМУ ЧТО НЕ СЧИТЫВАЕТ СКАННЕР..УЖЕ НЕРВОВ НЕТ
                for (String str : contacts) {  // заполнение словаря
                    if(phoneNum.containsKey(str)){ // если имя(ключ) уже находится в словаре
                        phoneNum.get(str).add(str); // получить повторяющуюся строку по ключу и добавить пару в словарь
                    }
                    else {  // если ключ (имя) еще не встречался
                        phoneNum.put(str, new LinkedList<>());  // добавить пару в словарь
                        phoneNum.get(str).add(str);  // получить новую строку по ключу и добавить ее в словарь
                    }
                }
            }

            else if (user_choise == 3){
                System.out.println("Введите имя контакта для удаления: ");
                String delContact = sc.nextLine();  // считать ключ
                if(phoneNum.containsKey(delContact)) phoneNum.remove(delContact);  // если введенный ключ находится в словаре - удалить пару по этому ключу
            }

            else if (user_choise == 4) flag = false;
        }
        sc.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли
        phoneBook();
    }
}