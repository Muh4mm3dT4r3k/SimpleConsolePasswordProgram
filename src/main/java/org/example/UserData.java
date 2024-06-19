package org.example;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private final static Map<String, User> users = new HashMap<>();
    private static UserData userDataInstance;
    static {
        createNumberOfUsers();
    }


    private UserData() {

    }

    private static void createNumberOfUsers() {
        User user;
        for (int i = 0; i < 10; i++) {
            user = new User(
                    "user-" + (i + 1),
                    "user-" + (i+ 1) + "@email.com",
                    "user123456"
            );
            users.put(user.getUsername(), user);
        }
    }

    public static UserData getUserDataInstance() {
        if (userDataInstance == null) {
            userDataInstance = new UserData();
        }
        return userDataInstance;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
