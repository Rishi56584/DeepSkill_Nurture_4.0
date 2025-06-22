package week_1.dsa.libarary;

import java.util.Arrays;

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }

    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
}

public class Main {
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "B1", "A1"),
            new Book(2, "B2", "A2"),
            new Book(3, "B3", "A3"),
            new Book(4, "B4", "A4"),
            new Book(5, "B5", "A5")
        };

        long startLinear = System.nanoTime();
        Book found1 = linearSearch(books, "B4");
        long endLinear = System.nanoTime();

        System.out.println("Linear Search:");
        if (found1 != null) System.out.println("Found: " + found1);
        else System.out.println("Book not found.");
        System.out.println("Time taken: " + (endLinear - startLinear) + " ns");

        Arrays.sort(books);

        long startBinary = System.nanoTime();
        Book found2 = binarySearch(books, "B4");
        long endBinary = System.nanoTime();

        System.out.println("\nBinary Search (after sorting):");
        if (found2 != null) System.out.println("Found: " + found2);
        else System.out.println("Book not found.");
        System.out.println("Time taken: " + (endBinary - startBinary) + " ns");
    }
}
