package com.epam.mp.exception;

public class GetFromPoolException extends RuntimeException {

    public GetFromPoolException() {
        super();
    }

    public GetFromPoolException(String message) {
        super(message);
    }
}
