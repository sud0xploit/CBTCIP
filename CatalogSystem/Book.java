
public class Book {
    private String title;
    private String author;

    // Constructor to create a new Book object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getter for the title
    public String getTitle() {
        return title;
    }

    // Getter for the author
    public String getAuthor() {
        return author;
    }

    // Overriding the toString() method to provide a clean string representation
    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}
