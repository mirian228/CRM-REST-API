package com.mirian.crm.exceptions;

public class EmployeeIdNotFoundException extends RuntimeException {
    public EmployeeIdNotFoundException(String message) {
        super(message);
    }

    public EmployeeIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeIdNotFoundException(Throwable cause) {
        super(cause);
    }

}
