package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public Book addBook(Book book);
    public List<Book> getBooksbyAuth(String authName);
}
