package util;

import model.*;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("user1", new User("user1", "1234", new Account("ACC1001", 1000.0)));
        users.put("user2", new User("user2", "5678", new Account("ACC1002", 2000.0)));
    }

    public static User getUser(String userId) {
        return users.get(userId);
    }
}
