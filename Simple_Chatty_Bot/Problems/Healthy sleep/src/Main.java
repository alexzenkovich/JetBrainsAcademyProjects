// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String A = scanner.next();
        String B = scanner.next();
        String H = scanner.next();

        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        int h = Integer.parseInt(H);

        if (h>=a && h<=b){
            System.out.println("Normal");
        } else if (h<a){
            System.out.println("Deficiency");
        } else {
            System.out.println("Excess");
        }
    }
}