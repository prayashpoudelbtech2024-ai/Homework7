import java.util.*;

class Book {
    String isbn;
    String title;
    String author;
    boolean isAvailable;

    Book(String isbn, String title, String author, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    void display() {
        System.out.println("ISBN: " + isbn +
                ", Title: " + title +
                ", Author: " + author +
                ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("Success! Book borrowed.");
                } else {
                    System.out.println("Sorry, this book is currently checked out.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                book.isAvailable = true;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void displayAllBooks() {
        for (Book book : books) {
            book.display();
        }
    }

    void displayAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (book.isAvailable) {
                book.display();
            }
        }
    }
}

public class Scenario2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("978-01", "Java Basics", "James Gosling", true));
        library.addBook(new Book("978-02", "Python Essentials", "Guido van Rossum", true));
        library.addBook(new Book("978-03", "C++ Fundamentals", "Bjarne Stroustrup", true));

        int choice;

        do {
            System.out.println("\n===== Digital Bookshelf Menu =====");
            System.out.println("1. View All Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    library.displayAllBooks();
                    break;

                case 2:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowISBN = sc.nextLine();
                    library.borrowBook(borrowISBN);
                    break;

                case 3:
                    System.out.print("Enter ISBN to return: ");
                    String returnISBN = sc.nextLine();
                    library.returnBook(returnISBN);
                    break;

                case 4:
                    library.displayAvailableBooks();
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}