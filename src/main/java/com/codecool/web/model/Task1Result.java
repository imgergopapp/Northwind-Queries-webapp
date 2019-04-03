package com.codecool.web.model;

public class Task1Result {
    private String product;
    private String company;

    public Task1Result(String product, String company) {
        this.product = product;
        this.company = company;

    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }

}
