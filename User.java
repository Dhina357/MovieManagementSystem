package models;
  public class User {
    public int id;
   public String name;
     public String email;
    public String password;
    public String role; // ADMIN, STAFF, CUSTOMER

    public User(int id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}