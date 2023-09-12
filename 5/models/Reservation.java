package models;
import java.util.Date;

// КЛАСС - РЕЗЕРВОВ СТОЛИКА
public class Reservation { 

    private static int counter = 100;  // счетчик для id резерва - начинается со 100
    private final int id;  // id резерва столика
    private Date date;  // время резерва
    private String name;  // имя клиента

    // КОНСТРУКТОР - РЕЗЕРВ СТОЛИКА
    public Reservation(Date date, String name) {
        this.date = date;  // инициализация даты резерва
        this.name = name;  // инициализация имени клиента
    }

    {
        id = ++counter;  // увеличение статического счетчика для id резерва
    }

    public int getId() {  // гетер - получить id резерва
            return id;
    }
    public Date getDate() {  // гетер - получить дату резерва
        return date;
    }
    public String getName() {  // гетер - получить имя клиента
        return name;
    }
}
