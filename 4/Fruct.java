public abstract class Fruct {

    private final float weight;  // вес фрукта

    public Fruct(float weight) {  // конструктор инициализации веса фрукта
        this.weight = weight;
    }

    public float getWeightFruct() {  // гетер - получить вес фрукта
        return weight;
    }
}
