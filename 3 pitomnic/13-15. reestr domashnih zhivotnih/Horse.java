import java.util.ArrayList;

public class Horse extends PackAnimals{
    ArrayList<String> commads;

    public ArrayList<String> getCommads() {
        return commads;
    }

    public void setCommads(ArrayList<String> commads) {
        this.commads = commads;
    }

    public Horse(int idAnimal, String name, String classAnimal, String birthDay) {
        super(idAnimal, name, classAnimal, birthDay);
    }
    
}
