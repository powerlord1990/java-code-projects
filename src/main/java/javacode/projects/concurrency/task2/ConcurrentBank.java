package javacode.projects.concurrency.task2;

public class ConcurrentBank {
    private int nextAccountNumber = 1;

    private double totalBalance = 0;

    public ConcurrentBank() {
    }


    public BankAccount createAccount(double initialBalance) {
        BankAccount newAccount = new BankAccount(nextAccountNumber++, initialBalance);
        totalBalance = totalBalance + initialBalance;
        return newAccount;
    }


    void transfer(BankAccount sender, BankAccount receiver, Integer amount) {
        Object firstLock;
        Object secondLock;
        if (sender.getAccountNumber() < receiver.getAccountNumber()) {
            firstLock = sender;
            secondLock = receiver;
        } else {
            firstLock = receiver;
            secondLock = sender;
        }
        synchronized (firstLock) {
            synchronized (secondLock) {
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
