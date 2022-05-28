package org.parkinglot.exception;

public class ParkingSpotNotAvailable extends  RuntimeException{

    public ParkingSpotNotAvailable(){
        System.err.println("Parking Spot not Available");
    }
}
