# Strategy Pattern Exercise

A simple Java 21 exercise demonstrating the Strategy Design Pattern using discount strategies for a shopping cart.

## Overview

This exercise focuses on the core Strategy pattern mechanics without algorithmic complexity. Students learn how to:

- Define a strategy interface
- Implement concrete strategies with simple logic
- Use a context class to switch strategies at runtime
- See immediate, understandable results

## Project Structure

```
src/
├── main/java/com/example/strategy/
│   ├── DiscountStrategy.java      # Strategy interface
│   ├── PercentageDiscount.java    # 10% off strategy
│   ├── FixedAmountDiscount.java   # $X off strategy
│   ├── LoyaltyPointsDiscount.java # Points-based with accumulation
│   ├── Customer.java              # Simple customer with loyalty points
│   ├── ShoppingCart.java          # Context class
│   └── Main.java                  # Demo with multiple strategies
└── test/java/
    └── DiscountStrategyTest.java  # Unit tests

route-strategy/                    # Advanced example (route planning)
├── src/                          # Full implementation with GUI
├── pom.xml                       # Separate Maven project
└── README.md                     # Advanced strategy pattern demo
```

## Strategy Pattern Components

### 1. Strategy Interface
```java
public interface DiscountStrategy {
    double applyDiscount(double price);
    String getStrategyName();
}
```

### 2. Concrete Strategies
- **PercentageDiscount**: Simple percentage calculation
- **FixedAmountDiscount**: Subtract fixed amount (minimum $0)
- **LoyaltyPointsDiscount**: Earn points, redeem for discounts

### 3. Context Class
```java
public class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    public double calculateTotal() {
        return discountStrategy.applyDiscount(totalPrice);
    }
}
```

## Running the Exercise

### Prerequisites
- Java 21
- Maven 3.6+

### Build and Run
```bash
# Compile
mvn compile

# Run demo
mvn exec:java

# Run tests
mvn test
```

### Using Nix Shell
```bash
nix-shell
mvn compile && mvn exec:java
```

### Sample Output
```
=== Strategy Pattern Demo: Discount Strategies ===

Customer: Alice (0 points)

Added Laptop: $999.99
Added Mouse: $29.99

--- No Discount Strategy ---
=== CHECKOUT ===
Subtotal: $1029.98
Total: $1029.98
================

--- 10% Discount Strategy ---
=== CHECKOUT ===
Subtotal: $1029.98
Discount (10% Discount): -$103.00
Total: $926.98
================

--- Loyalty Points Strategy (First Purchase) ---
Customer before: Alice (0 points)
=== CHECKOUT ===
Subtotal: $1029.98
Total: $1029.98
================
Customer after: Alice (1029 points)

--- Loyalty Points Strategy (Second Purchase) ---
Customer before: Alice (1029 points)
=== CHECKOUT ===
Subtotal: $379.98
Discount (Loyalty Points): -$10.00
Total: $369.98
================
Customer after: Alice (1299 points)
```

## Key Learning Points

### Strategy Pattern Benefits
1. **Runtime Algorithm Selection**: Switch discount types without changing cart code
2. **Open/Closed Principle**: Easy to add new discount strategies
3. **Single Responsibility**: Each strategy handles one discount type
4. **Testability**: Strategies can be tested independently

### Why This Exercise Works
- **Simple Logic**: 1-3 lines per strategy implementation
- **Immediate Results**: See dollar amounts change with different strategies
- **Real-World Scenario**: Everyone understands shopping discounts
- **Progressive Complexity**: Simple → loyalty points → advanced route planning

## Exercise Ideas

1. **Add New Strategies**:
   - Student discount (with ID verification)
   - Buy-one-get-one discount
   - Seasonal discount with date checking

2. **Extend Loyalty Points**:
   - Different point earning rates for different customer tiers
   - Multiple redemption levels (50 points = $5, 100 points = $12)

3. **Strategy Combination**:
   - Apply multiple discounts in sequence
   - Choose best discount for customer

4. **Configuration**:
   - Load discount rules from properties file
   - Admin interface to modify discount parameters

## Advanced Example

For a more complex Strategy pattern demonstration with algorithms and GUI visualization, see the `route-strategy/` directory which contains a complete route planning application.

## Code Quality Features

- **Java 21**: Modern Java features
- **Clean Code**: Simple, readable implementations
- **Comprehensive Tests**: Unit tests for all strategies
- **Exercise-First**: Focus on pattern mechanics, not complex domain logic