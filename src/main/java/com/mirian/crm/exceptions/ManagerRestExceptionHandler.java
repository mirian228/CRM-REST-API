package com.mirian.crm.exceptions;

import com.mirian.crm.model.Manager;
import com.mirian.crm.model.ManagerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManagerRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ManagerErrorResponse> handleManagerIdNotFoundException(ManagerIdNotFoundException managerIdNotFoundException) {
        ManagerErrorResponse managerErrorResponse = new ManagerErrorResponse();
        managerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        managerErrorResponse.setMessage(managerIdNotFoundException.getMessage());
        managerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(managerErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ManagerErrorResponse> handleGlobalManagerException(Exception exception) {
        ManagerErrorResponse managerErrorResponse = new ManagerErrorResponse();
        managerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        managerErrorResponse.setMessage("BAD REQUEST");
        managerErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(managerErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
