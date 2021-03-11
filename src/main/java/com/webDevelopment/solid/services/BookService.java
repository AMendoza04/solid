package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    public void addBook(Book book);
}
