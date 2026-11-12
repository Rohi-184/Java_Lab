import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Library {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<BookBean> availableBooks = new ArrayList<>();
        ArrayList<BookBean> borrowedBooks = new ArrayList<>();

        DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Adding books

        String[] names = {
            "Java Programming",
            "Python Basics",
            "Web Development",
            "Database Management",
            "C Programming"
        };

        String[] authors = {
            "James Gosling",
            "Guido van Rossum",
            "Jon Duckett",
            "Raghu Ramakrishnan",
            "Dennis Ritchie"
        };

        int[] days = {10, 7, 15, 20, 5};

        for (int i = 0; i < names.length; i++) {

            BookBean b = new BookBean();

            b.setBookId(i + 101);
            b.setBookName(names[i]);
            b.setAuthor(authors[i]);
            b.setPrice(450 + (i * 50));
            b.setBorrowDays(days[i]);

            availableBooks.add(b);
        }

        int choice;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT =====");
            System.out.println("1. Show Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Show Borrowed Books");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n--- AVAILABLE BOOKS ---");

                    if (availableBooks.isEmpty()) {
                        System.out.println("No books available.");
                    }

                    for (BookBean b : availableBooks) {

                        System.out.println("\nBook ID: " + b.getBookId());
                        System.out.println("Book Name: " + b.getBookName());
                        System.out.println("Author: " + b.getAuthor());
                        System.out.println("Price: " + b.getPrice());
                        System.out.println("Borrow Days: " + b.getBorrowDays());
                        System.out.println("----------------------");
                    }

                    break;

                case 2:

                    System.out.print("\nEnter Book ID to borrow: ");
                    int id = sc.nextInt();

                    BookBean selectedBook = null;

                    for (BookBean b : availableBooks) {

                        if (b.getBookId() == id) {
                            selectedBook = b;
                            break;
                        }
                    }

                    if (selectedBook == null) {

                        System.out.println("Book not available!");

                    } else {

                        // Automatically use today's date
                        LocalDate today = LocalDate.now();

                        selectedBook.setFromDate(today);

                        // Move book to borrowed list
                        availableBooks.remove(selectedBook);
                        borrowedBooks.add(selectedBook);

                        System.out.println("\nBook borrowed successfully!");

                        System.out.println("Book Name: " +
                            selectedBook.getBookName());

                        System.out.println("Borrow Days: " +
                            selectedBook.getBorrowDays());

                        System.out.println("From Date: " +
                            today.format(formatter));

                        System.out.println("To Date: " +
                            LocalDate.parse(selectedBook.getToDate())
                            .format(formatter));
                    }

                    break;

                case 3:

                    System.out.println("\n--- BORROWED BOOKS ---");

                    if (borrowedBooks.isEmpty()) {
                        System.out.println("No books borrowed.");
                    }

                    for (BookBean b : borrowedBooks) {

                        System.out.println("\nBook ID: " + b.getBookId());
                        System.out.println("Book Name: " + b.getBookName());
                        System.out.println("Author: " + b.getAuthor());
                        System.out.println("Price: " + b.getPrice());
                        System.out.println("Borrow Days: " + b.getBorrowDays());

                        System.out.println("From Date: " +
                            LocalDate.parse(b.getFromDate())
                            .format(formatter));

                        System.out.println("To Date: " +
                            LocalDate.parse(b.getToDate())
                            .format(formatter));

                        System.out.println("----------------------");
                    }

                    break;

                case 4:

                    System.out.println("Thank you for using Library!");

                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
