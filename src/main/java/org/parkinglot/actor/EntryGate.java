package org.parkinglot.actor;

import org.parkinglot.exception.ParkingSpotNotAvailable;
import org.parkinglot.modal.ParkingSlip;
import org.parkinglot.modal.ParkingSpot;
import org.parkinglot.modal.Vehicle;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public class EntryGate extends Gate {

    public ParkingSlip generateParkingTicket(Vehicle vehicle, Optional<ParkingSpot> parkingSpot) {

        return ParkingSlip.builder()
                .ticketId(UUID.randomUUID())
                .spot(parkingSpot.orElseThrow(ParkingSpotNotAvailable::new))
                .vehicle(vehicle)
                .entryTime(LocalDateTime.now()).build();
    }


}
