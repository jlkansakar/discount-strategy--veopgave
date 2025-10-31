package com.example.strategy;

public class PercentageDiscount implements DiscountStrategy {
    private double percentage;

    public PercentageDiscount(double percentage) {
        assert percentage >= 0;
        assert percentage <= 1;
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * this.percentage;
    }

    public String getStrategyName() {
        return "Percentage Discount";
    }
}