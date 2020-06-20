import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int res = 0;

        while (a!=0){
            res += a;
            a = scanner.nextInt();
        }

        System.out.println(res);
    }
}