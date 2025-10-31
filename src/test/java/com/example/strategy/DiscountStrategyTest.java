package com.example.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountStrategyTest {

    @Test
    void testPercentageDiscount() {
        DiscountStrategy strategy = new PercentageDiscount(10);
        assertEquals(90.0, strategy.applyDiscount(100.0), 0.01);
        assertEquals("10% Discount", strategy.getStrategyName());
    }

    @Test
    void testFixedAmountDiscount() {
        DiscountStrategy strategy = new FixedAmountDiscount(15.0);
        assertEquals(85.0, strategy.applyDiscount(100.0), 0.01);
        assertEquals(0.0, strategy.applyDiscount(10.0), 0.01);
        assertEquals("$15.00 Off", strategy.getStrategyName());
    }

    @Test
    void testLoyaltyPointsDiscount() {
        Customer customer = new Customer("Test", 0);
        DiscountStrategy strategy = new LoyaltyPointsDiscount(customer);

        double result1 = strategy.applyDiscount(50.0);
        assertEquals(50.0, result1, 0.01);
        assertEquals(50, customer.getLoyaltyPoints());

        double result2 = strategy.applyDiscount(60.0);
        assertEquals(50.0, result2, 0.01);
        assertEquals(10, customer.getLoyaltyPoints());
    }

    @Test
    void testShoppingCartWithStrategies() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Test Item", 100.0);

        cart.setDiscountStrategy(new PercentageDiscount(20));
        assertEquals(80.0, cart.calculateTotal(), 0.01);

        cart.setDiscountStrategy(new FixedAmountDiscount(25));
        assertEquals(75.0, cart.calculateTotal(), 0.01);
    }
}