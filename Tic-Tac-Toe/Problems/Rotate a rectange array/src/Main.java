import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                array[i][j] = scanner.nextInt();
            }
        }

        int temp = n;
        n = m;
        m = temp;

        for (int i = 0; i < n; i++){
            for (int j = m-1; j >=0; j--){
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
        // put your code here
    }
}