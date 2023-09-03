/** Работник */
public abstract class Employee implements Comparable<Employee> {

    /** Имя */
    protected String name;

    /** Фамилия*/
    protected String surName;

    /** Возраст */
    protected int age;

    /** Ставка заработной платы */
    protected double salary;

    /** Расчет среднемесячной заработной платы */
    public abstract double calculateSalary();

    public Employee(String name, String surName, double salary, int age) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s; %d лет;", surName, name, age);
    }

    @Override
    public int compareTo(Employee o) {
        int surNameRes = surName.compareTo(o.surName);
        if (surNameRes == 0){
            return name.compareTo(o.name);
        }
        return surNameRes;
    }
}