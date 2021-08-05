package com.mypractice.buffer;

import com.github.javafaker.Book;
import com.mypractice.util.Util;

public class BookOrder {
    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder(){
        Book book = Util.faker().book();
        author = book.title();
        category = book.genre();
        price = Double.parseDouble(Util.faker().commerce().price());
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
