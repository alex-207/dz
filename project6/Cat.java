import java.util.LinkedList;

public class Cat {
    String nameAnimal;
    String nameOwner;
    String contactsOwner;
    String breed; 
    String breedMom;
    String breedDad;
    boolean isWool;
    String woolColor;
    String eyeColor;
    int age;
    float lengthBody;
    float heightEars;
    float weight;
    char sex;
    LinkedList<String> awards = new LinkedList<>();
    LinkedList<String> padigreeBreed = new LinkedList<>();

    // ДОПУСК КОТА ДО ВЫСТАВКИ
    public boolean isAcepted() {
        if (breed != "Dvorovyi" && age >= 3 && age <= 7) {
            return true;
        }
        else return false;
    }

    // УДОБОЧИТАЕМЫЙ ФОРМАТ
    public String toString() {  
        String res = String.format("Animal name: %s\nName owner: %s\nContacts owner: %s\nBreed: %s\nBreed mom: %s\nBreed dad: %s\nIs there a wool: %b\nWool color: %s\nEye color: %s\nAge: %d years\nLength body: %f cm\nHeight ears: %f\nWeight: %f kg\nSex animal: %c\nIs acepted: %b\n", nameAnimal, nameOwner, contactsOwner, breed, breedMom, breedDad,isWool, woolColor, eyeColor, age, lengthBody, heightEars, weight, sex, isAcepted());
        return res;
    }
}
