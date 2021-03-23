package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.BookService;
import com.webDevelopment.solid.useCases.BookCardFinder;
import com.webDevelopment.solid.useCases.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.webDevelopment.solid.SolidApplication.LOGGER;

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


    @GetMapping(value = "/bookList/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookbyAuth(@PathVariable("author") String authorName)
    {
        //String authorName = "";
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
