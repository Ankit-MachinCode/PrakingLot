package org.parkinglot.paymet;

import org.parkinglot.modal.PaymentMode;
import org.parkinglot.modal.PaymentSlip;
import org.parkinglot.modal.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class UPIPaymentGateway implements PaymentGateway {
    @Override
    public PaymentSlip processPayment(int amount) {
        System.out.println("Processing payment of " + amount + "rs. using UPIPaymentGateway");
        return PaymentSlip.builder()
                .paymentId(UUID.randomUUID())
                .amount(amount)
                .status(PaymentStatus.COMPLETED)
                .processTime(LocalDateTime.now())
                .build();
    }

    @Override
    public boolean canHandle(PaymentMode mode) {
        return mode.equals(PaymentMode.UPI);
    }
}
