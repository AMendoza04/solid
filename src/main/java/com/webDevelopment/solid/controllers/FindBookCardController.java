package com.webDevelopment.solid.controllers;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.useCases.BookCardFinder;
import com.webDevelopment.solid.useCases.BookManager;
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
    private BookManager bookManager;
    @Autowired
    public FindBookCardController(BookCardFinder bookCardFinder) {
        this.bookCardFinder = bookCardFinder;
    }

    @RequestMapping("/healthCheck")
    public String healthCkeck() {
        return "Server up";
    }

    @PostMapping(value = "/createBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createBook(@RequestBody Book book) {
        HttpStatus code = HttpStatus.FORBIDDEN;
        try{

        }
        return bookManager.createBook();
    }
    @RequestMapping("/bookCardFinder")
    public String findBookCard() {
        return bookCardFinder.execute();
    }
}
