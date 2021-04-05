package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonFormatter implements Formatter {
    @Override
    public String Format(String message) {
        return "{ 'bookCard' : '" + message + "' }";
    }

    @Override
    public String authorFormat(List<Book> books) {
        return null;
    }

    @Override
    public String bookDetails(Book book) {
        return book.bookDetail();
    }
}
