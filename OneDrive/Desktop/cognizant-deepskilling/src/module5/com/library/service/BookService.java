package module5.com.library.service;

import module5.com.library.BookAuthor;
import module5.com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private BookAuthor bookAuthor;

    // Constructor Injection
    public BookService(BookAuthor bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("Book: " + bookRepository.getBook());
        System.out.println("Author: " + bookAuthor.getAuthorName());
    }
}