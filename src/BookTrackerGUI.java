import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class BookTrackerGUI extends JFrame {
    private BookManager bookManager = new BookManager();
    private JTextField titleField, authorField, searchField;
    private JCheckBox availabilityBox;
    private JTextArea displayArea;

    public BookTrackerGUI() {
        setTitle("Book Availability Tracker");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Available:"));
        availabilityBox = new JCheckBox();
        inputPanel.add(availabilityBox);

        JButton addButton = new JButton("Add Book");
        inputPanel.add(addButton);

        JButton clearButton = new JButton("Clear");
        inputPanel.add(clearButton);

        add(inputPanel, BorderLayout.NORTH);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search Title:"));
        searchField = new JTextField(15);
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> addBook());
        clearButton.addActionListener(e -> clearFields());
        searchButton.addActionListener(e -> searchBook());

        setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        boolean available = availabilityBox.isSelected();

        if (!title.isEmpty() && !author.isEmpty()) {
            bookManager.addBook(new Book(title, author, available));
            displayArea.append("Added: " + title + "\n");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both title and author.");
        }
    }

    private void clearFields() {
        titleField.setText("");
        authorField.setText("");
        availabilityBox.setSelected(false);
    }

    private void searchBook() {
        String query = searchField.getText().trim().toLowerCase();
        List<Book> results = bookManager.searchBooks(query);
        displayArea.setText("Search Results:\n");
        for (Book b : results) {
            displayArea.append(b.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        new BookTrackerGUI();
    }
}