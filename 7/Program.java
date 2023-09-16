import java.io.IOException;

    /**
     * TODO: Доработать приложение, которое разрабатывалось на семинаре, поработать с шаблоном проектирования Observer,
     1. Добавить новый тип соискателя.
     2. Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     3. Только после этого вы можете усложнить ваше приложение (при желании), например, добавить тип вакансии (enum), учитывать тип вакансии при отправке предложения соискателю.
     * @param args
     */

public class Program {
    public static void main(String[] args) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  // очистка консоли

        Publisher jobAgency = new JobAgency();
        Company google = new Company("Google", jobAgency);
        Company yandex = new Company("Yandex", jobAgency);
        Company geekBrains = new Company("GeekBrains", jobAgency);

        Student student1 = new Student("Petrov");
        Master master1 = new Master("Ivanov");
        Intern intern1 = new Intern("Sidorov");
        // Intern intern2 = new Intern("Willis");

        jobAgency.registerObserver(student1);
        jobAgency.registerObserver(master1);
        jobAgency.registerObserver(intern1);

        VacancyType type1 = VacancyType.FullTime;
        VacancyType type2 = VacancyType.PartTime;
        VacancyType type3 = VacancyType.RemoteWork;

        Vacancy vacancy1 = new FullTime("Геймер", 30000, type3);
        Vacancy vacancy2 = new RemoteWork("Программист", 160000, type1);
        Vacancy vacancy3 = new PartTime("Уборщик", 15000, type2);

        for (int i = 0; i < 3; i++){
            google.needEmployee(vacancy1);
            yandex.needEmployee(vacancy2);
            geekBrains.needEmployee(vacancy3);
            System.out.println();
        }
    }
}
