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
    public BookServiceImp(ValidateService validateService) {
        this.books = new ArrayList<>();
        this.validateService = validateService;
    }



    @Override
    public Book addBook(Book book){
        //System.out.println("Pre try");
        try{
            //System.out.println("pre validar");
            validateService.validateBook(book);
            //System.out.println("post validar");

            //System.out.println("pre add");
            books.add(book);
            imprimirLibros();
           // System.out.println("post add");

        }catch (Exception e)
        {
            System.out.println("Error validar" + e.getMessage());
            //TODO: LOGGER
        }
        return book;
    }

    @Override
    public List<Book> getBooksbyAuth(String authName) {
        List<Book> myBooks = new ArrayList<>();

        for(Book b : books)
        {
            if(b.getAuthor().contains(authName))
            {
                myBooks.add(b);
            }
        }
        return myBooks;
    }

    public void imprimirLibros()
    {
        for(Book b: books)
        {
            System.out.println(b.createBookCard());
        }
    }
}
