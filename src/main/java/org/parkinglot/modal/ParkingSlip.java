package org.parkinglot.modal;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ParkingSlip extends Slip {
    private UUID ticketId;
    private ParkingSpot spot;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
}
