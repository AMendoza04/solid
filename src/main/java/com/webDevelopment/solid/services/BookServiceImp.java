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

        try{
            validateService.validateBook(book);

            books.add(book);
            imprimirLibros();

        }catch (Exception e)
        {
            System.out.println("Error validar" + e.getMessage());
            //TODO: LOGGER
        }
        return book;
    }

    @Override
    public String getBooksbyAuth(String authName) {
        List<Book> bookByAuthor = new ArrayList<>();

        for(Book b : books)
        {
            if(b.getAuthor().toUpperCase().contains(authName.toUpperCase()))
            {
                bookByAuthor.add(b);
            }
        }
       return ""; //return booksJSONFormatted(bookByAuthor);
    }

    private List<Book> booksJSONFormatted(List<Book> bookByAuthor) {
        for(Book b : books)
        {
        }
        return null;
    }

    @Override
    public String getBookDetails(String bookTitle) {
        bookTitle.replace("%20", " ");
        for( Book book : this.books)
        {
            if(book.getTitle().contains(bookTitle))
            {
                return book.bookDetail();
            }
        }
        return null;
    }

    public void imprimirLibros()
    {
        for(Book b: books)
        {
            System.out.println(b.createBookCard());
        }
    }
}
