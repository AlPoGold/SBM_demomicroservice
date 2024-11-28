package org.example.microservice_demo.unitTests;

import org.example.microservice_demo.model.Book;
import org.example.microservice_demo.repositories.BookRepository;
import org.example.microservice_demo.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testGetBookById() {
        Book book = new Book("Spring Boot", "John Doe",
                "1234567890");
        book.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Optional<Book> foundBook =
                bookService.getBookById(1L);
        assertEquals("Spring Boot",
                foundBook.get().getTitle());
    }

}
