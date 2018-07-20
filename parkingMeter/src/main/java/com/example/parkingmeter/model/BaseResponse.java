package com.example.parkingmeter.model;

public class BaseResponse {
    private Boolean IsSuccessful;
    private String Message;

    public Boolean getSuccessful() {
        return IsSuccessful;
    }

    public void setSuccessful(Boolean successful) {
        IsSuccessful = successful;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
