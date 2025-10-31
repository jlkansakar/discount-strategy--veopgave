package com.example.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Demo: Discount Strategies ===\n");

        Customer alice = new Customer("Alice", 0);
        ShoppingCart cart = new ShoppingCart();

        System.out.println("Customer: " + alice);
        System.out.println();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("\n--- No Discount Strategy ---");
        cart.checkout();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("--- 10% Discount Strategy ---");
        cart.setDiscountStrategy(new PercentageDiscount(10));
        cart.checkout();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("--- $50 Fixed Discount Strategy ---");
        cart.setDiscountStrategy(new FixedAmountDiscount(50));
        cart.checkout();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("--- Loyalty Points Strategy (First Purchase) ---");
        System.out.println("Customer before: " + alice);
        cart.setDiscountStrategy(new LoyaltyPointsDiscount(alice));
        cart.checkout();
        System.out.println("Customer after: " + alice);

        cart.addItem("Keyboard", 79.99);
        cart.addItem("Monitor", 299.99);

        System.out.println("--- Loyalty Points Strategy (Second Purchase) ---");
        System.out.println("Customer before: " + alice);
        cart.setDiscountStrategy(new LoyaltyPointsDiscount(alice));
        cart.checkout();
        System.out.println("Customer after: " + alice);

        System.out.println("\n=== Strategy Switching Demo ===");
        cart.addItem("Headphones", 199.99);

        System.out.println("Current strategy: " + cart.getDiscountStrategyName());
        System.out.printf("Total with current strategy: $%.2f%n", cart.calculateTotal());

        cart.setDiscountStrategy(new PercentageDiscount(15));
        System.out.println("Switched to: " + cart.getDiscountStrategyName());
        System.out.printf("Total with new strategy: $%.2f%n", cart.calculateTotal());

        cart.setDiscountStrategy(new FixedAmountDiscount(25));
        System.out.println("Switched to: " + cart.getDiscountStrategyName());
        System.out.printf("Total with new strategy: $%.2f%n", cart.calculateTotal());
    }
}