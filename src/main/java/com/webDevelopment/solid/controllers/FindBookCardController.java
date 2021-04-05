package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

@RestController
public class FindBookCardController {

    private BookService bookService;
    @Autowired
    public FindBookCardController(BookService bookService) {
       this.bookService = bookService;
    }

    @PostMapping(value = "/createBook")
    public void createBook(@RequestBody Book book) throws Exception {
        HttpStatus code = HttpStatus.FORBIDDEN;
        System.out.println(book.toString());
        try{
            book = this.bookService.addBook(book);
        }
        catch(Exception e)
        {
            throw new Exception("On create book, Cause: " + e.getMessage());
        }
    }

    @GetMapping(value = "/bookList/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBookbyAuth(@PathVariable("author") String authorName)
    {
        String booksByAuthorResponse = null;
        try {
            booksByAuthorResponse = this.bookService.getBooksbyAuth(authorName);
        }
        catch (Exception e) {
            LOGGER.error("BookController.getBookbyAuth Cause: " + e.getMessage());
        }
        return booksByAuthorResponse;
    }

    @GetMapping(value = "/bookDetails/{bookTitle}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String bookDetails(@PathVariable("bookTitle") String bookTitle)
    {
        String bookDetail = null;
        try
        {
            bookDetail = this.bookService.getBookDetails( bookTitle );
            if(bookDetail!=null){
                return bookDetail;
            }

        }catch (Exception e)
        {
            LOGGER.error("BookController.bookDetails Cause: " + e.getMessage());
        }
        return null;
    }
}
