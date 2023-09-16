// СПЕЦИАЛИСТ - ИМПЛЕМЕНТИТ ИНТЕРФЕЙС ДЛЯ НАБЛЮДАТЕЛЯ
public class Master implements Observer {

    private String name;  // имя
    private int salary = 80000;  // зп
    private VacancyType type;

    // КОНСТРУКТОР
    public Master(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, Vacancy vacancy, VacancyType type) {  // метод - ознакомиться с вакансией
        if (this.salary <= vacancy.getSalary() && this.type == type.FullTime || this.type == type.PartTime || this.type == type.RemoteWork){
            System.out.printf("Мастер %s: Мне нужна эта работа! (компания: %s; вакансия: %s; тип занятости: %s; заработная плата: %d)\n",
            name, nameCompany, vacancy.getNameVacancy(), vacancy.getType(), vacancy.getSalary());
            this.salary = vacancy.getSalary();
            // this.type = vacancy.getType();
        } else {
            System.out.printf("Мастер %s: Я найду работу получше! (компания: %s; вакансия: %s; тип занятости: %s; заработная плата: %d)\n",
            name, nameCompany, vacancy.getNameVacancy(), vacancy.getType(), vacancy.getSalary());
        }
    }
}
