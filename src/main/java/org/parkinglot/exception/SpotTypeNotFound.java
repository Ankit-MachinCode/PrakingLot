package org.parkinglot.exception;

public class SpotTypeNotFound extends RuntimeException {
    public SpotTypeNotFound() {
        System.err.println("SpotTypeNotFound thrown");
    }
}
