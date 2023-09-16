// ИНТЕРФЕЙС ДЛЯ ОБЪЕКТА, ЗА КОТОРЫМ НАБЛЮДАЮТ
public interface Publisher {

    void sendOffer(String companyName, Vacancy vacancy, VacancyType type);  // метод - разместить вакансию
    void registerObserver(Observer observer);  // метод - добавить наблюдателя в коллекцию наблюдателей
    void removeObserver(Observer observer);  // метод - удалить наблюдателя из коллекции наблюдателей
}
