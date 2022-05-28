package org.parkinglot.modal;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PaymentSlip extends Slip {
    UUID paymentId;
    int amount;
    PaymentStatus status;
    PaymentMode paymentMode;
    LocalDateTime processTime;
}
