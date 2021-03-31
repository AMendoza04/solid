package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Formatter {
    String Format(String message);
    String authorFormat(List<Book> books);
    String bookDetails(Book book);
}
