import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int res = 0;

        for (int i = 0; i < n; i++){
            int t = scanner.nextInt();
            if (t%6==0){
                res += t;
            }
        }
        System.out.println(res);
    }
}