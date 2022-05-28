package org.parkinglot.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSpot {
    private int spotId;
    private Type type;
}
