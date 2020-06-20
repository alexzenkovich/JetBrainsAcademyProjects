package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String number = "";
        int radix = 0;
        int newRadix = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            radix = Integer.parseInt(reader.readLine());
            number = reader.readLine();
            newRadix = Integer.parseInt(reader.readLine());

        double decimalNumber = 0;
        String result = "";

        if (((radix > 0 && radix <= 36) && (newRadix > 0 && newRadix <= 36)) && number.matches("[a-z0-9]*[.]?[a-z0-9]*")) {
            if (!number.contains(".")) {
                if (radix != 10 && radix != 1) {
                    decimalNumber = Integer.parseInt(number, radix);
                } else if (radix == 1) {
                    decimalNumber = convertFromOneToDecimal(number);
                } else {
                    decimalNumber = Integer.parseInt(number);
                }
            } else {
                decimalNumber = convertFractionalNumberToDecimal(number, radix);
            }

            if (newRadix != 1 && number.contains(".")) {
                result = convertFractionalDecimalNumberToAnotherBase(decimalNumber, newRadix);
            } else if (newRadix != 1 && !number.contains(".")) {
                result = Integer.toString((int) decimalNumber, newRadix);
            } else {
                result = convertFromDecimalToOne((int) decimalNumber);
            }

            System.out.println(result);
        } else {
            System.out.println("Error!");
        }
        } catch (NumberFormatException | IOException e) {
            System.out.println("error");
        }

    }

    public static String convertFractionalDecimalNumberToAnotherBase(double number, int newRadix) {
        StringBuilder result = new StringBuilder();
        String intPart = Integer.toString((int) number, newRadix);
        result.append(intPart);
        result.append(".");
        double fractPart = number - (int) number;
        for (int i = 0; i < 5; i++) {
            double res = fractPart * newRadix;
            fractPart = res - (int) res;
            if ((int) res <= 9) {
                result.append((int) res);
            } else {
                result.append((char) ((int) res + 87));
            }
        }
        return result.toString();
    }

    public static double convertFractionalNumberToDecimal(String number, int radix) {
        double result = 0;
        String[] parts = number.split("[.]");
        if (parts[0].contains("[a-z]")) {
            String[] letters = parts[0].split("");
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].matches("[a-z]")) {
                    letters[i] = Integer.toString(Integer.parseInt(letters[i]) - 87);
                }
            }
        }
        if (!parts[0].equals("10")) {
            result += Integer.parseInt(parts[0], radix);
        } else {
            result += 10;
        }
        String[] fractPart = parts[1].split("");
        int base = radix;
        double res = 0;
        for (String s : fractPart) {
            if (s.matches("[a-z]")) {
                s = String.valueOf(s.charAt(0) - 87);
            }
            res += (double) Integer.parseInt(s) / base;
            base *= radix;
        }
        result += res;
        return result;
    }

    public static String convertFromDecimalToOne(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number; i++) {
            result.append(1);
        }
        return result.toString();
    }

    public static int convertFromOneToDecimal(String number) {
        return number.length();
    }

    public static String fromDecimalToHex(String number) {
        int num = Integer.parseInt(number);
        int temp = Integer.parseInt(number);
        StringBuilder res = new StringBuilder();
        res.append("0x");
        if (num == 0) res.append(0);
        int count = 0;
        while (temp != 0) {
            temp /= 16;
            count++;
        }
        String[] digits = new String[count];
        int i = 0;
        while (num != 0) {
            int remainder = num % 16;
            if (remainder <= 9) {
                digits[i] = String.valueOf(remainder);
            } else {
                switch (remainder) {
                    case 10:
                        digits[i] = "a";
                        break;
                    case 11:
                        digits[i] = "b";
                        break;
                    case 12:
                        res.append("c");
                        break;
                    case 13:
                        digits[i] = "d";
                        break;
                    case 14:
                        digits[i] = "e";
                        break;
                    case 15:
                        digits[i] = "f";
                        break;
                }
            }
            num /= 16;
            i++;
        }
        for (int j = digits.length - 1; j >= 0; j--) {
            res.append(digits[j]);
        }
        return res.toString();
    }

    public static String fromDecimalToOctop(String number) {
        StringBuilder res = new StringBuilder();
        res.append(0);
        int temp = Integer.parseInt(number);
        int num = Integer.parseInt(number);
        if (num == 0) res.append(0);
        int count = 0;
        while (temp != 0) {
            temp /= 8;
            count++;
        }
        int[] digits = new int[count];
        int i = 0;
        while (num != 0) {
            int remainder = num % 8;
            digits[i] = remainder;
            i++;
            num /= 8;
        }
        for (int j = digits.length - 1; j >= 0; j--) {
            res.append(digits[j]);
        }
        return res.toString();
    }

    public static String fromDecimalToBinary(String number) {
        StringBuilder result = new StringBuilder();
        result.append("0b");
        int temp = Integer.parseInt(number);
        int num = Integer.parseInt(number);
        if (num == 0) result.append(0);
        int count = 0;
        while (temp != 0) {
            temp /= 2;
            count++;
        }
        int[] digitals = new int[count];
        int i = 0;
        while (num != 0) {
            int remainder = num % 2;
            if (remainder == 0) {
                digitals[i] = 0;
            } else {
                digitals[i] = 1;
            }
            num /= 2;
            i++;
        }
        for (int j = digitals.length - 1; j >= 0; j--) {
            result.append(digitals[j]);
        }
        return result.toString();
    }

    public static String fromBinaryToHex(String number) {
        StringBuilder res = new StringBuilder();
        res.append("0x");
        StringBuilder addZero = new StringBuilder();
        int check = number.length();
        if (check % 4 != 0) {
            while (check % 4 != 0) {
                addZero.append(0);
                check++;
            }
        }
        addZero.append(number);
        String[] digits = addZero.toString().split("");
        int temp = 0;
        for (int i = 0; i < digits.length; i = i + 4) {
            if (Integer.parseInt(digits[i]) == 1) temp += 8;
            if (Integer.parseInt(digits[i + 1]) == 1) temp += 4;
            if (Integer.parseInt(digits[i + 2]) == 1) temp += 2;
            if (Integer.parseInt(digits[i + 3]) == 1) temp += 1;
            if (temp <= 9) res.append(temp);
            else if (temp == 10) res.append("A");
            else if (temp == 11) res.append("B");
            else if (temp == 12) res.append("C");
            else if (temp == 13) res.append("D");
            else if (temp == 14) res.append("E");
            else if (temp == 15) res.append("F");
        }
        return res.toString();
    }
}
