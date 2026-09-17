package com.library.repository;

import com.library.model.Book;
import java.util.*;

/**
 * Simulates database operations using an in-memory Map.
 */
public class BookRepository {
    private final Map<String, Book> database = new HashMap<>();

    public void save(Book book) {
        database.put(book.getId(), book);
    }

    public Optional<Book> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(database.values());
    }

    public void deleteById(String id) {
        database.remove(id);
    }
}
