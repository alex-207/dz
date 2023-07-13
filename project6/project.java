import java.io.IOException;

public class project {

    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли        
        /* Реализуйте класс Cat, включающий в себя от трех полей и от двух методов, определяющих базовый функционал класса
        (за основу можно взять наработки с семинара).
        Создать два экземпляра класса Cat и вывести информацию о них на экран. */
        Cat cat = new Cat();
        cat.nameAnimal = "Marsik";
        cat.nameOwner = "Kim";
        cat.contactsOwner = "+7464344334 Cheliabinskaya obl. Magnitogorsk city 455000";
        cat.breed = "Dvorovyi-Sphinks";
        cat.breedMom = "Dvorovyi";
        cat.breedDad = "Sphinks";
        cat.isWool = true;
        cat.woolColor = "Brown-Black";
        cat.eyeColor = "Gray";
        cat.age = 4;
        cat.lengthBody = 45.5f;
        cat.heightEars = 5.3f;
        cat.weight = 8.2f;
        cat.sex = 11;
        cat.awards.add("Самое быстрое прохождение полосы препятствий - апрель 2020г");
        cat.awards.add("Самое быстрое поедание васкаса - июль 2020");
        cat.awards.add("Самое громкое мурлыкание август - 2021 г");
        cat.padigreeBreed.add("I -> Mom: Dvorovyi + Dad: Dvorovyi");
        cat.padigreeBreed.add("II -> Mom: Dvorovyi + Dad: Dvorovyi");
        cat.padigreeBreed.add("III -> Mom: Syam + Dad: Dvorovyi");
        cat.padigreeBreed.add("IX -> Mom: Dvorovyi + Dad: Sphinks");
        System.out.println(cat);
        System.out.println("Award:");
        for (String string : cat.awards) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("Padigree:");
        for (String string : cat.padigreeBreed) {
            System.out.println(string);
        }
        System.out.println();
        // !!! ПРОГРАММА ПОЧЕМУ-ТО ЗАПУСКАЕТСЯ ТОЛЬКО ЧЕРЕЗ СТРЕЛОЧКУ, ЧЕРЕЗ ТЕРМИНАЛ "java project.java" - НЕ ЗАПУСКАЕТСЯ И НА ЛЕКЦИИ ТОЖЕ ТОЛЬКО ЧЕРЕЗ СТРЕЛОЧКУ РАБОТАЛО.. СТРАННО
    }
}