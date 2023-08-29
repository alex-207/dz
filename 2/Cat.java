public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat() {
        this.satiety = true;
        System.out.println("кот " + this.name + " наелся:" + this.satiety);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getSatiety() {
        return satiety;
    }
}