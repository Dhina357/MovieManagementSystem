package models;

 public class Booking {
   public int id;
   public int userId;
    public int showId;
   public int seats;
   public double totalPrice;
   public String date;

    public Booking(int id, int userId, int showId, int seats, double totalPrice, String date) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.date = date;
    }
}
