import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            String[] letters = string.split("");
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].matches("[^0-9]")) {
                    sb.append(letters[i]);
                }
            }
        }
        // write your code with StringBuilder here
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}