package bookLibrary;

import java.util.Date;


public class Book {
   private String title;
   private String author;
   private String  publisher;
   private String releaseDate;
   private String ISBN_Number;
   private double price;

    public Book(String title, String author, String publisher, String releaseDate, String ISBN_Number, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN_Number = ISBN_Number;
        this.price = price;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

}
