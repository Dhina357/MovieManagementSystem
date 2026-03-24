package services;
import APP.Main;
import java.util.*;
import models.*;
import utils.*;


public class StaffService {

    // Assuming these lists are shared with Main
    public static List<Show> shows = Main.shows;
    public static List<Movie> movies = Main.movies;

    // Schedule a new show
    public static void addShow(int movieId, String date, String time, int seats) {
        Movie movie = null;
        for (Movie m : movies) {
            if (m.id == movieId) {
                movie = m;
                break;
            }
        }
        if (movie == null) {
            System.out.println("Movie ID not found!");
            return;
        }

        Show show = new Show(Main.showIdCounter++, movieId, date, time, seats);
        shows.add(show);
        System.out.println("Show scheduled successfully!");
    }

    // Update existing show
    public static void updateShow(int showId, String newDate, String newTime) {
        for (Show s : shows) {
            if (s.id == showId) {
                if (!Validation.isFutureDate(newDate)) {
                    System.out.println("Invalid date!");
                    return;
                }
                s.date = newDate;
                s.time = newTime;
                System.out.println("Show updated successfully!");
                return;
            }
        }
        System.out.println("Show ID not found!");
    }

    // Cancel a show
    public static void cancelShow(int showId) {
        Iterator<Show> it = shows.iterator();
        while (it.hasNext()) {
            Show s = it.next();
            if (s.id == showId) {
                it.remove();
                System.out.println("Show canceled successfully!");
                return;
            }
        }
        System.out.println("Show ID not found!");
    }

    // View all shows
    public static void viewShows() {
        if (shows.isEmpty()) {
            System.out.println("No shows available.");
            return;
        }
        System.out.println("\n--- Shows List ---");
        for (Show s : shows) {
            Movie m = null;
            for (Movie mv : movies) {
                if (mv.id == s.movieId) {
                    m = mv;
                    break;
                }
            }
            System.out.println("Show ID: " + s.id + ", Movie: " + (m != null ? m.title : "Unknown") + ", Date: " + s.date + ", Time: " + s.time + ", Seats Available: " + s.availableSeats);
        }
    }
}
