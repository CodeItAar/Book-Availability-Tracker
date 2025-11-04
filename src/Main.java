public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        NotificationManager notifier = new NotificationManager();

        manager.addBook(new Book("The Da Vinci Code", "Dan Brown"));
        manager.addBook(new Book("Clean Code", "Robert C. Martin"));

        // Search book
        Book searched = manager.searchBookByTitle("Clean Code");
        System.out.println(searched);

        // Update status
        manager.updateBookStatus("Clean Code", false);
        notifier.notifyAvailability("The Da Vinci Code");

        // Print all available books
        for (Book b : manager.getAvailableBooks()) {
            System.out.println(b);
        }
    }
}

