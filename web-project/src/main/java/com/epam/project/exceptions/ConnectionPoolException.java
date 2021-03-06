package com.epam.project.exceptions;

public class ConnectionPoolException extends RuntimeException {
    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException() {}
}
