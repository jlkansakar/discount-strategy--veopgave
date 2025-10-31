package com.example.strategy;

public class ShoppingCart {
    private double totalPrice;
    private DiscountStrategy DiscountStrategy;

    public ShoppingCart(DiscountStrategy DiscountStrategy) {
        this.totalPrice = 0.0;
        this.DiscountStrategy = DiscountStrategy;
    }

    public void changeDiscount(DiscountStrategy DiscountStrategy) {

    }

    public void addItem(String itemName, double price) {
        System.out.printf("Added %s: $%.2f%n", itemName, price);
        totalPrice += price;
    }

    /* 
    public double applyDiscount(double price, String discountType, double discountValue) {
        switch (discountType.toLowerCase()) {
            case "percentage":
                return price * (1 - discountValue / 100);
            case "fixed":
                return Math.max(0, price - discountValue);
            case "none":
            default:
                return price;
        }
    }
    */
    */

    public double calculateTotal() {
        return this.DiscountStrategy.applyDiscount(totalPrice);
    }

    public void checkout() {
        double originalTotal = totalPrice;
        double finalTotal = calculateTotal();

        System.out.println("\n=== CHECKOUT ===");
        System.out.printf("Subtotal: $%.2f%n", originalTotal);
        System.out.printf("Total: $%.2f%n", finalTotal);
        System.out.println("================\n");

        totalPrice = 0.0;
    }
}