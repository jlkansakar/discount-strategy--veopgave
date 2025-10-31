package com.example.strategy;

public class ShoppingCart {
    private DiscountStrategy discountStrategy;
    private double totalPrice;

    public ShoppingCart() {
        this.totalPrice = 0.0;
    }

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public void addItem(String itemName, double price) {
        System.out.printf("Added %s: $%.2f%n", itemName, price);
        totalPrice += price;
    }

    public double calculateTotal() {
        if (discountStrategy == null) {
            return totalPrice;
        }
        return discountStrategy.applyDiscount(totalPrice);
    }

    public void checkout() {
        double originalTotal = totalPrice;
        double finalTotal = calculateTotal();
        double savedAmount = originalTotal - finalTotal;

        System.out.println("\n=== CHECKOUT ===");
        System.out.printf("Subtotal: $%.2f%n", originalTotal);

        if (discountStrategy != null) {
            System.out.printf("Discount (%s): -$%.2f%n",
                    discountStrategy.getStrategyName(), savedAmount);
        }

        System.out.printf("Total: $%.2f%n", finalTotal);
        System.out.println("================\n");

        totalPrice = 0.0;
    }

    public String getDiscountStrategyName() {
        return discountStrategy != null ? discountStrategy.getStrategyName() : "No discount";
    }
}