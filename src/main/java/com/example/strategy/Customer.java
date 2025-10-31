package com.example.strategy;

public class Customer {
    private String name;
    private int loyaltyPoints;

    public Customer(String name, int loyaltyPoints) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        assert points >= 0;
        this.loyaltyPoints += points;
    }

    public boolean spendLoyaltyPoints(int points) {
        if (loyaltyPoints >= points) {
            loyaltyPoints -= points;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s (%d points)", name, loyaltyPoints);
    }
}