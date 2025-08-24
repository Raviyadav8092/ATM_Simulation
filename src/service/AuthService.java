package service;

import model.User;
import util.Database;

public class AuthService {
    public User login(String userId, String pin) {
        User user = Database.getUser(userId);
        if (user != null && user.getPin().equals(pin)) {
            return user;
        }
        return null;
    }
}
