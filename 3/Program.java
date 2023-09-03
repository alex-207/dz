import java.util.Arrays;
import java.util.Random;
import java.io.IOException;

public class Program {

    private static Random random = new Random();

    /* ДЗ 3 
    Доработать приложение, которое мы разрабатывали на уроке. Мы доллжны поработать с сортировкой объектов, освоить работу с интерфейсами Comparator, Comparable.

    1. Доработать класс Freelancer, при желании можно разработать и свой собтственный тип сотрудника.
    2. Переработать метод generateEmployee, метод должен создавать случайного сотрудника (Worker, Freelancer или любого другого). Метод должен быть один!
    3. Придумать свой собственный компаратор (Возможно отсортировать сотрудников по возрасту? Тогда добавьте соответствующее состояние на уровне ваших классов).
    4. Продемонстрировать сортировку объектов различного типа с использованием собственного компаратора. */

    public static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        int salaryIndex = random.nextInt(200, 500);
        int select = random.nextInt(0, 2);  // выбор кого создать: 0 - Рабочего; 1 - Фрилансера
        // System.out.println(select);
        int workDays = random.nextInt(1,30);
        int workHours = random.nextInt(1,24);
        int emloyeeAge = random.nextInt(18, 99);
        
        if(select == 0) return new Worker(names[random.nextInt(names.length)], surNames[random.nextInt(surNames.length)], 100 * salaryIndex, emloyeeAge);
        else return new Freelancer(names[random.nextInt(names.length)], surNames[random.nextInt(surNames.length)], 100 * salaryIndex, emloyeeAge, workDays, workHours);
    }

    public static Employee[] generateEmployeers(int count){
        Employee[] employeers = new Employee[count];
        for (int i = 0; i < count; i++){
            employeers[i] = generateEmployee();
        }
        return employeers;
    }

    
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли

        Employee[] employeers = generateEmployeers(5);

        for (Employee employee: employeers) {
            System.out.println(employee);
        }


        // Arrays.sort(employeers, new SalaryComparator());
        Arrays.sort(employeers, new AgeComparator());

        System.out.println();

        for (Employee employee: employeers) {
            System.out.println(employee);
        }
    }
}