// КОМПАНИЯ
public class Company {

    private String nameCompany;  // название
    private Publisher jobAgency;  // связь с агенством, через интерфейс (чтобы напрямую не быть связанным с конкретным агенством), для доступа к методу jobAgency.sendOffer() (размещения вакансии) 
    private VacancyType type;  // связь c вакансией

    // КОНСТРУКТОР
    public Company(String nameCompany, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.jobAgency = jobAgency;
    }

    // РАЗМЕСТИТЬ ВАКАНСИЮ
    public void needEmployee(Vacancy vacancy){
        jobAgency.sendOffer(nameCompany, vacancy, type);
    }
}
