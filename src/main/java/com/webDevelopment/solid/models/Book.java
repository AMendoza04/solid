package com.webDevelopment.solid.models;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private Integer publishedYear;
    private int price;
    private String description;
    private int pages;

    public Book(String title, String author, Integer publishedYear, int price, String description, int pages) {

        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.description = description;
        this.pages = pages;
    }

    public String createBookCard()
    {
        return "The book " + this.title + " has been written by " + this.author + " and was " +
                "published on " + this.publishedYear + ". The book's price is " + this.price;
    }
    public List<Integer> selfValidation() {
        List<Integer> validationList = Arrays.asList(1,1,1,1,1);
        if(this.title.length() < 5 || this.title.length() > 100)
        {
            validationList.set(0,0);
        }
        if(this.description.length() > 200)
        {
            validationList.set(1,0);
        }
        if(this.price < 0 || this.price < 10000)
        {
            validationList.set(2,0);
        }
        String[] authorName = this.author.split(" ");
        if(2 != authorName.length )
        {
            validationList.set(3,0);
        }

        if(this.publishedYear > Year.now().getValue() || Integer.toString(this.publishedYear).length() != 4)
        {
            validationList.set(4,0);
        }
        return validationList;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }





    public void setAuthor(String author) {
        this.author = author;
    }


    public String bookDetail() {
        return "description: "+ this.description +",  price:" +this .price +",  publishedYear "+ publishedYear+",  pages:"+pages;
    }

    public String bookDetailByAuthor() {
        return "Title: " + this.title + ",   Author: " + this.author;
    }
}
