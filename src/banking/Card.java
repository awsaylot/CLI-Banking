package banking;
import java.util.Random;

public class Card {
    private int bin = 400000;
    private String pin;
    private int accountNumber;
    private String cardNumber;

    private int balance;

    public Card() {
        this.cardNumber = generateCardNumber();
        this.pin = generatePinNumber();
    }
    private String addFiller(int digits, int toFill) {
        String filler = "";
        for (int i = 0; i < toFill - digits; i++) {
            filler += "0";
        }
        return filler;
    }
    private String generateCardNumber() {
        Random random = new Random();
        accountNumber = random.nextInt(99999);
        int numOfDigits = String.valueOf(accountNumber).length();
        String cardNumber = bin + addFiller(numOfDigits, 9) + accountNumber;
        boolean cardExists = Bank.checkIfCardExists(cardNumber);
        while (cardExists) {
            accountNumber = random.nextInt(99999);
            numOfDigits = String.valueOf(accountNumber).length();
            cardNumber = bin + addFiller(numOfDigits, 9) + accountNumber;
            cardExists = Bank.checkIfCardExists(cardNumber);
        }
        int lastDigit = luhnAlgo(cardNumber);
        return cardNumber + lastDigit;
    }
    private int luhnAlgo(String cardNumber) {
        int controlNumber = 0;
        for (int i = 0; i < cardNumber.length(); i++){
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if ((i + 1) % 2 != 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            controlNumber += digit;
        }
        if (controlNumber % 10 == 0) {
            return 0;
        }
        int lastDigit = (controlNumber / 10 + 1) * 10 - controlNumber;
        System.out.println(lastDigit);
        return lastDigit;
    }
    private String generatePinNumber() {
        Random random = new Random();
        int pin = random.nextInt(9999);
        return addFiller(String.valueOf(pin).length(), 4) + pin;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public String getPin() {
        return pin;
    }
    public int getBalance() {
        return balance;
    }
}
