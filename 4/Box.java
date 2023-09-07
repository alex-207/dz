import java.util.ArrayList;

/**
 * Т - тип фрукта
 * Box<T> (обобщение) - коробка, для фрукта того типа, который приняли
 * Box<T extends Fruct> (ограничение обобщения) - коробка, только для фрукта того типа, который приняли + у этого фрукта должны быть описаны методы из абстрактного класса Fruct -> конструктор инициализации веса
 */
public class Box<T extends Fruct> /* implements Comparable<Box> */{

    private ArrayList<T> fructs;  // коллекция фруктов
    private T fruct;  // фрукт принятого типа

    public Box(ArrayList fructs) {
        this.fructs = fructs;
    }

    /** количество фруктов в коробке */
    public int getCountFructs(){
        return fructs.size();
    }

    /** общий вес коробки */
    public float getWeightBox(T fruct){
        return this.getCountFructs() * fruct.getWeightFruct();
    }

    /** сравнение веса коробок */
    // @Override
    // public int compareTo(Box o) {
    //     if(this.getWeightBox() == o.getWeightBox()) return 1;
    //     else return 0;
    // }

    /** добавление фрукта в коробку */
    public void addFruct(T fruct){
        fructs.add(fruct);
    }

    /** пересыпка */
    public float execute(Box<T> box){
        float remains = this.getCountFructs() - this.getCountFructs();
        System.out.println("Вес первой корбки после пересыпки: " + remains);
        float res = box.getCountFructs() + this.getCountFructs();
        return res;
    }
}
