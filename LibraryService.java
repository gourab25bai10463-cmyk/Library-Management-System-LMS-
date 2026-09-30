package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.exception.BookNotFoundException;
import java.util.List;

/**
 * Handles core business logic for library operations.
 */
public class LibraryService {
    private final BookRepository repository;

    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(String id, String title, String author) {
        repository.save(new Book(id, title, author));
    }

    public void borrowBook(String id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found."));
        
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is currently borrowed by another user.");
        }
        
        book.setAvailable(false);
        repository.save(book); // Update state
    }

    public void returnBook(String id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found."));
        
        book.setAvailable(true);
        repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }
}
