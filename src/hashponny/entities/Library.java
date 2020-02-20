package hashponny.entities;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private int signUpDuration;
    private int booksToScanPerDay;
    private List<Book> books;
    private int totalProcessingDays;
    private int averageBookScore;

    public Library(int signUpDuration, int booksToScanPerDay) {
        this.signUpDuration = signUpDuration;
        this.booksToScanPerDay = booksToScanPerDay;
        this.books = new ArrayList<>();
        this.totalProcessingDays = -1;
        this.averageBookScore = -1;
    }

    public int getTotalProcessingDays() {
        if (totalProcessingDays == -1) {
            totalProcessingDays = calculateTotalProcessingDays();
        }
        return totalProcessingDays;
    }

    private int calculateTotalProcessingDays() {
        return signUpDuration + calculateDaysToScanBooks();
    }

    private int calculateDaysToScanBooks() {
        return (int) Math.ceil(books.size() * 1.0/ booksToScanPerDay);
    }

    public int getAverageBookScore() {
        if (averageBookScore == -1) {
            averageBookScore = calculateAverageBookScore();
        }
        return averageBookScore;
    }

    private int calculateAverageBookScore() {
        return books.stream()
                .mapToInt(Book::getScore)
                .sum()
                / books.size();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void signUp() {

    }

    public void scanBooks() {

    }
}