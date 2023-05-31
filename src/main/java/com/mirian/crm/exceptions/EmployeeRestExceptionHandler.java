package com.mirian.crm.exceptions;

import com.mirian.crm.model.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeIdNotFoundException(EmployeeIdNotFoundException employeeIdNotFoundException) {
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(employeeIdNotFoundException.getMessage());
        employeeErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeExceptions(Exception exception) {
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage("BAD REQUEST");
        employeeErrorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
