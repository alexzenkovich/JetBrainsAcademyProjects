package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int dCups = 9;
        int money = 550;

        System.out.println("Write action (buy, fill, take, remaining, exit):");

        String choice = scanner.next();
        while (!choice.equals("exit")) {
            switch (choice) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, " +
                            "2 - latte, 3 - cappuccino, back - to main menu:");
                    String kindOfCoffee = scanner.next();
                    if (kindOfCoffee.equals("1")) {
                        if (water >= 250 && beans >= 16 && dCups > 0) {
                            water -= 250;
                            beans -= 16;
                            dCups--;
                            money += 4;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else if (water < 250){
                            System.out.println("Sorry, not enough water!");
                        } else if (beans < 16){
                            System.out.println("Sorry, not enough beans!");
                        } else if (dCups == 0){
                            System.out.println("Sorry, not enough cups!");
                        }
                    } else if (kindOfCoffee.equals("2")) {
                        if (water >= 350 && milk >= 75 && beans >= 20 && dCups > 0) {
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            dCups--;
                            money += 7;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else if (water < 350){
                            System.out.println("Sorry, not enough water!");
                        } else if (milk < 75){
                            System.out.println("Sorry, not enough milk");
                        } else if (beans < 20){
                            System.out.println("Sorry, not enough beans!");
                        } else if (dCups == 0){
                            System.out.println("Sorry, not enough cups!");
                        }
                    } else if (kindOfCoffee.equals("3")) {
                        if (water >= 200 && milk >= 100 && beans >= 12 && dCups > 0) {
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            dCups--;
                            money += 6;
                            System.out.println("I have enough resources, making you a coffee!");
                        } else if (water < 200){
                            System.out.println("Sorry, not enough water!");
                        } else if (milk < 100){
                            System.out.println("Sorry, not enough milk");
                        } else if (beans < 12){
                            System.out.println("Sorry, not enough beans!");
                        } else if (dCups == 0){
                            System.out.println("Sorry, not enough cups!");
                        }
                    } else if (kindOfCoffee.equals("back")) {
                        break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    dCups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you " + money);
                    money -= money;
                    break;
                case "remaining":
                    print(water, milk, beans, dCups, money);
                    break;
            }
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            choice = scanner.next();
        }

    }

    public static void print(int water, int milk, int beans, int dCups, int money) {
        System.out.printf("\nThe coffee machine has:\n%d of water\n%d of milk\n%d of coffee beans\n" +
                "%d of disposable cups\n%d of money\n", water, milk, beans, dCups, money);
    }
}
