import java.util.Random;

public abstract class Vacancy {

    private Random random = new Random();  // рандом для зп
    private String nameVacancy;
    private int salary;
    private VacancyType type;

    public Vacancy(String nameVacancy, int salary, VacancyType type) {
        this.nameVacancy = nameVacancy;
        this.salary = salary;
        this.type = type;
    }

    public String getNameVacancy() {
        return nameVacancy;
    }
    public int getSalary() {
        return random.nextInt(salary);
    }
    public VacancyType getType() {
        return type;
    }
}
