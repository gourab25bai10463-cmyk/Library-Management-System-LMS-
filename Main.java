package com.library;

import com.library.repository.BookRepository;
import com.library.service.LibraryService;
import com.library.controller.LibraryController;

public class Main {
    public static void main(String[] args) {
        // Dependency Injection wiring
        BookRepository repo = new BookRepository();
        LibraryService service = new LibraryService(repo);
        
        // Seed some initial data
        service.addBook("101", "Effective Java", "Joshua Bloch");
        service.addBook("102", "Clean Code", "Robert C. Martin");

        LibraryController controller = new LibraryController(service);
        controller.start();
    }
}
