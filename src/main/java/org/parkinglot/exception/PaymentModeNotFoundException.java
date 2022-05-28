package org.parkinglot.exception;

public class PaymentModeNotFoundException extends RuntimeException {
    public PaymentModeNotFoundException() {
        System.err.println("PaymentModeNotFoundException thrown");
    }
}
