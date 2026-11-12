import java.io.Serializable;
import java.time.LocalDate;

public class BookBean implements Serializable {

    private int bookId;
    private String bookName;
    private String author;
    private double price;
    private int borrowDays;
    private LocalDate fromDate;
    private LocalDate toDate;

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setBorrowDays(int borrowDays) {
        this.borrowDays = borrowDays;
    }

    public int getBorrowDays() {
        return borrowDays;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        this.toDate = fromDate.plusDays(borrowDays);
    }

    public String getFromDate() {
        return fromDate.toString();
    }

    public String getToDate() {
        return toDate.toString();
    }
}
