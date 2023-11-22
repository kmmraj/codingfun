package com.test.designpattern;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card with number " + cardNumber);
    }
}

// Concrete Strategy 2: PayPal Payment
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal with email " + email);
    }
}

// Context class that uses the strategy
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client code
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Client chooses the payment strategy dynamically
        PaymentStrategy creditCardStrategy = new CreditCardPayment("1234-5678-8765-4321");
        PaymentContext creditCardContext = new PaymentContext(creditCardStrategy);
        creditCardContext.processPayment(100);

        PaymentStrategy payPalStrategy = new PayPalPayment("user@example.com");
        PaymentContext payPalContext = new PaymentContext(payPalStrategy);
        payPalContext.processPayment(50);
    }
}
