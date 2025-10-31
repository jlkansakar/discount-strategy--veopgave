package com.example.strategy;

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price * (1 - percentage / 100);
    }

    @Override
    public String getStrategyName() {
        return String.format("%.0f%% Discount", percentage);
    }
}