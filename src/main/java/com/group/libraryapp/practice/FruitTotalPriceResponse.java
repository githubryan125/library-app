package com.group.libraryapp.practice;

public class FruitTotalPriceResponse {
    private final long salesAmount;
    private final long notSalesAmount;

    public FruitTotalPriceResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }
}