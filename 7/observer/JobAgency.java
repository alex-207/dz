import java.util.ArrayList;
import java.util.List;

// КАДРОВОЕ АГЕНСТВО - ИМПЛЕМЕНТИТ ИНТЕРФЕЙС ДЛЯ ОБЪЕКТА, ЗА КОТОРЫМ НАБЛЮДАЮТ
public class JobAgency implements Publisher {

    List<Observer> observers = new ArrayList<>();  // коллекция наблюдателей, для связи с наблюдателями (рассылки вакансий), через доступ к методам observer.receiveOffer (ознакомить наблюдателя с вакансией), 

    @Override
    public void sendOffer(String companyName, Vacancy vacancy, VacancyType type) {
        for (Observer observer : observers){
            observer.receiveOffer(companyName, vacancy, type);
        }
    }

    @Override
    public void registerObserver(Observer observer) {  // метод - добавить наблюдателя в коллекцию наблюдателей
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {  // метод - удалить наблюдателя из коллекции наблюдателей
        observers.remove(observer);
    }
}
