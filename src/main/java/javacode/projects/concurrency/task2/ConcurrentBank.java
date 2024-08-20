package javacode.projects.concurrency.task2;

public class ConcurrentBank {
    private int nextAccountNumber = 1;

    private double totalBalance = 0;

    public ConcurrentBank() {
    }

    public double getTotalBankBalance() {
        return getTotalBalance();
    }

    public BankAccount createAccount(double initialBalance) {
        BankAccount newAccount = new BankAccount(nextAccountNumber++, initialBalance);
        totalBalance = totalBalance + initialBalance;
        return newAccount;
    }


    void transfer(BankAccount sender, BankAccount receiver, Integer amount) {
        synchronized (sender) {
            synchronized (receiver) {
                if (sender.withdraw(amount)) {
                    receiver.deposit(amount);
                    System.out.println("Transfer is completed.");
                } else {
                    System.out.println("Transfer failed: insufficient funds.");
                }
            }
        }
    }


    public double getTotalBalance() {
        return totalBalance;
    }
}
