import java.util.Scanner;

public class Scaner {

    public String prompt(String message) {  // принять сообщение, которое будет видно перед вводом
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
