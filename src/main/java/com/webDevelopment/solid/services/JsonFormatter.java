package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonFormatter implements Formatter {
    @Override
    public String Format(String message) {
        return "{ 'bookCard' : '" + message + "' }";
    }

    @Override
    public String authorFormat(List<Book> books) {
        String response = "{ \"booksByAuthor\": \n\t[";
        int i = 0;
        for( Book b : books)
        {
            response = response + "\n\t\t{ \"Book" + i + "\":\n\t\t\t\"" + b.bookDetailByAuthor() + "\"\n\t\t}";
            if(i == books.size()-1)
                continue;
            else
            {
                response = response + ",";
            }
            i++;
        }

        response = response + "\n\t]\n}";
        return response;
    }

    @Override
    public String bookDetails(Book book) {
        return "{\"Book\":\n\t\"" + book.bookDetail() + "\"\n}";

    }
}
