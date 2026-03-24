package models;

 public class Show {
   public int id;
   public int movieId;
   public String date;
   public String time;
   public int totalSeats;
   public int availableSeats;

    public Show(int id, int movieId, String date, String time, int totalSeats) {
        this.id = id;
        this.movieId = movieId;
        this.date = date;
        this.time = time;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
}
