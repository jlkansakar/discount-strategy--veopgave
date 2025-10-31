package com.example.strategy;

public class FlatDiscount implements DiscountStrategy {
    private double rate;

    public FlatDiscount(double rate) {
        assert rate >= 0;
        assert rate <= price;
        this.rate = rate;
    }

    @Override
    public double applyDiscount(double price) {
        if (price - rate) > 0 {
            return price - rate;
        }
        else {
            System.out.println("Rabat kan ikke reducere pris til under 0");
        }
    }

    @Override
    public String getStrategyName() {
        return "Flat Rate Discount";
    }
}