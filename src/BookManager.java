import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query)) {
                results.add(b);
            }
        }
        return results;
    }
}