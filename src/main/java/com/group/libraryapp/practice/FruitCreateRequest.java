package com.group.libraryapp.practice;

import java.time.LocalDate;

public class FruitCreateRequest {

    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}