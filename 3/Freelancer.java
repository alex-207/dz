public class Freelancer extends Employee {

    private int workHours;
    private int workDays;

    public Freelancer(String name, String surName, double salary, int age, int workHours, int workDays) {
        super(name, surName, salary, age);
        this.workHours = workHours;
        this.workDays = workDays;
    }

    @Override
    public double calculateSalary() {
        return 100 * this.workHours * this.workDays;
    }

    @Override
    public String toString() {
        return super.toString() + " Фрилансер;" + " Среднемесячная заработная плата (почасовая)" + calculateSalary();
    }
}