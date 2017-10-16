package com.caogen.spiderWeb.dto;

public class SpiderResult<T> {

    private boolean success;

    private T data;

    private String error;

    public SpiderResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public SpiderResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SpiderResult{" +
                "success=" + success +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}
