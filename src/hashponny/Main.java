package hashponny;

import hashponny.entities.Book;
import hashponny.entities.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    private static List<Library> readSata(String file) {
        Book[] books;
        Library[] libraries;
        int daysToScan;
        List<Library> set = new ArrayList<Library>();

        try(BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line = br.readLine();
            String[] firstLine = line.split(" ");
            books = new Book[Integer.parseInt(firstLine[0])];
            libraries = new Library[Integer.parseInt(firstLine[1])];
            daysToScan = Integer.parseInt(firstLine[2]);

            readBooksScores(books, br.readLine());

            while((line=br.readLine())!=null){

            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return set;
    }

    private static void retrieveLibrariesData(BufferedReader reader, int numOfLibraries, Book[] books) {
        Library[] libraries = new Library[numOfLibraries];
        try {
            String libDescription;
            String booksDescription;

            int counter = 0;

            while ((libDescription = reader.readLine()) != null) {
                booksDescription = reader.readLine();

                String[] lib = libDescription.split(" ");
                libraries[counter] = new Library(Integer.parseInt(lib[1]), Integer.parseInt(lib[2]));

                String[] booksInLibrary = booksDescription.split(" ");
                for (int i = 0; i < booksInLibrary.length; i++) {
                    libraries[counter].addBook(books[Integer.parseInt(booksInLibrary[i])]);
                }

                counter++;


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readBooksScores(Book[] books, String string) {
        String[] scores = string.split(" ");
        for (int i = 0; i < scores.length; i++) {
            books[i] = new Book(i, Integer.parseInt(scores[i]));
        }
    }
}
