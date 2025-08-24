package service;

import model.User;

import java.util.Scanner;

public class ATMService {
    private TransactionService transactionService = new TransactionService();
    private Scanner scanner = new Scanner(System.in);

    public void start(User user) {
        int choice;
        do {
            System.out.println("\n==== ATM MENU ====");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + transactionService.checkBalance(user.getAccount()));
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();
                    transactionService.deposit(user.getAccount(), deposit);
                    System.out.println("Deposited successfully!");
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = scanner.nextDouble();
                    if (transactionService.withdraw(user.getAccount(), withdraw)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;

                case 4:
                    System.out.print("Enter target userId: ");
                    String targetId = scanner.next();
                    User targetUser = util.Database.getUser(targetId);
                    if (targetUser != null) {
                        System.out.print("Enter amount to transfer: ");
                        double amount = scanner.nextDouble();
                        if (user.getAccount().getBalance() >= amount) {
                            transactionService.transfer(user.getAccount(), targetUser.getAccount(), amount);
                            System.out.println("Transfer successful!");
                        } else {
                            System.out.println("Insufficient balance!");
                        }
                    } else {
                        System.out.println("Target user not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
