// 13.Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
public abstract class Animals {
    
    private int idAnimal;
    protected String name;
    protected String classAnimal;
    protected String birthDay;

    public Animals(int idAnimal, String name, String classAnimal, String birthDay) {
        Counter.add();
        this.idAnimal = Counter.getCounter();
        
        if (name.length() > 2) this.name = name;
        else throw new RuntimeException("Некорректое имя!");  // 15. Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведения животного заполнены все поля

        this.classAnimal = classAnimal;
        
        // ИНИЦИАЛИЗАЦИЯ ДАТЫ РОЖДЕНИЯ
        String onlyDigits = birthDay.replaceAll("\\D", "");
        if (onlyDigits.length() != 8) throw new RuntimeException("Некорректая дата рождения!");  // 15. Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение считать в ресурсе try, если при заведения животного заполнены все поля
        else {
            String pattern = "(\\d{2})(\\d{2})(\\d{4})";  // Шаблон для группировки цифр
            String replacement = "$1.$2.$3";  // Шаблон для замены
            this.birthDay = onlyDigits.replaceAll(pattern, replacement);  // Преобразование строки
        }
    }

    
    @Override
    public String toString() {
        return String.format("id=%d, %s='%s', Дата рождения=%s", this.idAnimal, this.classAnimal, this.name, this.birthDay);
    }

    public int getIdAnimal() {
        return idAnimal;
    }
    public String getName() {
        return name;
    }
    public String getClassAnimal() {
        return classAnimal;
    }
    public String getBirthDay() {
        return birthDay;
    }
}
