public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price){
        this.title= title;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){
        return title + ", by " + author + ". Cost: $" + price;
    }

}
