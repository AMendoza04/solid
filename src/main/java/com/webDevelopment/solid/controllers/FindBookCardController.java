package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookService;
import com.webDevelopment.solid.useCases.BookCardFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindBookCardController {

    private BookCardFinder bookCardFinder;
    private BookService bookService;
    @Autowired
    public FindBookCardController(BookCardFinder bookCardFinder, BookService bookService) {
        this.bookCardFinder = bookCardFinder; this.bookService = bookService;
    }

    @RequestMapping("/healthCheck")
    public String healthCkeck() {
        return "Server up";
    }

    @PostMapping(value = "/createBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createBook(@RequestBody Book book) {
        HttpStatus code = HttpStatus.FORBIDDEN;
        System.out.println(book.toString());
        //book = new Book("fijdofjdsodjaspdasjaso", "George Orwell", 1949, 20000, "un libro muy melo", 203);
        try{
          //  System.out.println("llamando servicio");

            book = this.bookService.addBook(book);
         //   System.out.println("volviendo del servicio");

        }
        catch(Exception e)
        {

        }
        return true;
    }
    @RequestMapping("/bookCardFinder")
    public String findBookCard() {
        return bookCardFinder.execute();
    }
}
