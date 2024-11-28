package org.example.microservice_demo.controllers;

import org.example.microservice_demo.model.Book;
import org.example.microservice_demo.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book>
    getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book>
    updateBook(@PathVariable Long id, @RequestBody Book
            bookDetails) {
        return ResponseEntity.ok(bookService.updateBook(id,
                bookDetails));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable
                                           Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
