// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String res = word.substring(a, b+1);

        System.out.println(res);
    }
}