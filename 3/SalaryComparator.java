import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o1.calculateSalary(), o2.calculateSalary());

        /*return o1.calculateSalary() == o2.calculateSalary() ? 0 :
                o1.calculateSalary() > o2.calculateSalary() ? 1 : -1;*/
    }
}