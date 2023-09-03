/** Обычный рабочий (фулл-тайм) */
public class Worker extends Employee{
    public Worker(String name, String surName, double salary, int age) {
        super(name, surName, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        // return String.format("%s %s; Рабочий; Среднемесячная заработная плата (фиксированная) %.2f", surName, name, salary);
        return super.toString() + " Рабочий;" + " Среднемесячная заработная плата (фиксированная)" + this.salary;
    }
}