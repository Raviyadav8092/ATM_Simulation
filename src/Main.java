import model.User;
import service.AuthService;
import service.ATMService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        ATMService atmService = new ATMService();

        System.out.println("==== Welcome to ATM ====");
        System.out.print("Enter UserId: ");
        String userId = scanner.next();
        System.out.print("Enter PIN: ");
        String pin = scanner.next();

        User user = authService.login(userId, pin);
        if (user != null) {
            System.out.println("Login successful!");
            atmService.start(user);
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}
