import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }// put your code here

        boolean check = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i-1]){
                check = false;
                break;
            }
        }
        System.out.println(check);
    }
}