import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] words = line.split(" ");
        String word = words[0];
        int n = Integer.parseInt(words[1]);

        if (n >= word.length()){
            System.out.println(word);
        } else {
            String nWord = word.substring(n);
            nWord += word.substring(0, n);
            System.out.println(nWord);// put your code here
        }
    }
}