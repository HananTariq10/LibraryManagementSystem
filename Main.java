import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Books");
            System.out.println("6. Search Book by Title");
            System.out.println("7. Search Book by Author");
            System.out.println("8. Rate Book");
            System.out.println("9. List Book Ratings");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book category: ");
                    String category = scanner.nextLine();
                    library.addBook(new Book(title, author, category));
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    library.addUser(new User(userName));
                    break;
                case 3:
                    System.out.print("Enter book title to borrow: ");
                    title = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    library.borrowBook(title, userName);
                    break;
                case 4:
                    System.out.print("Enter book title to return: ");
                    title = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    library.returnBook(title, userName);
                    break;
                case 5:
                    library.listBooks();
                    break;
                case 6:
                    System.out.print("Enter book title to search: ");
                    title = scanner.nextLine();
                    library.searchBooksByTitle(title);
                    break;
                case 7:
                    System.out.print("Enter book author to search: ");
                    author = scanner.nextLine();
                    library.searchBooksByAuthor(author);
                    break;
                case 8:
                    System.out.print("Enter book title to rate: ");
                    title = scanner.nextLine();
                    System.out.print("Enter rating (1-5): ");
                    int rating = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    library.rateBook(title, rating);
                    break;
                case 9:
                    System.out.print("Enter book title to list ratings: ");
                    title = scanner.nextLine();
                    library.listBookRatings(title);
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
