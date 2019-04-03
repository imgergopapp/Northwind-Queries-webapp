package com.codecool.web.model;

public class Task2Result {
    private String company;
    private int numberOfProducts;

    public Task2Result(String company, int numberOfProducts) {
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
