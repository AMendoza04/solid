package com.webDevelopment.solid.services;

import com.webDevelopment.solid.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidateServiceImpl implements ValidateService{
    @Override
    public void validateBook(Book book) throws Exception {

        List<Integer> validationList = book.selfValidation();
        String[] errores = {"title ", "description", "price","author", "year"};
        String message = "";
        boolean flag = false;
        for(int i = 0 ; i < validationList.size(); ++i)
        {
            if(validationList.get(i) == 0)
            {
                flag = true;
                message = message + " " + errores[i];
            }
        }
        if(flag)
            throw new Exception("On ValidationService.validateBook, Cause: " + message);

    }
}
