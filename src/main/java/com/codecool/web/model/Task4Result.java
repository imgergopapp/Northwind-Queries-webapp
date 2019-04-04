package com.codecool.web.model;

import java.util.List;

public class Task4Result {
    private String company;
    private List<Short> orders;

    public Task4Result(String company, List<Short> orders) {
        this.company = company;
        this.orders = orders;
    }

    public Task4Result(String company) {
        this.company = company;
    }


    public String getCompany() {
        return company;
    }

    public List<Short> getOrders() {
        return orders;
    }

}
