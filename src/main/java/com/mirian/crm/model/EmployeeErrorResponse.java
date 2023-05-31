package com.mirian.crm.model;

import java.util.Objects;

public class EmployeeErrorResponse {
    private int status;
    private String message;

    private long timeStamp;

    public EmployeeErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public EmployeeErrorResponse() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeErrorResponse that = (EmployeeErrorResponse) o;
        return timeStamp == that.timeStamp && Objects.equals(status, that.status) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, timeStamp);
    }

    @Override
    public String toString() {
        return "EmployeeErrorResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
