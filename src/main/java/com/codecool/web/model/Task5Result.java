package com.codecool.web.model;

import java.text.DecimalFormat;

public class Task5Result {
    private String company;
    private String product;
    private double price;

    public Task5Result(String company, String product, double price) {
        this.company = company;
        this.product = product;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }
}
