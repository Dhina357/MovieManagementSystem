package services;
import models.*;
import java.util.*;
import APP.Main;

 

public class CustomerService {

    public static List<Booking> bookings = Main.bookings;
    public static List<Show> shows = Main.shows;
    public static List<Movie> movies = Main.movies;

    // ✅ Book tickets
    public static void bookTicket(User user, int showId, int seats) {
        Show show = null;
        for (Show s : shows) {
            if (s.id == showId) {
                show = s;
                break;
            }
        }
        if (show == null) {
            System.out.println("Show ID not found!");
            return;
        }
        if (seats <= 0 || seats > show.availableSeats) {
            System.out.println("Invalid number of seats. Available: " + show.availableSeats);
            return;
        }

        show.availableSeats -= seats;
        double pricePerSeat = 10.0; // example
        Booking booking = new Booking(Main.bookingIdCounter++, user.id, showId, seats, seats * pricePerSeat, java.time.LocalDate.now().toString());
        bookings.add(booking);
        System.out.println("Booking successful! Total price: $" + (seats * pricePerSeat));
    }

    // ✅ VIEW BOOKING HISTORY
    public static void viewBookingHistory(User user) {
        boolean found = false;
        System.out.println("\n--- Booking History ---");
        for (Booking b : bookings) {
            if (b.userId == user.id) {
                Show s = null;
                Movie m = null;
                for (Show sh : shows) {
                    if (sh.id == b.showId) s = sh;
                }
                if (s != null) {
                    for (Movie mv : movies) {
                        if (mv.id == s.movieId) m = mv;
                    }
                }
                System.out.println("Booking ID: " + b.id + 
                                   ", Movie: " + (m != null ? m.title : "Unknown") +
                                   ", Date: " + (s != null ? s.date : "Unknown") +
                                   ", Seats: " + b.seats +
                                   ", Total: $" + b.totalPrice);
                found = true;
            }
        }
        if (!found) System.out.println("No bookings found.");
    }
}
