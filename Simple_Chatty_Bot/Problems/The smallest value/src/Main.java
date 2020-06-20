import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        long M = scanner.nextLong();

        long n = 1;

        long res = 1;

        while (res <= M) {

            res = res * n;

            n++;

        }
        System.out.println(n-1);
    }
}