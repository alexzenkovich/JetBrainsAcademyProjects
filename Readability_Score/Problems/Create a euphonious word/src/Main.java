import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String[] letters = word.split("");

        int count = 0;
        if (word.length() > 3) {
            for (int i = 0; i < letters.length - 2;) {
                if (letters[i].matches("[aeiouy]") && letters[i + 1].matches("[aeiouy]") &&
                        letters[i + 2].matches("[aeiouy]")){
                    i = i + 2;
                    count++;
                } else if (letters[i].matches("[^aeiouy]") && letters[i + 1].matches("[^aeiouy]") &&
                        letters[i + 2].matches("[^aeiouy]")){
                    i = i + 2;
                    count++;
                } else i++;
/*                if (i == 0) {
                    if (letters[i].matches("[aeiouy]") && letters[i + 1].matches("[aeiouy]") &&
                            letters[i + 2].matches("[aeiouy]")){
                        i = i + 2;
                        count++;
                    } else if (letters[i].matches("[^aeiouy]") && letters[i + 1].matches("[^aeiouy]") &&
                            letters[i + 2].matches("[^aeiouy]")){
                        i = i + 2;
                        count++;
                    }
                } else if (letters[i - 1].matches("[aeiouy]")){
                    if (letters[i].matches("[aeiouy]") && letters[i + 1].matches("[aeiouy]") &&
                            letters[i + 2].matches("[aeiouy]")){
                        count++;
                        if (count>2){
                            count--;
                        }
                    } else if (letters[i].matches("[^aeiouy]") && letters[i + 1].matches("[^aeiouy]") &&
                            letters[i + 2].matches("[^aeiouy]")){
                        count++;
                    }
                } else if (letters[i - 1].matches("[^aeiouy]")){
                    if (letters[i].matches("[aeiouy]") && letters[i + 1].matches("[aeiouy]") &&
                            letters[i + 2].matches("[aeiouy]")){
                        count++;
                    } else if (letters[i].matches("[^aeiouy]") && letters[i + 1].matches("[^aeiouy]") &&
                            letters[i + 2].matches("[^aeiouy]")){
                        count++;
                        if (count>2){
                            count--;
                        }
                    }
                }*/
            }
        }// write your code here
        System.out.println(count);
    }
}