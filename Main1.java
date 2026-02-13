import java.util.ArrayList;

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("-------------------");
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<Book>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    Book searchByTitle(String title) {
        for (Book b : books) {
            if (b.title.equals(title)) {
                return b;
            }
        }
        return null;
    }

    void displayAllBooks() {
        System.out.println("\nAll Books in Library:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class Main1 {
    public static void main(String[] args) {

        Library lib = new Library();

        Book b1 = new Book("Java Basics", "Alpha", "111");
        Book b2 = new Book("Python Basics", "Delta", "222");

        lib.addBook(b1);
        lib.addBook(b2);

        System.out.println("\nSearching for Java Basics...");
        Book found = lib.searchByTitle("Java Basics");

        if (found != null) {
            System.out.println("Book found:");
            found.displayBook();
        } else {
            System.out.println("Book not found");
        }

        lib.displayAllBooks();
    }
}
