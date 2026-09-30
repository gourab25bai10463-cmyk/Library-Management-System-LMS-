package com.library.controller;

import com.library.service.LibraryService;
import com.library.exception.BookNotFoundException;
import java.util.Scanner;

public class LibraryController {
    private final LibraryService service;
    private final Scanner scanner;

    public LibraryController(LibraryService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View All Books");
            System.out.println("2. Add Book (Admin)");
            System.out.println("3. Borrow Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();
            
            try {
                switch (choice) {
                    case "1" -> showBooks();
                    case "2" -> handleAddBook();
                    case "3" -> handleBorrowBook();
                    case "4" -> {
                        System.out.println("Exiting system...");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (BookNotFoundException | IllegalStateException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private void showBooks() {
        service.getAllBooks().forEach(System.out::println);
    }

    private void handleAddBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        
        service.addBook(id, title, author);
        System.out.println("Book added successfully!");
    }

    private void handleBorrowBook() {
        System.out.print("Enter Book ID to borrow: ");
        String id = scanner.nextLine();
        service.borrowBook(id);
        System.out.println("Book borrowed successfully!");
    }
}
