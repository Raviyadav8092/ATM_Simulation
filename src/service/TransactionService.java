package service;

import model.Account;

public class TransactionService {
    public boolean withdraw(Account account, double amount) {
        return account.withdraw(amount);
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public void transfer(Account from, Account to, double amount) {
        from.transfer(to, amount);
    }

    public double checkBalance(Account account) {
        return account.getBalance();
    }
}
