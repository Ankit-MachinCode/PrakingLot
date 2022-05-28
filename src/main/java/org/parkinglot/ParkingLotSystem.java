package org.parkinglot;

import org.parkinglot.actor.EntryGate;
import org.parkinglot.actor.ExitGate;
import org.parkinglot.modal.ParkingSpot;
import org.parkinglot.modal.Type;
import org.parkinglot.modal.Vehicle;
import org.parkinglot.paymet.CashPaymentGateway;
import org.parkinglot.paymet.CreditCardPaymentGateway;
import org.parkinglot.paymet.UPIPaymentGateway;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import static org.parkinglot.modal.Type.FourWheler;
import static org.parkinglot.modal.Type.TwoWheler;

public class ParkingLotSystem {

    Stack<ParkingSpot> twoWhelerSpots;
    Stack<ParkingSpot> fourWhelerSpots;
    Stack<ParkingSpot> truckSpots;
    EntryGate entryGate;
    ExitGate exitGate;

    {
        exitGate = new ExitGate(List.of(new CashPaymentGateway(), new CreditCardPaymentGateway(), new UPIPaymentGateway()));
        entryGate = new EntryGate();
        twoWhelerSpots = new Stack<>();
        twoWhelerSpots.push(ParkingSpot.builder().spotId(1).type(TwoWheler).build());
        twoWhelerSpots.push(ParkingSpot.builder().spotId(2).type(TwoWheler).build());
        twoWhelerSpots.push(ParkingSpot.builder().spotId(3).type(TwoWheler).build());
        twoWhelerSpots.push(ParkingSpot.builder().spotId(4).type(TwoWheler).build());


        fourWhelerSpots = new Stack<>();
        fourWhelerSpots.push(ParkingSpot.builder().spotId(1).type(FourWheler).build());
        fourWhelerSpots.push(ParkingSpot.builder().spotId(2).type(FourWheler).build());
        fourWhelerSpots.push(ParkingSpot.builder().spotId(3).type(FourWheler).build());
        fourWhelerSpots.push(ParkingSpot.builder().spotId(4).type(FourWheler).build());

        truckSpots = new Stack<>();

    }


    public static void main(String[] args) {
        ParkingLotSystem system = new ParkingLotSystem();
        system.entryGate.generateParkingTicket(Vehicle.builder().licenseNumber("ABC").type(TwoWheler).build(), system.getParkingSpot(TwoWheler));
        system.entryGate.generateParkingTicket(Vehicle.builder().licenseNumber("ABC").type(TwoWheler).build(), system.getParkingSpot(TwoWheler));
        system.entryGate.generateParkingTicket(Vehicle.builder().licenseNumber("ABC").type(TwoWheler).build(), system.getParkingSpot(TwoWheler));
        system.entryGate.generateParkingTicket(Vehicle.builder().licenseNumber("ABC").type(FourWheler).build(), system.getParkingSpot(FourWheler));
        system.entryGate.generateParkingTicket(Vehicle.builder().licenseNumber("ABC").type(FourWheler).build(), system.getParkingSpot(FourWheler));
    }

    Optional<ParkingSpot> getParkingSpot(Type type) {
        switch (type) {
            case Truck:
                return Optional.ofNullable(truckSpots.size() > 0 ? truckSpots.pop() : null);
            case TwoWheler:
                return Optional.ofNullable(twoWhelerSpots.size() > 0 ? twoWhelerSpots.pop() : null);
            case FourWheler:
                return Optional.ofNullable(fourWhelerSpots.size() > 0 ? fourWhelerSpots.pop() : null);
            default:
                throw new RuntimeException();
        }
    }

}
