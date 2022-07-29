package banking;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        while(running) {
            running = mainMenu();
        }


    }

    public static void printMainMenu() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    public static void printLoggedInMenu() {
        System.out.println("1. Balance");
        System.out.println("2. Log Out");
        System.out.println("0. Exit");
    }

    public static boolean mainMenu() {
        printMainMenu();
        String choice = getInput();
        switch (choice){
            case "1":
                System.out.println("Your card has been created");
                System.out.println("Your card number:");
                Card card = new Card();
                System.out.println(card.getCardNumber());
                System.out.println("Your card PIN:");
                System.out.println(card.getPin());
                Bank.addCard(card);
                return true;
            case "2":
                System.out.println("Enter your card number:");
                String cardNumber = getInput();
                System.out.println("Enter your PIN:");
                String pinNumber = getInput();
                boolean loggedIn = Bank.login(cardNumber, pinNumber);
                if (!loggedIn) {
                    System.out.println("Wrong card number or PIN!");
                } else {
                    System.out.println("You have successfully logged in!");
                    return loggedInMenu(Bank.getCard(cardNumber));
                }
                return true;
            case "0":
                System.out.println("Bye!");
                return false;
            default:
                System.out.println("Select valid input");
                return true;
        }
    }

    public static boolean loggedInMenu(Card card) {
        boolean loggedIn = true;
        while (loggedIn) {
            printLoggedInMenu();
            String choice = getInput();
            switch (choice) {
                case "1":
                    System.out.println(card.getBalance());
                    break;
                case "2":
                    System.out.println("You have successfully logged out");
                    loggedIn = false;
                    return true;
                case "0":
                    loggedIn = false;
                    return false;
            }
        }
        return true;
    }
    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(">");
        String input = scanner.nextLine();
        return input;
    }
}