package readability;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = args[0];
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String line = reader.readLine();
                stringBuilder.append(line);
            }
        } catch (IOException e) {

        }

        String text = stringBuilder.toString();

//        String text = scanner.nextLine();
        String[] sentences = text.split("[!.?]");

        int allWords = text.trim().split(" ").length;
        int allSentences = sentences.length;
        int allCharacters = text.toCharArray().length - allWords + 1;
        int syllables = getSyllablesNumber(text.replaceAll("\\p{Punct}", ""));
        int polysyllables = getPolysyllablesNumber(text.replaceAll("\\p{Punct}", ""));

        System.out.println("Words: " + allWords);
        System.out.println("Sentences: " + allSentences);
        System.out.println("Characters: " + allCharacters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String method = scanner.next();
        System.out.println();
        String age;
        switch (method) {
            case "ARI":
                age = getAgeByScore(getAri(allCharacters, allWords, allSentences));
                System.out.printf("Automated Readability Index: %.2f (about %s year olds).\n",
                        getAri(allCharacters, allWords, allSentences), age);
                break;
            case "FK":
                age = getAgeByScore(getFK(allWords, allSentences, syllables));
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n",
                        getFK(allWords, allSentences, syllables), age);
                break;
            case "SMOG":
                age = getAgeByScore(getSMOG(polysyllables, allSentences));
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).\n",
                        getSMOG(polysyllables, allSentences), age);
                break;
            case "CL":
                age = getAgeByScore(getCLI(allCharacters, allWords, allSentences));
                System.out.printf("Coleman–Liau index: %.2f (about %s year olds).\n",
                        getCLI(allCharacters, allWords, allSentences), age);
                break;
            case "all":
                String ariScore = getAgeByScore(getAri(allCharacters, allWords, allSentences));
                String fkScore = getAgeByScore(getFK(allWords, allSentences, syllables));
                String smogScore = getAgeByScore(getSMOG(polysyllables, allSentences));
                String clScore = getAgeByScore(getCLI(allCharacters, allWords, allSentences));
               // double average = (ariScore + fkScore + smogScore + clScore) / 4;
                System.out.printf("Automated Readability Index: %.2f (about %s year olds).\n",
                        getAri(allCharacters, allWords, allSentences), ariScore);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n",
                        getFK(allWords, allSentences, syllables), fkScore);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).\n",
                        getSMOG(polysyllables, allSentences), smogScore);
                System.out.printf("Coleman–Liau index: %.2f (about %s year olds).\n",
                        getCLI(allCharacters, allWords, allSentences), clScore);
               /* System.out.printf("This text should be understood in average by %.2f years olds.",
                        average);*/
                break;
        }
    }

    public static int getPolysyllablesNumber(String text) {
        int polysyllables = 0;
        int count = 0;
        int vowels = 0;
        String[] words = text.trim().split(" ");

        for (String word : words) {
            if (!word.equals("")) {
                String[] letters = word.split("");
                for (int i = 0; i < letters.length - 1; i++) {
                    if (letters[i].matches("[aeiouyAEIOUY]") && letters[i + 1].matches("[^aeiouy]")) {
                        count++;
                        vowels++;
                    }
                    if (i == letters.length - 2 && letters[i].matches("[^aeoiuy]") &&
                            letters[i + 1].matches("[aoiuy]")) {
                        count++;
                        vowels++;
                    }
                }
                if (vowels == 0) {
                    count++;
                }
            }
            if (count >= 3) {
                polysyllables++;
            }
            vowels = 0;
            count = 0;
        }
        return polysyllables;
    }

    public static int getSyllablesNumber(String text) {
        int count = 0;
        int vowels = 0;
        String[] words = text.trim().split(" ");

        for (String word : words) {
            if (!word.equals("")) {
                String[] letters = word.split("");
                for (int i = 0; i < letters.length - 1; i++) {
                    if (letters[i].matches("[aeiouyAEIOUY]") && letters[i + 1].matches("[^aeiouy]")) {
                        count++;
                        vowels++;
                    }
                    if (i == letters.length - 2 && letters[i].matches("[^aeoiuy]") &&
                            letters[i + 1].matches("[aoiuy]")) {
                        count++;
                        vowels++;
                    }
                    if (i == letters.length - 2 && letters[i].matches("[aeoiuy]") &&
                            letters[i + 1].matches("[aeoiuy]")) {
                        count++;
                        vowels++;
                    }
                }
                if (vowels == 0) {
                    count++;
                }
            }
            vowels = 0;
        }
        return count;
    }

    public static double getCLI(int characters, int words, int sentences) {
        double L = (double) characters / words * 100;
        double S = (double) sentences / words * 100;
        return Math.abs(0.0588 * L - 0.296 * S - 15.8);
    }

    public static double getSMOG(int polysyllables, int sentences) {
        return Math.abs(1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291);
    }

    public static double getFK(int words, int sentences, int syllables) {
        double part1 = (0.39 * words) / sentences;
        double part2 = (11.8 * syllables) / words;
        return Math.abs(part1 + part2 - 15.59);
    }

    public static double getAri(int characters, int words, int sentences) {
        return Math.abs(4.71 * characters / words + 0.5 * words / sentences - 21.43);
    }

    public static String getAgeByScore(double score) {
        String age = "";
        int sc = (int) Math.round(score);
        switch (sc) {
            case 1:
                age = "6";
                break;
            case 2:
                age = "7";
                break;
            case 3:
                age = "9";
                break;
            case 4:
                age = "10";
                break;
            case 5:
                age = "11";
                break;
            case 6:
                age = "12";
                break;
            case 7:
                age = "13";
                break;
            case 8:
                age = "14";
                break;
            case 9:
                age = "15";
                break;
            case 10:
                age = "16";
                break;
            case 11:
                age = "17";
                break;
            case 12:
                age = "18";
                break;
            case 13:
                age = "24";
                break;
            case 14:
                age = "25";
        }
        return age;
    }
}
