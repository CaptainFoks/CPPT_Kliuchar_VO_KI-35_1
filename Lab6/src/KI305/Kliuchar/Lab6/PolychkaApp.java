package KI305.Kliuchar.Lab6;

class PolychkaApp {
    public static void main(String[] args) {
        Polychka<Book> shelf = new Polychka<>();

        // Створення книг різних типів
        Book book1 = new Book("Java для чайників", "Герберт Шилдт", 2023, 300);
        Book book2 = new Book("Java", "Тестова книга", 2023, 200);
        Book book3 = new Book("Python", "Тестовий Автор", 2023, 400);

        // Додавання книг на полку
        shelf.addBook(book1);
        shelf.addBook(book2);
        shelf.addBook(book3);

        // Пошук книги за автором
        Book foundBook = shelf.findBookByAuthor("Герберт Шилдт");
        System.out.println("Знайдена книга: " + foundBook);

        // Виведення всіх книг
        shelf.printAllBooks();
        
        shelf.removeBook(book2);
        
        shelf.printAllBooks();
        
        Book minBook = shelf.findBookWithMinPages();
        System.out.println("Книга з найменшою кількістю сторінок: " + minBook);
    }
}