package org.parkinglot.paymet;

import org.parkinglot.modal.PaymentMode;
import org.parkinglot.modal.PaymentSlip;

public interface PaymentGateway {
    PaymentSlip processPayment(int amount);

    boolean canHandle(PaymentMode mode);
}
