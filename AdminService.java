package services;
import models.*;
import java.util.*;

import APP.Main;

public class AdminService {
    static List<Movie> movies = Main.movies;
    static List<Booking> bookings = Main.bookings;
    static int movieIdCounter = 1;

    public static void addMovie(String title, String genre, int duration, double rating) {
        movies.add(new Movie(movieIdCounter++, title, genre, duration, rating));
        System.out.println("Movie added successfully!");
    }

    public static void viewMovies() {
        for (Movie m : movies) {
            System.out.println(m.id + " - " + m.title + " (" + m.genre + ")");
        }
    }

    public static void deleteMovie(int id) {
        movies.removeIf(m -> m.id == id);
        System.out.println("Movie deleted!");
    }

    public static void viewBookings() {
        for (Booking b : bookings) {
            System.out.println("Booking ID: " + b.id + " User: " + b.userId);
        }
    }
}