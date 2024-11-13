package KI305.Kliuchar.Lab6;

import java.util.ArrayList;
import java.util.List;

// Клас, що представляє книгу
class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    
    // Конструктор та getters/setters
    // ...
    @Override
    public String toString() {
        return "Книга: " + title + ", автор: " + author + ", рік: " + year + ", сторінок: " + pages;
    }
    public Book(String title, String author, int year, int pages) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages= pages;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        if (pages >= 0) {
            this.pages = pages;
        } else {
            System.out.println("Кількість сторінок не може бути від'ємною.");
        }
    }

	public int compareTo(Book other) {
        return Integer.compare(this.pages, other.pages);
    }

}

// Параметризований клас, що представляє полку
public class Polychka<T extends Book> {
    private List<T> books;

    public Polychka() {
        books = new ArrayList<>();
    }

    public void addBook(T book) {
        books.add(book);
    }

    public void removeBook(T book) {
        books.remove(book);
    }

    public T findBookByAuthor(String author) {
        for (T book : books) {
            if (book.getAuthor() != null && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }
    public void printAllBooks() {
        for (T book : books) {
            System.out.println(book); // Перевизначити метод toString в класі Book
        }
    }
    public T findBookWithMinPages() {
        if (books.isEmpty()) {
            return null;
        }

        T minBook = books.get(0);
        for (T book : books) {
            if (book.compareTo(minBook) < 0) {
                minBook = book;
            }
        }
        return minBook;
    }
}