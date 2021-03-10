package com.webDevelopment.solid.models;

public class Book {
    private String title;
    private String author;
    private Integer publishedYear;
    private Double price;

    public Book(String title, String author, Integer publishedYear, Double price) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
    }

    public String createBookCard()
    {
        return "The book " + this.title + " has benn written by " + this.author + " and was " +
                "published in " + this.publishedYear + ". The book's price is " + this.price;
    }
}
