package com.example.strategy;

public class LoyaltyPointDiscount implements DiscountStrategy {
    private Customer customer;
    private static double CONVERSION = 0.06;
    private static double MY_COST = 25;

    public LoyaltyPointDiscount(Customer customer) {
        this.customer = customer;
    } 

    @Override
    public double applyDiscount(double price) {
        double afterDiscount = price - customer.getLoyaltyPoints() * CONVERSION;
        return Math.max(afterDiscount, 0);
    }

    @Override
    public String getStrategyName() {
        return "";
    }

}