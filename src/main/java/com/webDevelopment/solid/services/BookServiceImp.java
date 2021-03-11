package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{

    List<Book> books;
    ValidateService validateService;
    @Override
    public void addBook(Book book){
        try{
            validateService.validateBook(book);
            books.add(book);
        }catch (Exception e)
        {
            //TODO: LOGGER
        }
    }
}
