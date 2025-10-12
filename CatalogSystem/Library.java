import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library {

    private List<Book> catalog;
    private Scanner scanner;

    public Library() {
        catalog = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // Create a Library instance and run the application
        Library library = new Library();
        library.run();
    }

    /**
     * The main loop of the application that displays the menu and handles user input.
     */
    public void run() {
        while (true) {
            printMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBooks();
                    break;
                case 3:
                    listAllBooks();
                    break;
                case 4:
                    System.out.println("Thank you for using the Library Catalog. Goodbye!");
                    scanner.close();
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
            System.out.println(); // Add a newline for better readability
        }
    }

    private void printMenu() {
        System.out.println("--- Library Catalog Menu ---");
        System.out.println("||  1. Add a new book     ||");
        System.out.println("||  2. Search for a book  ||");
        System.out.println("||  3. List all books     ||");
        System.out.println("||  4. Exit               ||");
        System.out.println("============================");

        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Return an invalid choice
        }
    }

    /**
     * Prompts the user for a book's title and author, then adds it to the catalog.
     */
    private void addBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();

        catalog.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    /**
     * Searches the catalog by title or author based on a user's search term.
     */
    private void searchBooks() {
        System.out.print("Enter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        List<Book> foundBooks = new ArrayList<>();

        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(searchTerm) ||
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                foundBooks.add(book);
            }
        }

        if (foundBooks.isEmpty()) {
            System.out.println("No books found matching your search.");
        } else {
            System.out.println("Found books:");
            for (Book book : foundBooks) {
                System.out.println("- " + book);
            }
        }
    }

    /**
     * Displays all the books currently in the catalog.
     */
    private void listAllBooks() {
        if (catalog.isEmpty()) {
            System.out.println("The catalog is currently empty.");
        } else {
            System.out.println("--- All Books in Catalog ---");
            for (Book book : catalog) {
                System.out.println("- " + book);
            }
        }
    }
}
