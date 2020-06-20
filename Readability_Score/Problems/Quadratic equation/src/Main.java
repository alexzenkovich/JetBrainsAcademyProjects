import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double x1;
        double x2;

        double disc = Math.pow(b, 2) - 4 * a * c;

        if (disc == 0) {
            x1 = -b / (2 * a);
            System.out.println(x1);
        } else if (disc > 0) {
            x1 = (-b + Math.sqrt(disc)) / (2 * a);
            x2 = (-b - Math.sqrt(disc)) / (2 * a);
            if (x1 < x2) {
                System.out.println(x1 + " " + x2);
            } else {
                System.out.println(x2 + " " + x1);
            }
        }

        // put your code here
    }
}