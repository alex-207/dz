import java.util.ConcurrentModificationException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли

        /* Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
        Фамилия
        Имя
        Отчество
        датарождения
        номертелефона
        пол

        Форматы данных:
        фамилия, имя, отчество - строки
        датарождения - строка формата dd.mm.yyyy
        номертелефона - целое беззнаковое число без форматирования
        пол - символ латиницей f или m.

        Приложение должно проверить введенные данные по количеству. 
        Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

        Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
        Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
        Можно использовать встроенные типы java и создать свои.
        Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

        Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида:

        <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

        Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

        Не забудьте закрыть соединение с файлом.

        При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки. */

        int resultFio = inputFio();
        try {  // true - дозаписывать данные через writer
            if (resultFio == -1) throw new Exception("Недопустимые символы, при вводе ФИО");
            else if (resultFio == -2) throw new Exception("Вы ввели лишние данные, при вводе ФИО");
            else if (resultFio == -3) throw new Exception("Вы ввели не все данные, при вводе ФИО");
            else if(resultFio == -4) throw new Exception("Некорректный ввод даты рождения");
            else if(resultFio == -5) throw new Exception("Некорректный ввод телефона");
            else if(resultFio == -6) throw new Exception("Слишком много цифр в номере телефона");
            else if(resultFio == -7) throw new Exception("Слошком мало цифр в номере телефона");
            else if(resultFio == -8) throw new Exception("Некорректный ввод пола");
            else{
                try (FileWriter writer = new FileWriter(fileName, true)) {
                    String result = String.valueOf(sb);
                    writer.write(result);
                    writer.append("\n");
                    throw new Exception();
                } catch (Exception e) {
                    e.getStackTrace();
                } finally{
                    System.out.println("Успешное завершение работы с файлом");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);
    static String fileName = "";

    static int inputFio(){
        int amountData = 3;
        System.out.println("Введите фамилию имя и отчество, на латинице, через пробел: ");
        String dataInput = sc.nextLine(); 
        String[] strings = dataInput.split(" ");

        // ПРОВЕРКА ДАННЫХ ПО ТИПУ
        for (int i = 0; i < strings.length; i++) {
            String[] symbols = strings[i].split("");
            for (String symbol : symbols) {
                // System.out.println(symbol);
                if(symbol.equalsIgnoreCase("a") || symbol.equalsIgnoreCase("b") || symbol.equalsIgnoreCase("c") || symbol.equalsIgnoreCase("d") || symbol.equalsIgnoreCase("e") || symbol.equalsIgnoreCase("f") || symbol.equalsIgnoreCase("g") || symbol.equalsIgnoreCase("h") || symbol.equalsIgnoreCase("i") || symbol.equalsIgnoreCase("j") || symbol.equalsIgnoreCase("k") || symbol.equalsIgnoreCase("l") || symbol.equalsIgnoreCase("m") || symbol.equalsIgnoreCase("n") || symbol.equalsIgnoreCase("o") || symbol.equalsIgnoreCase("p") || symbol.equalsIgnoreCase("q") || symbol.equalsIgnoreCase("r") || symbol.equalsIgnoreCase("s") || symbol.equalsIgnoreCase("t") || symbol.equalsIgnoreCase("u") || symbol.equalsIgnoreCase("v") || symbol.equalsIgnoreCase("w") || symbol.equalsIgnoreCase("x") || symbol.equalsIgnoreCase("y") || symbol.equalsIgnoreCase("z")) continue;
                else return -1;  // некорректные символы
            }
        }

        // ПРОВЕРКА ДАННЫХ ПО КОЛИЧЕСТВУ
        if(strings.length > amountData) return -2;  // лишние данные
        else if(strings.length < amountData) return -3;  // не все данные
        
        fileName = strings[0];  // название файла = фамилии

        // СОБРАТЬ СТРОКУ
        for (String string : strings) {
            sb.append("<" + string + ">");
        }
        System.out.println(sb);

        return inputDateBirth();
    }

    static int inputDateBirth(){
        int amountData = 3;
        System.out.println("Введите дату рождения, в формате dd.mm.yyyy: ");
        String dataInput = sc.nextLine();
        String[] strings = dataInput.split("\\.");  // рассплитить до "."

        // ПРОВЕРКА ДАННЫХ ПО ТИПУ
        for (int i = 0; i < strings.length; i++) {
            String[] symbols = strings[i].split("");
            for (String symbol : symbols) {
                if(symbol.equals("0") || symbol.equals("1") || symbol.equals("2") || symbol.equals("3") || symbol.equals("4") || symbol.equals("5") || symbol.equals("6") || symbol.equals("7") || symbol.equals("8") || symbol.equals("9")) continue;
                else return -4;
            }
        }
        // ПРОВЕРКА ДАННЫХ ПО КОЛИЧЕСТВУ
        if(strings.length != amountData) return -4;  // лишние данные
        
        // СОБРАТЬ СТРОКУ
        sb.append("<");
        for (int i = 0; i < strings.length; i++) {
            if(i == strings.length - 1) sb.append(strings[i] + "");
            else sb.append(strings[i] + ".");
        }
        sb.append(">");
        sb.append(" ");
        System.out.println(sb);
        return inputPhone();
    }

    static int inputPhone(){
        long num = 0;
        try {
            System.out.println("Введите номер телефона 6-9 знаков: ");  // странное условие про номер телефона "номертелефона - целое беззнаковое число без форматирования" в java же вроде нет unsigned int, поэтому использую long с максимальным значением 999_999_999, если больше - то выдаст ошибку...
            num = sc.nextLong();
        } catch (Exception e) {
            return -5;
        } finally{
            if (num > 999999999) return -6;  // слишком много цифр
            if (num < 100000) return -7;  // слишком мало цифр
        }

        // СОБРАТЬ СТРОКУ
        String phone = String.valueOf(num);  // long -> String
        sb.append("<");
        sb.append(phone);
        sb.append(">");
        System.out.println(sb);

        return inputGender();
    }

    static int inputGender(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваш пол \'m\' или \'f\': ");
        String gen = sc.nextLine();
        sc.close();
        if(gen.equalsIgnoreCase("m") || gen.equalsIgnoreCase("f")) {
            
            // СОБРАТЬ СТРОКУ
            sb.append("<");
            sb.append(gen);
            sb.append(">");
            return 0;
        }
        else return -8;
    }
}