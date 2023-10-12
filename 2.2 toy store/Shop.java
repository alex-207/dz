import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;  // рандом

public class Shop {
    private Random rand = new Random();  // рандом
    List<Toy> toys = new ArrayList<>();  // пустой список для розыгрыша игрушек 

    // 2. ЗАПОЛНЕНИЕ СПИСКА, ЧЕРЕЗ КОНСТРУКТОР - ДЛЯ ПРОВЕДЕНИЯ РОЗЫГРЫША ИГРУШЕК
    public Shop(List<Toy> toys) {
        this.toys = toys;
    }
    
    // 4. РОЗЫГРЫШ ИГРУШКИ
    public int RaffleToy(){
        int win = rand.nextInt(1,101);

        // ПРОВЕРКА ЧТОБЫ ПРИ ОЧЕРЕДНЫХ УДАЛЕНИЯХ НЕ ВЫЙТИ ЗА ПРЕДЕЛЫ СПИСКА
        if (win < toys.size()) toys.remove(win + 1);  // удалить выпавшую игрушку из списка
        else RaffleToy();
        
        System.out.println("Побеждает игрушка, в чей диапазон входит число: " + win);
        for (int i = 0; i < toys.size(); i++) {
            if (win == i + 1)
            return toys.get(i).getId();
        }
        return 0;         
    }

    // 5. ВЫДАЧА ПРИЗОВ ПО СПИСКУ, СОГЛАСНО ОЧЕРЕДИ
    public void GetToy(Queue<String> strWinnerToy){
        System.out.println();
        try (FileWriter fw = new FileWriter("listWin.json", true)){
            fw.append(strWinnerToy.poll() + " - выдана на руки");  // удаляем из списка первую игрушку и сдвигаем массив, а эту игрушку записываем в текстовый файл
            fw.append("\n");
            if (strWinnerToy.size() != 0) System.out.printf("Осталось раздать: %d игрушек", strWinnerToy.size());
            else {
                System.out.printf("Осталось раздать: %d игрушек\n", strWinnerToy.size());
                System.out.printf("Размер списка: %d\n", strWinnerToy.size());
                System.out.println("Все игрушки выданы на руки");
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Toy> getToys() {
        return toys;
    }
}
