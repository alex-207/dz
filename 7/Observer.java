// ИНТЕРФЕЙС НАБЛЮДАТЕЛЯ - ЕГО ИМПЛЕМЕНТЯТ НАБЛЮДАТЕЛИ
public interface Observer {

    void receiveOffer(String nameCompany, Vacancy vacancy, VacancyType type);  // метод - ознакомиться с вакансией

}
