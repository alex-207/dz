package presenters;

import java.util.Date; 

 // ИНТЕРФЕЙС ДЛЯ НАБЛЮДАТЕЛЯ
public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);  // метод - попытка резерва столика

    void onReReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);  // метод - замена старого резерва
}
