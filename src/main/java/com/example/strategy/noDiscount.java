package com.example.strategy;

public class NoDiscount implements DiscountStrategy {
    
    public double applyDiscount(double price) {
        return price;
    }

    public String getStrategyName() {
        return "No Discount";
    }
}