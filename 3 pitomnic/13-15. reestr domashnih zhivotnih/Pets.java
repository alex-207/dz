public class Pets extends Animals {
    protected String type;
    
    public Pets(int idAnimal, String name, String classAnimal, String birthDay) {
        super(idAnimal, name, classAnimal, birthDay);
        this.type = "Домашнее животное";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + String.format(", %s", this.type);
    }
}
