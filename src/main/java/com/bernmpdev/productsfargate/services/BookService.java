package com.bernmpdev.productsfargate.services;

import com.bernmpdev.productsfargate.models.Book;
import com.bernmpdev.productsfargate.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll() {
        return this.bookRepository.getAll();
    }

    public Book getById(String id) {
        return this.bookRepository.getById(id);
    }

}