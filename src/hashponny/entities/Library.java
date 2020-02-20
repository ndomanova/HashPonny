package hashponny.entities;

import java.util.List;

public class Library {
    private int signUpDuration;
    private int booksToScanPerDay;
    private List<Book> books;

    public Library(int signUpDuration, int booksToScanPerDay) {
        this.signUpDuration = signUpDuration;
        this.booksToScanPerDay = booksToScanPerDay;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }


    public void signUp() {

    }

    public void scanBooks() {

    }
}