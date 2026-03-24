package utils;

import java.time.LocalDate;

public class Validation {

    // ✅ Email validation
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // ✅ Password validation
    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    // ✅ Seat validation
    public static boolean isValidSeats(int requested, int available) {
        return requested > 0 && requested <= available;
    }

    // ✅ Date validation (no past dates)
    public static boolean isFutureDate(String date) {
        try {
            LocalDate inputDate = LocalDate.parse(date);
            return !inputDate.isBefore(LocalDate.now());
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ ID validation
    public static boolean isValidId(int id) {
        return id > 0;
    }
}
