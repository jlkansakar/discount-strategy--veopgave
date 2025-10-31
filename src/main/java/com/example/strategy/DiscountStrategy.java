package com.example.strategy;

public interface DiscountStrategy {
    double applyDiscount(double price);
    String getStrategyName();
}