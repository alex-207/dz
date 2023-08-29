import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли
        
        /* ДЗ 2
        1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
        
        2. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
        Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).

        3. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.

        4. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку. */

        Cat cat1 = new Cat("Barsik", 5, false);
        Cat cat2 = new Cat("Irsik", 7, false);
        Cat cat3 = new Cat("Pushistik", 8, false);

        Plate plate = new Plate(13);
        plate.info();

        Cat[] cats = new Cat[3];
        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = cat3;

        for (Cat cat : cats) {
            System.out.println();
            if (plate.getFood() >= cat.getAppetite()) {  // если остаток еды >= аппетиту очередного кота
                cat.eat();   // кот кушает
                plate.setFood(plate.getFood() - cat.getAppetite());  // высчитывается остаток
                System.out.println("Остаток еды: " + plate.getFood());
            }
            else System.out.println("кот " + cat.getName() + " наелся:" + cat.getSatiety());
        }
        
        System.out.println();
        System.out.println("Осталось еды, после кормления котов: " + plate.getFood());
        plate.addFood(111);  // добавить еду в тарелку
        System.out.println("Стало еды, после добавления: " + plate.getFood());
    }
}