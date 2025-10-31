package com.example.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Shopping Cart Demo (Before Strategy Pattern Refactoring) ===\n");

        ShoppingCart cart = new ShoppingCart(new NoDiscount());
        ShoppingCart cart = new ShoppingCart(new NoDiscount());

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("\n--- No Discount ---");
        cart.checkout();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("Pris uden rabat");
    
        double total = cart.calculateTotal();

        System.out.println("Pris med 10% rabat");

        cart.changeDiscount(new Percentage(0.10));
        double percentageTotal = cart.calculateTotal();
        cart.checkout();

        System.out.println("Pris med flad rabat");

        cart.changeDiscount(new FlatDiscount(700));
        double flatRateTotal = cart.calculateTotal();
        cart.checkout();


        double discountedTotal = cart.applyDiscount(total, "percentage", 10);
        System.out.printf("Original Total: $%.2f%n", total);
        System.out.printf("With 10%% discount: $%.2f%n", discountedTotal);
        cart.checkout();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        cart.checkout();

        System.out.println("\n=== Nuværende Problemer ===");
        System.out.println("1. Rabatlogik er blandet sammen med indkøbskurv logik");
        System.out.println("2. Tilføjelse af nye rabattyper kræver ændring af ShoppingCart");
        System.out.println("3. Kan ikke nemt skifte rabatstrategier ved runtime");
        System.out.println("4. Svært at teste rabatlogik uafhængigt");
        System.out.println("\nTODO: Refaktorer til at bruge Strategy Pattern!");
    }
}