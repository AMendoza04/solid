package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookManager {
    private List<Book> books;
    @Autowired
    public BookManager()
    {
        this.books = new ArrayList<>();
    }

    public boolean createBook(String book) {


        return true;
    }
}
