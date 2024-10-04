import java.util.Scanner;

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
    private int correctPin;
    private int attempts;
    private boolean isPinBlocked;

    public ATM(Account savingsAccount, Account currentAccount, int correctPin) {
        this.savingsAccount = savingsAccount;
        this.currentAccount = currentAccount;
        this.correctPin = correctPin;
        this.attempts = 0;
        this.isPinBlocked = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please insert your debit card.");
        
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (validatePin(enteredPin)) {
                showMenu();
                return;
            }
        }
        
        System.out.println("Your PIN has been blocked. Please contact your bank.");
    }

    private boolean validatePin(int enteredPin) {
        if (enteredPin == correctPin) {
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
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose an account: ");
        int accountChoice = scanner.nextInt();

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (accountChoice == 1) {
            savingsAccount.withdraw(amount);
        } else if (accountChoice == 2) {
            if (currentAccount == null) {
                System.out.println("You don't have a Current account.");
            } else {
                currentAccount.withdraw(amount);
            }
        } else {
            System.out.println("Invalid account choice.");
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
        int currentPin = scanner.nextInt();
        
        if (currentPin == correctPin || isPinBlocked) {
            System.out.print("Enter new PIN: ");
            int newPin = scanner.nextInt();
            System.out.print("Confirm new PIN: ");
            int confirmPin = scanner.nextInt();

            if (newPin == confirmPin) {
                correctPin = newPin;
                isPinBlocked = false;
                attempts = 0;
                System.out.println("PIN changed successfully.");
            } else {
                System.out.println("PINs do not match. PIN change failed.");
            }
        } else {
            System.out.println("Incorrect current PIN. PIN change failed.");
        }
    }
}

public class AtmActivity {
    public static void main(String[] args) {
        Account savingsAccount = new Account(100000, "Savings");
        ATM atm = new ATM(savingsAccount, null, 1234);
        atm.start();
    }
}