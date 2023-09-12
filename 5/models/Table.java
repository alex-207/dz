package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

// КЛАС - СТОЛИК
public class Table {

    private static int counter;  // счетчик для id столиков
    private final int no;  // id столика
    private final Collection<Reservation> reservations = new ArrayList<>();  // список резервов для конкретного столика

    {
        no = ++counter;  // увеличение статического счетчика для id столиков
    }

    public int getNo() {  // гетер - получить id столика
        return no;
    }
    public Collection<Reservation> getReservations() {  // гетер - получить список резервов для конкретного столика 
        return reservations;
    }
    
    @Override
    public String toString() {  // читаемый вывод
        return String.format(Locale.getDefault(), "Столик #%d", no);  
    }
}
