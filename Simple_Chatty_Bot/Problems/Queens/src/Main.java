// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if ((a-c)*(a-c)==(b-d)*(b-d) || (a==c || b==d)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}