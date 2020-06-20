import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        int res = 0;

        System.out.print(a);

        while (a!=1){
            if (a%2!=0){
                a = a * 3 + 1;
                System.out.print(" " + a);
            } else {
                a /= 2;
                System.out.print(" " + a);
            }
        }
    }
}