package com.example.myapplicationtest2.Database;

/**
 * Created by 洋 on 2019/7/19.
 */

public class Book {
    private int id;
    private String author;
    private double price;


    public void setId(int id) {

        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
