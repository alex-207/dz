import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // для считывания данных с терминала

// 14. Написать программу, имитирующую работу реестра домашних животных
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String classAnimal = "";
        String name = "";
        String dateBirth = "";
        List<Animals> animals = new ArrayList<>();  // список всех животных
        ArrayList<String> commandsListString = new ArrayList<>();  // список комманд
        List<Integer> idListInt = new ArrayList<>();  // список id-шников

        // ЗАПОЛНИТЬ СПИСОК С ЖИВОТНЫМИ
        animals.add(new Cat(Counter.getCounter(), "Барсик", "Кот", "11.11ю1111"));
        animals.add(new Camel(Counter.getCounter(), "Морж", "Верблюд", "12112000"));
        animals.add(new Dog(Counter.getCounter(), "Чоп", "Собака", "12121212"));

        try {
            while (true) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                drawing();
                System.out.println("Выберите действие 1-5:");
                int choice = Integer.parseInt(sc.nextLine());
                
                // ДОБАВИТЬ ЖИВОТНОЕ В СПИСОК
                if (choice == 1) {
                    System.out.println("Как зовут животное?");
                    name = sc.nextLine();

                    System.out.println("Ведите дату рождения животного:");
                    dateBirth = sc.nextLine();

                    // 14.2 определять животное в правильный класс
                    boolean flagClass = true;
                    while (flagClass) {
                        System.out.println(
                                "К какому классу относится животное?\n 1 - кот\n 2 - собака\n 3 - хомячок\n 4 - лошадь\n 5 - верблюд\n 6 - осел");
                        String classStr = sc.nextLine();

                        if (classStr.equals("1")) {
                            classAnimal = "Кот";
                            animals.add(new Cat(Counter.getCounter(), name, classAnimal, dateBirth));
                            flagClass = false;
                        } else if (classStr.equals("2")) {
                            classAnimal = "Собака";
                            animals.add(new Dog(Counter.getCounter(), name, classAnimal, dateBirth));
                            flagClass = false;
                        } else if (classStr.equals("3")) {
                            classAnimal = "Хомячок";
                            animals.add(new Hamster(Counter.getCounter(), name, classAnimal, dateBirth));
                            flagClass = false;
                        } else if (classStr.equals("4")) {
                            classAnimal = "Лошадь";
                            animals.add(new Horse(Counter.getCounter(), name, classAnimal, dateBirth));
                            flagClass = false;
                        } else if (classStr.equals("5")) {
                            classAnimal = "Верблюд";
                            animals.add(new Camel(Counter.getCounter(), name, classAnimal, dateBirth));
                            flagClass = false;
                        } else if (classStr.equals("6")) {
                            classAnimal = "Осел";
                            animals.add(new Donkey(Counter.getCounter(), name, classAnimal, dateBirth));
                            flagClass = false;
                        } else
                            System.out.println("Некорректный класс животного!");
                    }

                } 
                
                // ПОКАЗАТЬ СПИСОК НАВЫКОВ ЖИВОТНОГО
                else if (choice == 2) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                    boolean flagListCommands = true;
                    for (Animals animal : animals)
                        idListInt.add(animal.getIdAnimal()); // составить список существующих id животных (int)
                    while (flagListCommands) {
                        System.out.println("Для просмотра списка комманд, введите id животного из списка:");
                        for (Animals animal : animals)
                            System.out.println(animal); // отрисовать список животных для выбора животного по id
                        String idAnimalString = sc.nextLine(); // считать id
                        if (idListInt.toString().contains(idAnimalString)) { // если введен корректный id
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли

                            for (Animals animal : animals) {
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Camel) { // найти нужное животное по id и список ее навыков не пустой
                                    Camel camel = (Camel) animal;
                                    if(!(camel.getCommads().isEmpty())) System.out.println(camel.getCommads());
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                else if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Cat) { // найти нужное животное по id и список ее навыков не пустой
                                    Cat cat = (Cat) animal;
                                    if(!(cat.getCommads().isEmpty())) System.out.println(cat.getCommads());
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                else if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Dog) { // найти нужное животное по id и список ее навыков не пустой
                                    Dog dog = (Dog) animal;
                                    if(!(dog.getCommads().isEmpty())) System.out.println(dog.getCommads());
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                else if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Donkey) { // найти нужное животное по id и список ее навыков не пустой
                                    Donkey donkey = (Donkey) animal;
                                    if(!(donkey.getCommads().isEmpty())) System.out.println(donkey.getCommads());
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                else if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Hamster) { // найти нужное животное по id и список ее навыков не пустой
                                    Hamster hamster = (Hamster) animal;
                                    if(!(hamster.getCommads().isEmpty())) System.out.println(hamster.getCommads());
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                else if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Horse) { // найти нужное животное по id и список ее навыков не пустой
                                    Horse horse = (Horse) animal;
                                    if(!(horse.getCommads().isEmpty())) System.out.println(horse.getCommads());
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                else {
                                    System.out.println( "Животное с id " + idAnimalString + " пока что не имеет никаких навыков!");
                                    flagListCommands = false;
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                    break;
                                }
                            }

                        } else {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                            System.out.println("Некорректный id животного!");
                        }
                    }
                } 
                
                // ДОБАВИТЬ НАВЫКИ ДЛЯ ЖИВОТНОГО
                else if (choice == 3) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                    for (Animals animal : animals) idListInt.add(animal.getIdAnimal()); // составить список существующих id животных (int)
                    String continueEnter;
                    boolean flagAddCommands = true;
                    while (flagAddCommands) {
                        System.out.println("Для добавления навыка/ ов, введите id животного из списка:");
                        for (Animals animal : animals)
                            System.out.println(animal); // отрисовать список животных для выбора животного по id
                        String idAnimalString = sc.nextLine(); // считать id
                        if (idListInt.toString().contains(idAnimalString)) { // если введен корректный id
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                            for (Animals animal : animals) {
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Camel) { // найти нужное животное по id
                                    Camel camel = (Camel) animal;
                                    boolean flagCommand = true;
                                    while (flagCommand) {
                                        System.out.println("Введите навык:");
                                        commandsListString.add(sc.nextLine());
                                        System.out.println("0 - завершить; 'любая клавиша' - продолжить");
                                        continueEnter = sc.nextLine();
                                        if (continueEnter.equals("0")) flagCommand = false;
                                        else continue;
                                    }
                                    camel.setCommads(commandsListString);
                                    System.out.println("Список навыков верблюда\n" + camel.getCommads());
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Cat) { // найти нужное животное по id
                                    Cat cat = (Cat) animal;
                                    boolean flagCommand = true;
                                    while (flagCommand) {
                                        System.out.println("Введите навык:");
                                        commandsListString.add(sc.nextLine());
                                        System.out.println("0 - завершить; 'любая клавиша' - продолжить");
                                        continueEnter = sc.nextLine();
                                        if (continueEnter.equals("0")) flagCommand = false;
                                        else continue;
                                    }
                                    cat.setCommads(commandsListString);
                                    System.out.println("Список навыков кота\n" + cat.getCommads());
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Dog) { // найти нужное животное по id
                                    Dog dog = (Dog) animal;
                                    boolean flagCommand = true;
                                    while (flagCommand) {
                                        System.out.println("Введите навык:");
                                        commandsListString.add(sc.nextLine());
                                        System.out.println("0 - завершить; 'любая клавиша' - продолжить");
                                        continueEnter = sc.nextLine();
                                        if (continueEnter.equals("0")) flagCommand = false;
                                        else continue;
                                    }
                                    dog.setCommads(commandsListString);
                                    System.out.println("Список навыков собаки\n" + dog.getCommads());
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Donkey) { // найти нужное животное по id
                                    Donkey donkey = (Donkey) animal;
                                    boolean flagCommand = true;
                                    while (flagCommand) {
                                        System.out.println("Введите навык:");
                                        commandsListString.add(sc.nextLine());
                                        System.out.println("0 - завершить; 'любая клавиша' - продолжить");
                                        continueEnter = sc.nextLine();
                                        if (continueEnter.equals("0")) flagCommand = false;
                                        else continue;
                                    }
                                    donkey.setCommads(commandsListString);
                                    System.out.println("Список навыков осла\n" + donkey.getCommads());
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Hamster) { // найти нужное животное по id
                                    Hamster hamster = (Hamster) animal;
                                    boolean flagCommand = true;
                                    while (flagCommand) {
                                        System.out.println("Введите навык:");
                                        commandsListString.add(sc.nextLine());
                                        System.out.println("0 - завершить; 'любая клавиша' - продолжить");
                                        continueEnter = sc.nextLine();
                                        if (continueEnter.equals("0")) flagCommand = false;
                                        else continue;
                                    }
                                    hamster.setCommads(commandsListString);
                                    System.out.println("Список навыков хомячка\n" + hamster.getCommads());
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                                if (animal.getIdAnimal() == Integer.parseInt(idAnimalString) && animal instanceof Horse) { // найти нужное животное по id
                                    Horse horse = (Horse) animal;
                                    boolean flagCommand = true;
                                    while (flagCommand) {
                                        System.out.println("Введите навык:");
                                        commandsListString.add(sc.nextLine());
                                        System.out.println("0 - завершить; 'любая клавиша' - продолжить");
                                        continueEnter = sc.nextLine();
                                        if (continueEnter.equals("0")) flagCommand = false;
                                        else continue;
                                    }
                                    horse.setCommads(commandsListString);
                                    System.out.println("Список навыков лошади\n" + horse.getCommads());
                                    System.out.printf("Нажмите любую клавишу:");
                                    sc.nextLine();
                                }
                            }
                            flagAddCommands = false;
                        } else {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                            System.out.println("Некорректный id животного!");
                        }
                    }
                } 
                
                // ПОКАЗАТЬ СПИСОК СО ВСЕМИ ЖИВОТНЫМИ
                else if (choice == 4) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // очистка консоли
                    if (animals.isEmpty()) {
                        System.out.println("На данный момент в питомнике нет животных!");
                        System.out.printf("Нажмите любую клавишу:");
                        sc.nextLine();
                    } else {
                        for (Animals animal : animals)
                            System.out.println(animal);
                        System.out.printf("Нажмите любую клавишу:");
                        sc.nextLine();
                    }
                } 
                
                // ВЫХОД
                else if (choice == 5) {
                    System.out.println("До свидания!");
                    sc.close();
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static Scanner sc = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));

    // 14.5 Реализовать навигацию по меню
    static void drawing() {
        System.out.println("1 - Завести новое животное"); // 14.1 Завести новое животное
        System.out.println("2 - Увидеть список команд, которое выполняет животное");
        System.out.println("3 - Обучить животное новым командам");
        System.out.println("4 - Показать список всех животных в питомнике");
        System.out.println("5 - Выход");
    }
}