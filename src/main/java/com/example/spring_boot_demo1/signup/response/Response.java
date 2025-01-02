package com.example.spring_boot_demo1.signup.response;

public class Response<T>  {
    private String message;
    private T data;
    private boolean success;
    private int statusCode;

    public Response(String message, T data, boolean success, int statusCode) {
        this.message = message;
        this.data = data;
        this.success = success;
        this.statusCode = statusCode;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}