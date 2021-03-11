package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImp implements BookService{

    List<Book> books;
    ValidateService validateService;
    @Autowired
    public BookServiceImp(ValidateService validateService)
    {
        this.validateService=validateService;
        books = new ArrayList<>();
    }
    @Override
    public Book addBook(Book book){
        try{
            System.out.println("pre validar");
            validateService.validateBook(book);
            System.out.println("post validar");

            System.out.println("pre add");
            books.add(book);
            System.out.println(books);
            System.out.println("post add");

        }catch (Exception e)
        {
            System.out.println("Error validar");
            //TODO: LOGGER
        }
        return book;
    }
}
