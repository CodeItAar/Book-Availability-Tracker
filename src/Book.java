public class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title + " by " + author + " - " + (available ? "Available" : "Not Available");
    }
}