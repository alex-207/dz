public class Plate {
    private int food;
    
    public Plate(int food) {
        if (food > 0) this.food = food;
        else System.out.println("Насыпьте больше еды!");
    }

    /** метод добавления еды */
    public void addFood(int food){
        if (food > 0) {
            System.out.println("Добавили " + food + " еды");
            this.food += food;
        }
        else System.out.println("Насыпьте больше еды!");
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}