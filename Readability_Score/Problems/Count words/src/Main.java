import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();

        String[] words = line.split(" ");

        int count = 0;
        for (String word : words) {
            if (!word.trim().equals("")) count++;
        }
        if (words.length < 1) {
            System.out.println("0");
        } else {
            System.out.println(count);
        }
    }

}