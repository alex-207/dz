import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class project2 {

    // 1. Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
    static void BobleSort(int[] arr) throws SecurityException, IOException{  // 1
        Logger log = Logger.getLogger(project2.class.getName());  // логгер - имяПроекта.класс.чтоНужноСделать 
        FileHandler fh = new FileHandler("dz2_log.txt");  // открыть поток для записи логов в файл
        log.addHandler(fh);  // связать логгер и поток записи
        SimpleFormatter simple = new SimpleFormatter();  // протокол для записи логов
        fh.setFormatter(simple);  // формат записи логов - simple
        int iteration = 0;
        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }
        // System.out.println("\n");
        
        try {
            for (int j = 0; j < arr.length - 1; j++){
                for (int i = 0; i < arr.length - 1 - j; i++){  // -j (не проверять отсортированную часть)
                    log.info("iteration: " + ++iteration);  // запись в лог файл, после каждой итерации
                    if (arr[i] > arr[i + 1]){
                        int temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        } catch (Exception e) {
                System.out.println(e.getMessage());  // в случае неудачи - вывести информацию об ошибке
            }
        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }
    }

    // 2. Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
    // 1 Расширение файла: txt
    // 2 Расширение файла: pdf
    // 3 Расширение файла:
    // 4 Расширение файла: jpg
    static void typeFiles(String addressDir){  // 2
        File dir = new File(addressDir);  // записать в dir информацию о папке

        String[] listFiles = dir.list();  // сформировать список строк из названий файлов/ папок в текущей дирректории и записать его в массив
        String filesOneLine = "";
        // System.out.println(listFiles[0]);
        for (String str : listFiles) {
            // System.out.println(str);
            filesOneLine += str + " ";
        }

        System.out.println(filesOneLine);

        String[] types = filesOneLine.split(" ");
        for (String typeFile : types) {
            System.out.println("Расширение файла: " + typeFile);
            // !!!НЕ ЗНАЮ КАК РАССПЛИТИТЬ ДО ТОЧКИ...
        }
    }

    // 3. К калькулятору из предыдущего ДЗ добавить логирование.
    static void calc() throws SecurityException, IOException{
        Logger log = Logger.getLogger(project2.class.getName());  // логгер - имяПроекта.класс.чтоНужноСделать 
        FileHandler fh = new FileHandler("dz2_calc_log.txt");  // открыть поток для записи логов в файл
        log.addHandler(fh);  // связать логгер и поток записи
        SimpleFormatter simple = new SimpleFormatter();  // протокол для записи логов
        fh.setFormatter(simple);  // формат записи логов - simple
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Выбирите действие: ");
        System.out.println("1 - Сложение");
        System.out.println("2 - Вычитание");
        System.out.println("3 - Умножение");
        System.out.println("4 - Целочисленное деление");
        int n = sc.nextInt();
        try {
            if(n == 1 || n == 2 || n == 3 || n == 4){
            log.info("Введено корректное число: " + n);  // запись в лог файл
            System.out.println("Ведите первое число: ");
            int a = sc.nextInt();
            log.info("Введено корректное число: " + a);  // запись в лог файл
            System.out.println("Ведите второе число: ");
            int b = sc.nextInt();
            log.info("Введено корректное число: " + b);  // запись в лог файл
            sc.close();
            if (n == 1){
                System.out.printf("%d + %d = %d \n", a, b, a + b);
                log.info("Вычисления выполненны!");  // запись в лог файл
            }

            if (n == 2){
                System.out.printf("%d - %d = %d \n", a, b, a - b);
                log.info("Вычисления выполненны!");  // запись в лог файл
            }

            if (n == 3){
                System.out.printf("%d * %d = %d \n", a, b, a * b);
                log.info("Вычисления выполненны!");  // запись в лог файл
            }
            
            if (n == 4) {
                System.out.printf("%d / %d = %d \n", a, b, a / b);
                log.info("Вычисления выполненны!");  // запись в лог файл
            }
            }
        }   catch (Exception e) {
                System.out.println(e.getMessage());  // в случае неудачи - вывести информацию об ошибке
            }
    }

    public static void main(String[] args) throws SecurityException, IOException{  // есть возможность исключений
        int[] arr = new int[] { 3, 4, 2, 6, 8, 6 ,3 ,4 ,1 ,7 };
        BobleSort(arr);  // 1

        // String addressDir = System.getProperty("user.dir");  // получить адрес проекта
        // typeFiles(addressDir);  // 2

        // calc();  // 3
    }
}
