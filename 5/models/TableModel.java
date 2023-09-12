package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

// КЛАСС ЛОГИКИ МОДЕЛИ - ДЛЯ ВНУТРЕННЕЙ РАБОТЫ С БД СТОЛИКОВ (ЗАПОЛНЕНЕНИЕ БД СТОЛИКАМИ, НОВЫЙ РЕЗЕРВ, ЗАМЕНА СТАРОГО РЕЗЕРВА НА НОВЫЙ), ИМПЛЕМЕНТИТ ИНТЕРФЕЙС ДЛЯ Model
public class TableModel implements Model { 

    private Collection<Table> tables;  // пустая бд для столиков
    // private Table table = new Table();

    // МЕТОД - ЗАПОЛНИТЬ БД СТОЛИКАМИ
    public Collection<Table> loadTablesList(){
        
        // "ЛЕНИВАЯ ИНИЦИАЛИЗАЦИЯ"
        if (tables == null){  // если бд пустая
            tables = new ArrayList<>();  // создать пустой список для бд
    
            // ЗАПОЛНИТЬ СПИСОК
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;  // коллекция столиков
    }

    // МЕТОД - НОВЫЙ РЕЗЕРВ СТОЛИКА, ЧЕРЕЗ БД "tables"
    public int reservationTable(Date reservationDate, int tableNo, String name){  // принять от клиента дату резерва, id столика, имя
        for (Table table : loadTablesList()) {  // пройти по всей бд столиков
            if (table.getNo() == tableNo && table.getReservations() != null){  // если id столика в бд == запрашиваемому номеру столика и в списке резервов этот столик отсутствует
                Reservation reservation = new Reservation(reservationDate, name);  // создать резерв на, принятую от клиента, дату резерва и на его имя
                table.getReservations().add(reservation);  // добавить данный резерв в список резервов для данного столика
                return reservation.getId();  // вернуть id резерва
            }
        }

        // ЕСЛИ ТАКОГО НОМЕРА СТОЛИКА НЕТ В БД ИЛИ ОН УЖЕ ЗАРЕЗЕРВИРОВАН 
        return -1;  // обычный return
        // throw new RuntimeException("Некорректный номер столика");  // исключение
    }

    // ДЗ: МЕТОД - ЗАМЕНА СТАРОГО РЕЗЕРВА СТОЛИКА НА НОВЫЙ, ЧЕРЕЗ БД "tables"
    public int changeReservationTable(int oldReservationId, Date reservationDate, int tableNo, String name){  // принять от клиента старый id резерва, новыю дату резерва, новый id столика, новое имя
        
        // УДАЛИТЬ СТАРУЮ БРОНЬ ИЗ СПИСКА РЕЗЕРВОВ
        // for (Reservation reserve : table.getReservations()) {  // пройти по коллекции резервов
        //     if (reserve.getId() == oldReservationId){  // найти данный резерв в коллекции резервов
        //         table.getReservations().remove(reserve.getId());
        //     }
        // }

        // СОЗДАТЬ НОВУЮ БРОНЬ
        for (Table table : loadTablesList()) {  // пройти по всей бд столиков
            if (table.getNo() == tableNo && table.getReservations() != null){  // если id столика в бд == запрашиваемому номеру столика и в списке резервов этот столик отсутствует
                Reservation newReservation = new Reservation(reservationDate, name);  // создать новый резерв на, принятую от клиента, дату резерва и на его имя
                table.getReservations().add(newReservation);  // добавить данный резерв в список резервов для данного столика

                return newReservation.getId();  // вернуть новый id резерва
            }
        }
        return -1;
    }
}
