// BankAccount class
class BankAccount {
    double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

// SavingsAccount subclass overriding withdraw method
class SavingsAccount extends BankAccount {
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= 100) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        SavingsAccount myAccount = new SavingsAccount();
        myAccount.deposit(500);
        myAccount.withdraw(200);  // Successful withdrawal
        System.out.println("Balance: " + myAccount.getBalance());

        myAccount.withdraw(400);  // Withdrawal blocked (balance would be below 100)
        System.out.println("Balance: " + myAccount.getBalance());
    }
}
