package presenters;

import models.Table;

import java.util.Collection;

// ИНТЕРФЕЙС ДЛЯ ПРЕДСТАВЛЕНИЯ 
public interface View {
    
    void showTables(Collection<Table> tables);  // метод - отобразить все (абсолютно все) столики из бд

    void setObserver(ViewObserver observer);  // сетер - инициализация наблюдателя

    void printReservationTableResult(int reservationNo);  // метод - печать результата резерва столика
}
