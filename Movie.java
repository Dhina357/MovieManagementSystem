 package models;
 public class Movie {
    public int id;
    public String title;
    public String genre;
    public int duration;
    public double rating;

    public Movie(int id, String title, String genre, int duration, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }
}