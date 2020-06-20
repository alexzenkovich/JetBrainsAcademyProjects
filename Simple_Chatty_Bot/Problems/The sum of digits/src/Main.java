// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int n = scanner.nextInt();

        int one = n/100;
        int two = n%100/10;
        int three = n%10;

        int res = one + two + three;
        System.out.println(res);
    }
}