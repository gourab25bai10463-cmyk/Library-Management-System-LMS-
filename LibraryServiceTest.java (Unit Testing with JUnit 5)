package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.exception.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceTest {
    private LibraryService service;

    @BeforeEach
    void setUp() {
        BookRepository repository = new BookRepository();
        service = new LibraryService(repository);
        service.addBook("1", "Test Book", "Test Author");
    }

    @Test
    void testBorrowBookSuccess() {
        service.borrowBook("1");
        Book book = service.getAllBooks().get(0);
        assertFalse(book.isAvailable(), "Book should be marked as unavailable after borrowing.");
    }

    @Test
    void testBorrowBookNotFound() {
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            service.borrowBook("999");
        });
        assertTrue(exception.getMessage().contains("not found"));
    }
}
