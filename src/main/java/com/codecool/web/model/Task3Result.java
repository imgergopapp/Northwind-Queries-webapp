package com.codecool.web.model;

public class Task3Result {
    private String company;
    private int numberOfProducts;

    public Task3Result(String company, int numberOfProducts) {
        this.company = company;
        this.numberOfProducts = numberOfProducts;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

}
