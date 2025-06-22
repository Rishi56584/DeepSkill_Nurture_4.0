package adapter;

interface PaymentProcessor {
    void processPayment(double amount);
}

class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Stripe.");
    }
}

class PayPalGateway {
    public void sendPayPalPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;
    public StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }
    public void processPayment(double amount) {
        stripe.makeStripePayment(amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;
    public PayPalAdapter(PayPalGateway paypal) {
        this.paypal = paypal;
    }
    public void processPayment(double amount) {
        paypal.sendPayPalPayment(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor stripePayment = new StripeAdapter(new StripeGateway());
        stripePayment.processPayment(1500);

        PaymentProcessor paypalPayment = new PayPalAdapter(new PayPalGateway());
        paypalPayment.processPayment(2500);
    }
}

