//  СТАЖЕР
public class Intern implements Observer{

    private String name;
    private int salary = 0;
    private VacancyType type;

    public Intern(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, Vacancy vacancy, VacancyType type) {  // метод - ознакомиться с вакансией
        if (this.salary <= vacancy.getSalary() && this.type != type.RemoteWork){
            System.out.printf("Стажер %s: Мне нужна эта работа! (компания: %s; вакансия: %s; тип занятости: %s; заработная плата: %d)\n",
            name, nameCompany, vacancy.getNameVacancy(), vacancy.getType(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
            // this.type = vacancy.getType();
        } else {
            System.out.printf("Стажер %s: Я найду работу получше! (компания: %s; вакансия: %s; тип занятости: %s; заработная плата: %d)\n",
            name, nameCompany, vacancy.getNameVacancy(), vacancy.getType(), vacancy.getSalary());
        }
    }
}
