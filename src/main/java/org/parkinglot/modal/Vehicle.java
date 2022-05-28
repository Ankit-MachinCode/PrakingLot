package org.parkinglot.modal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Vehicle {
    String licenseNumber;
    Type type;
}
