package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

// ИНТЕРФЕЙС ДЛЯ ЛОГИКИ
public interface Model { 
    
    Collection<Table> loadTablesList();  // метод - заполнить бд столиками

    int reservationTable(Date reservationDate, int tableNo, String name);  // метод - новый резерв столика, через бд "tables"
    
    // ДЗ
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);  // метод - замена старого резерва
}
