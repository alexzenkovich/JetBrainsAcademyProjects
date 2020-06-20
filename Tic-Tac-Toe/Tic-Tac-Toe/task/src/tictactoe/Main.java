package tictactoe;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = ' ';
            }
        }
        System.out.println("---------");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        Integer x = null;
        Integer y = null;
        boolean isX = true;
        boolean isRight = false;
        boolean xWin = false;
        boolean oWin = false;
        boolean impossible = false;

        int xCount = 0;
        int oCount = 0;
        int allCount = 0;
        while (!xWin || !oWin) {
            System.out.print("Enter the coordinates: ");
            do {
                String line = scanner.nextLine();
                String[] coords = line.split(" ");
                if (coords[0].matches("\\d")) {
                    x = Integer.parseInt(coords[0]) - 1;
                }
                if (coords.length == 2 && coords[1].matches("\\d")) {
                    y = n - Integer.parseInt(coords[1]);
                }
                if (coords.length == 1 && !coords[0].matches("\\d")) {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                }
                if (coords.length == 2 && !coords[0].matches("\\d") && !coords[1].matches("\\d")) {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                }
                if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
                    isRight = true;
                    if (chars[y][x] == 'X' || chars[y][x] == 'O') {
                        isRight = false;
                        System.out.println("This cell is occuped! Choose another one!");
                        System.out.println("Enter the coordinates: ");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");
                    isRight = false;
                }
            } while (!isRight);

            if (isX) {
                chars[y][x] = 'X';
                isX = false;
            } else {
                chars[y][x] = 'O';
                isX = true;
            }

            System.out.println("---------");
            for (int i = 0; i < n; i++) {
                System.out.print("| ");
                for (int j = 0; j < n; j++) {
                    System.out.print(chars[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            for (int i = 0; i < n; i++) {
                if ((chars[i][0] == 'X' && chars[i][1] == 'X' && chars[i][2] == 'X') ||
                        (chars[0][i] == 'X' && chars[1][i] == 'X' && chars[2][i] == 'X') ||
                        (chars[0][0] == 'X' && chars[1][1] == 'X' && chars[2][2] == 'X') ||
                        (chars[0][2] == 'X' && chars[1][1] == 'X' && chars[2][0] == 'X')) {
                    xWin = true;
                    break;
                }
                if ((chars[i][0] == 'O' && chars[i][1] == 'O' && chars[i][2] == 'O') ||
                        (chars[0][i] == 'O' && chars[1][i] == 'O' && chars[2][i] == 'O') ||
                        (chars[0][0] == 'O' && chars[1][1] == 'O' && chars[2][2] == 'O') ||
                        (chars[0][2] == 'O' && chars[1][1] == 'O' && chars[2][0] == 'O')) {
                    oWin = true;
                    break;
                }
                for (int j = 0; j < n; j++) {
                    if (chars[i][j] == 'X') {
                        xCount++;
                        allCount++;
                    }
                    if (chars[i][j] == 'O') {
                        oCount++;
                        allCount++;
                    }
                }
            }
            if (Math.abs(xCount - oCount) >= 2) {
                System.out.println("Impossible");
                break;
            } else if (allCount == 9 && !xWin && !oWin) {
                System.out.println("Draw");
                break;
            } else if (xWin) {
                System.out.println("X wins");
                break;
            } else if (oWin) {
                System.out.println("O wins");
                break;
            }
            xCount = 0;
            oCount = 0;
            allCount = 0;
        }
          /*else if (allCount < 9 && !xWin && !oWin) {
                System.out.println("Game not finished");
            }*/
    }
}
