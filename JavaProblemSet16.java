public class JavaProblemSet16 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        bankAccount.setAccountNumber("1234567890");
        bankAccount.setAccountHolderName("Swarna Roy");

        bankAccount.deposit(1000.0);

        bankAccount.deposit(500.0);
        bankAccount.withdraw(200.0);
        bankAccount.withdraw(1500.0); 
        bankAccount.deposit(-100.0);
    }

}

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful. New balance: " + getBalance());
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}



