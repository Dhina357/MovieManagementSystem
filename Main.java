package APP;
import java.util.*;
import models.*;
import services.*;
import utils.Validation;

public class Main {

    static Scanner sc = new Scanner(System.in);
     public static List<User> users = new ArrayList<>();
    public static List<Movie> movies = new ArrayList<>();
    public static List<Show> shows = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();

    public static int userIdCounter = 1;
    public static int movieIdCounter = 1;
    public static int showIdCounter = 1;
    public static int bookingIdCounter = 1;

    // ✅ ADMIN MENU
    public static void adminMenu() {
        while (true) {
            System.out.println("\n1. Add Movie\n2. View Movies\n3. Delete Movie\n4. Logout");

            int ch;
            try {
                ch = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            if (ch == 1) {
                sc.nextLine();

                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Genre: ");
                String genre = sc.nextLine();

                System.out.print("Duration: ");
                int duration = sc.nextInt();

                if (duration <= 0) {
                    System.out.println("Invalid duration!");
                    continue;
                }

                System.out.print("Rating: ");
                double rating = sc.nextDouble();

                if (rating < 0 || rating > 10) {
                    System.out.println("Rating must be between 0–10!");
                    continue;
                }

                AdminService.addMovie(title, genre, duration, rating);

            } else if (ch == 2) {
                AdminService.viewMovies();

            } else if (ch == 3) {
                System.out.print("Movie ID: ");
                int id = sc.nextInt();

                if (id <= 0) {
                    System.out.println("Invalid ID!");
                    continue;
                }

                AdminService.deleteMovie(id);

            } else {
                break;
            }
        }
    }

    public static void staffMenu() {
    while (true) {
        System.out.println("\n--- STAFF MENU ---");
        System.out.println("1. Schedule a Show");
        System.out.println("2. Update Show");
        System.out.println("3. Cancel Show");
        System.out.println("4. View Shows");
        System.out.println("5. Logout");

        int choice;
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
            continue;
        }
        sc.nextLine(); // clear buffer

        switch(choice) {
            case 1:
                System.out.print("Movie ID: ");
                int movieId = sc.nextInt();
                sc.nextLine();

                System.out.print("Date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                System.out.print("Time (HH:MM): ");
                String time = sc.nextLine();

                System.out.print("Total Seats: ");
                int seats = sc.nextInt();
                sc.nextLine();

                if (!Validation.isValidId(movieId) || !Validation.isFutureDate(date) || seats <= 0) {
                    System.out.println("Invalid input! Show not scheduled.");
                    break;
                }

                StaffService.addShow(movieId, date, time, seats);
                break;

            case 2:
                System.out.print("Show ID to update: ");
                int showId = sc.nextInt();
                sc.nextLine();

                System.out.print("New Date (YYYY-MM-DD): ");
                String newDate = sc.nextLine();

                System.out.print("New Time (HH:MM): ");
                String newTime = sc.nextLine();

                StaffService.updateShow(showId, newDate, newTime);
                break;

            case 3:
                System.out.print("Show ID to cancel: ");
                int cancelId = sc.nextInt();
                sc.nextLine();

                StaffService.cancelShow(cancelId);
                break;

            case 4:
                StaffService.viewShows();
                break;

            case 5:
                return; // logout
            default:
                System.out.println("Invalid choice!");
        }
    }
}

    public static void customerMenu(User user) {
    while (true) {
        System.out.println("\n--- CUSTOMER MENU ---");
        System.out.println("1. View Profile");
        System.out.println("2. Edit Profile");
        System.out.println("3. Browse Movies & Shows");
        System.out.println("4. Book Tickets");
        System.out.println("5. View Booking History");
        System.out.println("6. Logout");

        int choice;
        try {
            choice = sc.nextInt();
        } catch(Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
            continue;
        }
        sc.nextLine(); // clear buffer

        switch(choice) {
            case 1:
                System.out.println("ID: " + user.id);
                System.out.println("Name: " + user.name);
                System.out.println("Email: " + user.email);
                System.out.println("Role: " + user.role);
                break;

            case 2:
                System.out.print("New Name: ");
                user.name = sc.nextLine();

                System.out.print("New Email: ");
                String newEmail = sc.nextLine();
                if (Validation.isValidEmail(newEmail)) {
                    user.email = newEmail;
                } else {
                    System.out.println("Invalid Email!");
                }
                break;

            case 3:
                AdminService.viewMovies();
                StaffService.viewShows();
                break;

            case 4:
                System.out.print("Show ID to book: ");
                int showId = sc.nextInt();

                System.out.print("Number of Seats: ");
                int seats = sc.nextInt();
                sc.nextLine();

                CustomerService.bookTicket(user, showId, seats);
                break;

            case 5:
                CustomerService.viewBookingHistory(user);
                break;

            case 6:
                return; // logout

            default:
                System.out.println("Invalid choice!");
        }
    }
}
    // ✅ MAIN METHOD (NOW CORRECTLY INSIDE CLASS)
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine();
                continue;
            }

            sc.nextLine();

            if (choice == 1) {

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                if (!email.contains("@")) {
                    System.out.println("Invalid email!");
                    continue;
                }

                System.out.print("Password: ");
                String password = sc.nextLine();

                if (password.length() < 6) {
                    System.out.println("Password must be at least 6 characters!");
                    continue;
                }

                System.out.print("Role (ADMIN/STAFF/CUSTOMER): ");
                String role = sc.nextLine().toUpperCase();

                if (!role.equals("ADMIN") && !role.equals("STAFF") && !role.equals("CUSTOMER")) {
                    System.out.println("Invalid role!");
                    continue;
                }

                AuthService.register(name, email, password, role);
            }

            else if (choice == 2) {

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                User user = AuthService.login(email, password);

                if (user == null) {
                    System.out.println("Invalid credentials!");
                } else {
                    if (user.role.equals("ADMIN")) {
                        adminMenu();
                    } else if (user.role.equals("STAFF")) {
                        staffMenu();
                    } else {
                        customerMenu(user);
                    }
                }
            }

            else {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}