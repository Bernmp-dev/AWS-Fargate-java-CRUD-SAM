package com.bernmpdev.productsfargate.controllers;


import com.bernmpdev.productsfargate.models.Book;
import com.bernmpdev.productsfargate.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book) {
        this.bookService.save(book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable String id) {
        this.bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable String id, @RequestBody Book book) {
        this.bookService.update(id, book);
        return ResponseEntity.ok(book);
    }
}