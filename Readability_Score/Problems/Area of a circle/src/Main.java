import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double radius = scanner.nextDouble();

        double square = Math.PI * Math.pow(radius, 2);

        System.out.println(square);// put your code here
    }
}