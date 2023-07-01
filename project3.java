import java.util.ArrayList;  // список
import java.util.Iterator;  // итератор
import java.util.List;  // базовый список
import java.util.Random;  // рандом

public class project3 {

    static ArrayList<Integer> initArr(int n, int max){
        ArrayList<Integer> list = new ArrayList<>(n);  // инициализировать список
        Random rand = new Random();  // рандом
        for (int i = 0; i < n; i++) list.add(rand.nextInt(max));  // рандомная инициализация списка
        for (Integer integer : list) System.out.print(integer + " ");  // вывод списка
        System.out.println();  // переход на новую строку

        return list;
    }

    // 1.1. Удалить из списка чётные числа
    static void delEven(ArrayList<Integer> list){
        Iterator<Integer> iter = list.iterator();  // итератор для списка list                                   
        for (Integer num : list) {
            if(num % 2 == 0) iter.remove();  // !!! НЕ УДАЛЯЕТ ЭЛЕМЕНТ - НЕ ЗНАЮ ПОЧЕМУ
        }
        for (Integer num : list) System.out.print(num + " ");  // вывод списка
    }

    // 1.2. Найти минимальное значение
    static void min(ArrayList<Integer> list){
        int min = 100;
        for (Integer integer : list) {
            if(integer < min) min = integer;
        }
        System.out.println(min);
    }

    // 1.3. Найти максимальное значение
    static void max(ArrayList<Integer> list){
        int max = 0;
        for (Integer integer : list) {
            if(integer > max) max = integer;
        }
        System.out.println(max);
    }

    // 1.4. Найти среднее значение
    static void average(ArrayList<Integer> list){
        double res = 0;
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        res = sum / list.size();
        System.out.println(res);
        // System.out.println(sum);
    }
    
    // Заполнить список, размером n, названиями планет солнечной системы в произвольном порядке с повторениями
    // Вывести название каждой планеты и количество ее повторений в списке
    static void solarSystem(int n){  // 2
        List<String> planets = List.of("Меркурий", "Венера", "Земля", "Марс", "Юпитер", "Сатурн", "Уран", "Нептун");  // List.of() - сформировать список (планет) из имеющихся данных
        List<String> randPlanets = new ArrayList<String>(n);  // пустой список для заполнения планетами в случайном порядке
        int[] counts = new int[planets.size()];  // массив для количества повторений каждой планеты = размеру списка планет

        Random rand = new Random();

        for (int i = 0; i < n; i++) {  // заполнить список планет в случайном порядке
            randPlanets.add(planets.get(rand.nextInt(planets.size())));  // взять случайную планету из planets и записать ее в randPlanets по индексу от 0..размер planets
            System.out.print(randPlanets.get(i) + " ");  // вывести добавленную планету
            counts[planets.indexOf(randPlanets.get(i))]++;  // заполнить массив counts - indexOf(randPlanets.get(i)) - определить индекс текущей палнеты из списка planets и увеличить элемент в массиве counts для этой планеты на 1
        }
        System.out.println();
        // for (int i = 0; i < counts.length; i++) System.out.printf("%s - %s\n", planets.get(i), counts[i]);  // планета - количество повторений

        // Удалить все повторяющиеся элементы.
        Iterator<String> iter = randPlanets.iterator();  // итератор для списка
        for (int i = 0; i < randPlanets.size(); i++) {
            if(counts[i] > 1) {
                // iter.remove(randPlanets.get(i));  // !!! ПО СЧЕТЧИКУ ПЛАНЕТ ОПРЕДЕЛЯЮ ЕСТЬ ЛИ БОЛЕЕ ОДНОГО ВХОЖДЕНИЯ ДАННОЙ ПЛАНЕТЫ В РАНДОМНЫЙ СПИСОК, ЕСЛИ ЕСТЬ, ТО ПОЛУЧАЮ ЭТОТ ЭЛЕМЕНТ ПО ИНДЕКСУ i И УДАЛЯЮ ЕГО, ПОСЛЕ ЧЕГО УМЕНЬШАЮ КОЛИЧЕСТВО ВХОЖДЕНИЙ УДАЛЕННОЙ ПЛАНЕТЫ НА 1, НО ПОЧЕМУ-ТО НЕ УДАЛЯЕТ...
                counts[i]--;
            }
        }
    }

    public static void main(String[] args) {
        delEven(initArr(20, 100));  // 1.1
        // min(initArr(20, 100));  // 1.2
        // max(initArr(20, 100));  // 1.3
        // average(initArr(20, 100));  // 1.4

        // solarSystem(17);  // 2
    }
}