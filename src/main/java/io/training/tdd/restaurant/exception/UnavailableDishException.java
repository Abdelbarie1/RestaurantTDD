package io.training.tdd.restaurant.exception;

public class UnavailableDishException extends Exception{

    public UnavailableDishException(String message) {
        super(message);
    }
}
