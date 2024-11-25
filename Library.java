import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " by " + book.getAuthor() + " added to the library.");
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User " + user.getName() + " added to the library.");
    }

    public void borrowBook(String title, String userName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                for (User user : users) {
                    if (user.getName().equalsIgnoreCase(userName)) {
                        user.borrowBook(book);
                        return;
                    }
                }
                System.out.println("User " + userName + " not found.");
                return;
            }
        }
        System.out.println("Sorry, the book " + title + " is not available in the library.");
    }

    public void returnBook(String title, String userName) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                for (User user : users) {
                    if (user.getName().equalsIgnoreCase(userName)) {
                        user.returnBook(book);
                        return;
                    }
                }
                System.out.println("User " + userName + " not found.");
                return;
            }
        }
        System.out.println("Sorry, the book " + title + " is not available in the library.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            for (Book book : books) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (Category: " + book.getCategory() + ")" + (book.isBorrowed() ? " (Borrowed)" : ""));
            }
        }
    }

    public void searchBooksByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (Category: " + book.getCategory() + ")" + (book.isBorrowed() ? " (Borrowed)" : ""));
                return;
            }
        }
        System.out.println("No book found with the title " + title);
    }

    public void searchBooksByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " (Category: " + book.getCategory() + ")" + (book.isBorrowed() ? " (Borrowed)" : ""));
                return;
            }
        }
        System.out.println("No book found by the author " + author);
    }

    public void rateBook(String title, int rating) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.addRating(rating);
                return;
            }
        }
        System.out.println("No book found with the title " + title);
    }

    public void listBookRatings(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Average rating for " + book.getTitle() + " is " + book.getAverageRating());
                return;
            }
        }
        System.out.println("No book found with the title " + title);
    }
}
