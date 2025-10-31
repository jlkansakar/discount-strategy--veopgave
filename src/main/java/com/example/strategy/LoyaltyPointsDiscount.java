package com.example.strategy;

public class LoyaltyPointsDiscount implements DiscountStrategy {
    private final Customer customer;
    private final int pointsPerDollar;
    private final int pointsToRedeem;
    private final double discountAmount;

    public LoyaltyPointsDiscount(Customer customer) {
        this.customer = customer;
        this.pointsPerDollar = 1;
        this.pointsToRedeem = 100;
        this.discountAmount = 10.0;
    }

    @Override
    public double applyDiscount(double price) {
        int pointsToEarn = (int) (price * pointsPerDollar);
        customer.addLoyaltyPoints(pointsToEarn);

        if (customer.getLoyaltyPoints() >= pointsToRedeem) {
            if (customer.spendLoyaltyPoints(pointsToRedeem)) {
                return Math.max(0, price - discountAmount);
            }
        }

        return price;
    }

    @Override
    public String getStrategyName() {
        return String.format("Loyalty Points (Earn %d/$ spent, Redeem %d points for $%.2f off)",
                pointsPerDollar, pointsToRedeem, discountAmount);
    }
}