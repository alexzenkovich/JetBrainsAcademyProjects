import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }// put your code here
        int checkNum = scanner.nextInt();
        int count = 0;
        for (int x : nums) {
            if (x == checkNum){
                count++;
            }
        }
        System.out.println(count);
    }
}