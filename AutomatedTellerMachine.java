public class AutomatedTellerMachine {
    private int currentBalance;
    private int secretPin;

    // Constructor to initialize account balance and secret pin
    public AutomatedTellerMachine(int initialBalance, int secretPin) {
        this.currentBalance = initialBalance;
        this.secretPin = secretPin;
    }

    // Method to display the main menu
    public void displayMainMenu() {
        System.out.println("\"1. Check Account Balance\"");
        System.out.println("\"2. Deposit Funds\"");
        System.out.println("\"3. Withdraw Cash\"");
        System.out.println("\"4. Update Secret Pin\"");
        System.out.println("\"5. Exit Application\"");
    }

    // Method to deposit funds into the account
    public void depositFunds(int amount) {
        currentBalance += amount;
    }

    // Method to withdraw cash from the account
    public void withdrawCash(int amount) {
        if (currentBalance < amount) {
            System.out.println("\"Insufficient Funds in Account!\"");
            return;
        }
        currentBalance -= amount;
    }

    // Method to retrieve the current account balance
    public int getAccountBalance() {
        return currentBalance;
    }

    // Method to verify the secret pin
    public boolean verifySecretPin(int pin) {
        return this.secretPin == pin;
    }

    // Method to update the secret pin
    public void updateSecretPin(int newPin) {
        secretPin = newPin;
    }

    // Main method
    public static void main(String[] args) {
        AutomatedTellerMachine atm = new AutomatedTellerMachine(1000, 1234);
        System.out.print("\"Enter Your Secret Pin: \"");
        int pin = Integer.parseInt(System.console().readLine());
        if (atm.verifySecretPin(pin)) {
            int option = 0;
            while (option != 5) {
                atm.displayMainMenu();
                option = Integer.parseInt(System.console().readLine());
                switch (option) {
                    case 1:
                        System.out.println("\"Account Balance: $" + atm.getAccountBalance() + "\"");
                        break;
                    case 2:
                        System.out.print("\"Enter Amount to Deposit: \"");
                        int amount = Integer.parseInt(System.console().readLine());
                        atm.depositFunds(amount);
                        break;
                    case 3:
                        System.out.print("\"Enter Amount to Withdraw: \"");
                        amount = Integer.parseInt(System.console().readLine());
                        atm.withdrawCash(amount);
                        break;
                    case 4:
                        System.out.print("\"Enter New Secret Pin: \"");
                        int newPin = Integer.parseInt(System.console().readLine());
                        atm.updateSecretPin(newPin);
                        break;
                    case 5:
                        System.out.println("\"Thank You for Using Our ATM!\"");
                        break;
                    default:
                        System.out.println("\"Invalid Option. Please Choose a Valid Option.\"");
                        break;
                }
            }
        } else {
            System.out.println("\"You Have Entered an Invalid Secret Pin!\"");
        }
    }
}