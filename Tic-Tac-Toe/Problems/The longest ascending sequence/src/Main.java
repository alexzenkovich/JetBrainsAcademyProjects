import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[scanner.nextInt()];

        for (int i = 0; i < numbers.length; i++){
            numbers[i] = scanner.nextInt();
        }// put your code here

        int count = 1;
        int max = 0;
        if (numbers.length == 1) max = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i-1]){
                count++;
                max = count;
            }
            if (numbers[i] < numbers[i-1]){
                count = 1;
            }
        }
        System.out.println(max);// put your code here
    }
}