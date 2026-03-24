package services;
import models.*;
import java.util.*;

public class AuthService {
    static List<User> users = new ArrayList<>();
    static int userIdCounter = 1;

    public static User register(String name, String email, String password, String role) {
        for (User u : users) {
            if (u.email.equals(email)) {
                System.out.println("Email already exists!");
                return null;
            }
        }
        User user = new User(userIdCounter++, name, email, password, role);
        users.add(user);
        return user;
    }

    public static User login(String email, String password) {
        for (User u : users) {
            if (u.email.equals(email) && u.password.equals(password)) {
                return u;
            }
        }
        return null;
    }
}