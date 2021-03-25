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

    @GetMapping(value = "/bookList/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookbyAuth(@PathVariable("author") String authorName)
    {
        System.out.println(authorName);
        List<Book> books = null;
        HttpStatus code = HttpStatus.FORBIDDEN;
        try {
            books = this.bookService.getBooksbyAuth(authorName);
            code = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("ProductController.getProducts Cause: " + e.getMessage());
        }
        return books;//ResponseEntity.status(codigo).body(products);

    }

    @PostMapping(value = "/createBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createBook(@RequestBody Book book) {
        HttpStatus code = HttpStatus.FORBIDDEN;
        System.out.println(book.toString());
        try{

            book = this.bookService.addBook(book);

        }
        catch(Exception e)
        {

        }
        return true;
    }
}
