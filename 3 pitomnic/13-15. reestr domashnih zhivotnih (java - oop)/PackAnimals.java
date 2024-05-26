public class PackAnimals extends Animals {
    protected String type;

    public PackAnimals(int idAnimal, String name, String classAnimal, String birthDay) {
        super(idAnimal, name, classAnimal, birthDay);
        this.type = "Вьючное животное";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + String.format(", %s", this.type);
    }
}
