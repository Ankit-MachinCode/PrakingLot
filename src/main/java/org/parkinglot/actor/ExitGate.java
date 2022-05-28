package org.parkinglot.actor;

import org.parkinglot.exception.PaymentModeNotFoundException;
import org.parkinglot.modal.ParkingSlip;
import org.parkinglot.modal.PaymentMode;
import org.parkinglot.modal.PaymentSlip;
import org.parkinglot.paymet.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ExitGate extends Gate {
    List<PaymentGateway> paymentGatewayList;

    public ExitGate( List<PaymentGateway> paymentGatewayList) {
        this.paymentGatewayList = paymentGatewayList;
    }

    public int getParkingAmount(ParkingSlip parkingSlip) {
        long timeSpentInHours =
                Duration.between(LocalDateTime.now(), parkingSlip.getEntryTime()).get(ChronoUnit.HOURS);

        return PricingEngine.getPrice(parkingSlip.getSpot().getType())
                        * (Long.valueOf(timeSpentInHours).intValue() + 1);
    }

    public PaymentSlip processPayment(ParkingSlip parkingSlip, PaymentMode mode) {

        PaymentGateway paymentGateway = paymentGatewayList.stream().filter(gateway -> gateway.canHandle(mode))
                .findAny().orElseThrow(PaymentModeNotFoundException::new);
        return paymentGateway.processPayment(getParkingAmount(parkingSlip));
    }
}
