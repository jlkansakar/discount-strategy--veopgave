package com.example.strategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }

    @Override
    public String getStrategyName() {
        return "No Discount";
    }
}
