import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];


        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        boolean check = true;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i!=j && arr[i][j]!=arr[j][i]){
                    check = false;
                }
            }
        }// put your code here

        if (check){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}