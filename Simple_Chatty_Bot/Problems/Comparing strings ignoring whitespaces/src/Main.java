// Posted from EduTools plugin
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        String word1 = scanner.nextLine().replace(" ", "");
        String word2 = scanner.nextLine().replace(" ", "");

        boolean res = word1.equals(word2);

        System.out.println(res);
    }
}