import java.util.ArrayList;

public class Camel extends PackAnimals {
    ArrayList<String> commads;

    public Camel(int idAnimal, String name, String classAnimal, String birthDay) {
        super(idAnimal, name, classAnimal, birthDay);
        //TODO Auto-generated constructor stub
    }

    public ArrayList<String> getCommads() {
        return commads;
    }

    public void setCommads(ArrayList<String> commads) {
        this.commads = commads;
    }
}
