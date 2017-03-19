package com.mysamples.spark;

public enum StatusResponse {
    ERROR("Error"), SUCCESS("Success");

    final private String status;

    StatusResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
