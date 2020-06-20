package encryptdecrypt;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface MessageCrypteAlgorithm {

    String encrypte (String message, int key);
    String decrypte (String message, int key);
}

class SelectCrypter {
    private MessageCrypteAlgorithm algorithm;

    public void setAlgorithm (MessageCrypteAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String crypteMessage (String crypt, String message, int key) {
//        System.out.println("crypteMessage running...");
        if (crypt.equals("enc")) {
            return algorithm.encrypte(message, key);
        } else if (crypt.equals("dec")) {
            return algorithm.decrypte(message, key);
        } else return null;
    }
}

class ShiftCrypter implements MessageCrypteAlgorithm{

    @Override
    public String encrypte(String message, int key) {
//        System.out.println("shiftcrypter.encrypte running...");
        StringBuilder cryptMessage = new StringBuilder();
        for (char letter : message.toCharArray()) {
            if (letter != ' ') {
                char newLetter = 0;
                if (letter >= 'a' && letter <= 'z') {
                    int currentPositiion = letter - 'a';
                    int newPosition = (currentPositiion + key) % 26;
                    newLetter = (char) ('a' + newPosition);
                } else if (letter >= 'A' && letter <= 'Z') {
                    int currentPositiion = letter - 'A';
                    int newPosition = (currentPositiion + key) % 26;
                    newLetter = (char) ('A' + newPosition);
                }
                cryptMessage.append(newLetter);
            } else {
                cryptMessage.append(letter);
            }
        }
        return cryptMessage.toString();
    }
    @Override
    public String decrypte (String message, int key) {
//        System.out.println("shiftcrypter.decrypte running...");
        return encrypte(message, 26 - (key%26));
    }
}

class UnicodeCrypter implements MessageCrypteAlgorithm {

    @Override
    public String encrypte (String message, int key) {
        StringBuilder cryptMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            cryptMessage.append((char) (message.charAt(i) + key));
        }
        return cryptMessage.toString();
    }
    @Override
    public String decrypte (String message, int key) {
        StringBuilder cryptMessage = new StringBuilder();
        for (char letter : message.toCharArray()) {
            cryptMessage.append((char) (letter - key));
        }
        return cryptMessage.toString();
    }
}
public class Main {
    public static void main(String[] args) {

        String operation = "enc";
        String message = "";
        int key = 0;
        String resMessage;
        String algorithm = "shift";
        List<String> arguments = new ArrayList<>(Arrays.asList(args));

        if (arguments.contains("-alg")) {
            algorithm = choiceArgs(args, "-alg");
//            System.out.println("algorithm - " + algorithm);
        }
        if (arguments.contains("-mode")) {
            operation = choiceArgs(args, "-mode");
//            System.out.println("operation - " + operation);
        }
        if (arguments.contains("-key")) {
            key = Integer.parseInt(choiceArgs(args, "-key"));
//            System.out.println("key - " + key);
        }
        if (arguments.contains("-data") && (arguments.contains("-in") ||
                !arguments.contains("-in"))) {
            message = choiceArgs(args, "-data");
        } else if (arguments.contains("-in") && !arguments.contains("-data")) {
            message = inputMessage(args);
        }
//        System.out.println("message - " + message);
        MessageCrypteAlgorithm alg = create(algorithm);
        SelectCrypter crypter = new SelectCrypter();
        crypter.setAlgorithm(alg);
//        System.out.println("message after cryption - " + crypter.crypteMessage(operation, message,key));

        resMessage = crypter.crypteMessage(operation, message, key);

        if (arguments.contains("-out")) {
            outputMessage(args, resMessage);
//            System.out.println("contains -out");
        } else {
            System.out.println(resMessage);
        }
    }

    public static MessageCrypteAlgorithm create (String alg) {
        switch (alg) {
            case "shift":
//                System.out.println("Shift created");
                return new ShiftCrypter();
            case "unicode":
//                System.out.println("unicode created");
                return new UnicodeCrypter();
            default:{
                throw new IllegalArgumentException("unknown algorithm type " + alg);
            }
        }
    }

    public static String inputMessage(String[] arr) {
        StringBuilder sb = new StringBuilder();
        String filename = choiceArgs(arr, "-in");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (br.ready()) {
                sb.append(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return sb.toString();
    }

    public static void outputMessage(String[] arr, String message) {
        String filename = choiceArgs(arr, "-out");
        try (PrintWriter pw = new PrintWriter(filename)) {
            pw.print(message);
        } catch (IOException e) {
            System.out.println("file is already exists.");
        }
    }

    public static String choiceArgs(String[] arr, String str) {
        String res = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(str)) {
                res = arr[i + 1];
            }
        }
        return res;
    }
}
