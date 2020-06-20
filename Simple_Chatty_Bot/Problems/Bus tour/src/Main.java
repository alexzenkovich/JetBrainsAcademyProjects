import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int bus = scanner.nextInt();

        int number = scanner.nextInt();

        int[] bridges = new int[number];

        for (int i = 0; i < number; i++){
            bridges[i] = scanner.nextInt();
        }
        int count = 0;
        for (int i = 0; i < bridges.length; i++){
            if (bus < bridges[i]){
                count++;
            } else {
                break;
            }
        }
        if (count==number){
            System.out.println("Will not crash");
        } else {
            count++;
            System.out.println("Will crash on bridge " + count);
        }
    }
}