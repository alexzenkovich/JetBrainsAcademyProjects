// Posted from EduTools plugin
import java.util.Scanner; //put imports you need here

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.next();
        int age = scanner.nextInt();
        String sec = scanner.next();
        int numb = scanner.nextInt();
        String dish = scanner.next();

        System.out.println("The form for " + name + " is completed. " +
                "We will contact you if we need a chef that cooks " +
                dish + " dishes.");// put your code here
    }
}