package com.mirian.crm.exceptions;

public class ManagerIdNotFoundException extends RuntimeException {

    public ManagerIdNotFoundException(String message) {
        super(message);
    }

    public ManagerIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManagerIdNotFoundException(Throwable cause) {
        super(cause);
    }
}
