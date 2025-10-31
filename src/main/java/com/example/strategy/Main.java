package com.example.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Shopping Cart Demo (Before Strategy Pattern Refactoring) ===\n");

        ShoppingCart cart = new ShoppingCart(new NoDiscount());

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        System.out.println("\n--- No Discount ---");
        cart.checkout();

        cart.addItem("Laptop", 999.99);
        cart.addItem("Mouse", 29.99);

        double total = cart.calculateTotal();
        System.out.println("Pris uden rabat: " + total);

        cart.changeDiscount(new PercentageDiscount(0.10));
        double percentageTotal = cart.calculateTotal();
        System.out.println("Pris med 10% rabat: " + percentageTotal);

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