package presenters;

import models.Table;
import models.TableModel;
import views.BookingView;

import java.util.Collection;
import java.util.Date;

// КЛАСС НАБЛЮДАТЕЛЯ - ДЛЯ СВЯЗИ Model И View, ИМПЛЕМЕНТИТ ИНТЕРФЕЙС НАБЛЮДАТЕЛЯ
public class BookingPresenter implements ViewObserver { 

    private final Model tableModel;  // поле - модель, для доступа к методам модели, через интерфейс Model (доступ к методам модели: loadTablesList(), reservationTable())

    private final View bookingView;  // поле - представление, для доступа к методам представления, через интерфейс View (доступ к методам представления: showTables(), printReservationTableResult()) 

    // КОНСТРУКТОР - ИНИЦИАЛИЗАЦИЯ НАБЛЮДАТЕЛЯ ДЛЯ ДАЛЬНЕЙШЕЙ СВЯЗИ Model И View
    public BookingPresenter(Model tableModel, View bookingView) {  // принимает модель и представление, для их инициализации
        this.tableModel = tableModel;  // инициализация модели
        this.bookingView = bookingView;  // инициализация представления
        bookingView.setObserver(this);  // инициализации наблюдателя, через представление (предатет сам себя)
    }

    // МЕТОД - ВЫЗОВ МЕТОДА loadTablesList(), ДЛЯ ЗАПОЛНЕНИЯ БД СТОЛИКАМИ, ЧЕРЕЗ МОДЕЛЬ
    public Collection<Table> loadTables(){
        return tableModel.loadTablesList();  // возвращает - вызов заполнения бд столиками
    }
    
    // МЕТОД - ВЫЗОВ МЕТОДА showTables(), ДЛЯ ОТОБРАЖЕНИЯ ВСЕХ (АБСОЛЮТНО ВСЕХ) СТОЛИКОВ ИЗ БД, ЧЕРЕЗ ПРЕДСТАВЛЕНИЕ 
    public void updateTablesUI(){
        bookingView.showTables(loadTables());
    }

    // МЕТОД - ВЫЗОВ МЕТОДА printReservationTableResult(), ДЛЯ ПЕЧАТИ РЕЗУЛЬТАТА РЕЗЕРВА СТОЛИКА, ЧЕРЕЗ ПРЕДСТАВЛЕНИЕ
    public void updateReservationResultUI(int reservationId){  // принимает id резерва 
        bookingView.printReservationTableResult(reservationId);  // печать результата резерва (передает id резерва)
    }

    // ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДА - ВЫЗОВ МЕТОДА reservationTable(), ДЛЯ ПОПЫТКИ РЕЗЕРВА СТОЛИКА, ЧЕРЕЗ МОДЕЛЬ  И ВЫВОД РЕЗУЛЬТАТА РЕЗЕРВА
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {  // принять от клиента дату резерва, id столика, имя
        int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);  // сделать попытку резерва и получить id резерва
        updateReservationResultUI(reservationNo);  // печать результата резерва столика, через представление
    }

    // ДЗ: ПЕРЕОПРЕДЕЛЕНИЕ МЕТОДА - ВЫЗОВ МЕТОДА changeReservationTable(), ДЛЯ НОВОЙ ПОПЫТКИ РЕЗЕРВА СТОЛИКА, ЧЕРЕЗ МОДЕЛЬ  И ВЫВОД РЕЗУЛЬТАТА РЕЗЕРВА
    @Override
    public void onReReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {  // принять от клиента дату резерва, id столика, имя
        int reReservationNo = tableModel.changeReservationTable(oldReservation, reservationDate, tableNo, name);  // сделать попытку нового резерва и получить id резерва
        updateReservationResultUI(reReservationNo);  // печать результата нового резерва столика, через представление
    }
}
