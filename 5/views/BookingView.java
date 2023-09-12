package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

// КЛАСС ПРЕДСТАВЛЕНИЯ - ДЛЯ ВНЕШНЕГО ВЗАИМОДЕЙСТВИЯ С ПОЛЬЗОВАТЕЛЕМ 
public class BookingView implements View { 

    private ViewObserver observer;  // поле - наблюдатель, для доступа к методам наблюдателя, который и имплементил данный интерфейс (доступ к методам наблюдателя: onReservationTable()), первоначально равен null

    // МЕТОД - ОТОБРАЗИТЬ ВСЕ (АБСОЛЮТНО ВСЕ) СТОЛИКИ ИЗ БД
    public void showTables(Collection<Table> tables){  // принимает бд столиков
        
	    // ВЫВОД СОДЕРЖИМОГО БД
	    for (Table table: tables) {
            System.out.println(table);
        }
    }

    // МЕТОД - ВЫЗОВ МЕТОДА reservationTable(), ДЛЯ НОВОГО РЕЗЕРВА СТОЛИКА, ЧЕРЕЗ МЕТОД НАБЛЮДАТЕЛЯ observer.onReservationTable()
    public void reservationTable(Date orderDate, int tableNo, String name){  // принять от клиента дату резерва, id столика, имя
        observer.onReservationTable(orderDate, tableNo, name);  // вызов метода reservationTable() - резерв столика, через метод наблюдателя onReservationTable()
    }

    // ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДА - ПЕЧАТЬ РЕЗУЛЬТАТА РЕЗЕРВА СТОЛИКА
    @Override
    public void printReservationTableResult(int reservationNo) {  // принять id резерва
        if (reservationNo > 0) System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        else System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");
    }

    // СЕТЕР - ИНИЦИАЛИЗАЦИЯ НАБЛЮДАТЕЛЯ
    @Override
    public void setObserver(ViewObserver observer) { 
        this.observer = observer;
    }

    // ДЗ: ЗАМЕНА СТАРОГО РЕЗЕРВА СТОЛИКА НА НОВЫЙ, ЧЕРЕЗ БД "tables"
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){  // принять от клиента старый id резерва, новыю дату резерва, новый id столика, новое имя
        observer.onReReservationTable(oldReservation, reservationDate, tableNo, name);   
    }
}
