package com.mysamples.spark;

import com.google.gson.JsonElement;

public class StandardResponse {
    private StatusResponse status;
    private String message;
    private JsonElement data;

    public StandardResponse(StatusResponse status) {
        this.status = status;
    }

    public StandardResponse(StatusResponse status, String msg) {
        this.status = status;
        this.message = msg;
    }

    public StandardResponse(StatusResponse status, JsonElement data) {
        this.status = status;
        this.data = data;
    }

    public StatusResponse getStatus() {
        return status;
    }

    public void setStatus(StatusResponse status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}
