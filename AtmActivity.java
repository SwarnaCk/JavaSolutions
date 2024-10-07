import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Account {
    private double balance;
    private String type;

    public Account(double balance, String type) {
        this.balance = balance;
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public String getType() {
        return type;
    }
}

class ATM {
    private Account savingsAccount;
    private Account currentAccount;
    private String correctPin;
    private int attempts;
    private boolean isPinBlocked;

    public ATM(Account savingsAccount, Account currentAccount, String correctPin) {
        this.savingsAccount = savingsAccount;
        this.currentAccount = currentAccount;
        this.correctPin = correctPin;
        this.attempts = 0;
        this.isPinBlocked = false;
    }

    public String getCorrectPin() {
        return correctPin;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert your debit card.");
        
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.nextLine();

            if (validatePin(enteredPin)) {
                showMenu();
                return;
            }
        }
        
        System.out.println("Your PIN has been blocked. Please contact your bank.");
    }

    private boolean validatePin(String enteredPin) {
        if (!enteredPin.matches("\\d{4}")) {
            System.out.println("Invalid PIN format. Please enter a 4-digit number.");
            return false;
        }

        if (enteredPin.equals(correctPin)) {
            attempts = 0;
            return true;
        } else {
            attempts++;
            System.out.println("Incorrect PIN entered! " + (3 - attempts) + " attempts remaining.");
            if (attempts >= 3) {
                isPinBlocked = true;
            }
            return false;
        }
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Withdrawal");
            System.out.println("2. Balance Inquiry");
            System.out.println("3. ATM PIN Change");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawal();
                    break;
                case 2:
                    balanceInquiry();
                    break;
                case 3:
                    changePIN();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void withdrawal() {
        Scanner scanner = new Scanner(System.in);
        int accountChoice;
        while (true) {
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.print("Choose an account: ");
            if (scanner.hasNextInt()) {
                accountChoice = scanner.nextInt();
                if (accountChoice == 1 || accountChoice == 2) {
                    break;
                } else {
                    System.out.println("Invalid input. Please choose 1 or 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    
        double amount;
        while (true) {
            System.out.print("Enter amount to withdraw: ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Amount should not be negative or zero. Please enter a valid amount.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.next();
            }
        }
    
        if (accountChoice == 1) {
            savingsAccount.withdraw(amount);
        } else if (accountChoice == 2) {
            if (currentAccount == null) {
                System.out.println("You don't have a Current account.");
            } else {
                currentAccount.withdraw(amount);
            }
        }
    }

    private void balanceInquiry() {
        System.out.println("Savings Account Balance: INR " + savingsAccount.getBalance());
        if (currentAccount != null) {
            System.out.println("Current Account Balance: INR " + currentAccount.getBalance());
        } else {
            System.out.println("You don't have a Current account.");
        }
    }

    private void changePIN() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter current PIN: ");
        String currentPin = scanner.nextLine();
        
        if (currentPin.equals(correctPin) || isPinBlocked) {
            System.out.print("Enter new PIN: ");
            String newPin = scanner.nextLine();
            System.out.print("Confirm new PIN: ");
            String confirmPin = scanner.nextLine();
    
            if (newPin.equals(confirmPin) && newPin.matches("\\d{4}")) {
                correctPin = newPin;
                isPinBlocked = false;
                attempts = 0;
                System.out.println("PIN changed successfully.");
            } else {
                System.out.println("PINs do not match or invalid format. PIN change failed.");
            }
        } else {
            System.out.println("Incorrect current PIN. PIN change failed.");
        }
    }
}

public class AtmActivity {
    private static final String PIN_FILE = "pin.txt";

    public static void main(String[] args) {
        String pin = readPinFromFile();
        if (pin == null) {
            pin = "1234";
        }

        Account savingsAccount = new Account(100000, "Savings");
        ATM atm = new ATM(savingsAccount, null, pin);
        atm.start();

        writePinToFile(atm.getCorrectPin());
    }

    private static String readPinFromFile() {
        try {
            File file = new File(PIN_FILE);
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                return scanner.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading PIN from file: " + e.getMessage());
        }
        return null;
    }

    private static void writePinToFile(String pin) {
        try {
            FileWriter writer = new FileWriter(PIN_FILE);
            writer.write(pin);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing PIN to file: " + e.getMessage());
        }
    }
}