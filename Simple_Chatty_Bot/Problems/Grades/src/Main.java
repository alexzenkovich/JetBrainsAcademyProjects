import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            int t = scanner.nextInt();
            if (t==5){
                A++;
            } else if (t==4){
                B++;
            } else if (t==3){
                C++;
            } else if (t==2){
                D++;
            }
        }
        System.out.println(D + " " + C + " " + B + " " + A);
    }
}