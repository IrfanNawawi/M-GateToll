package com.example.irfannawawi.mygatetollapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTol {

    @SerializedName("tol")
    private List<TolItem> tol;

    @SerializedName("status")
    private boolean status;

    public List<TolItem> getTol() {
        return tol;
    }

    public void setTol(List<TolItem> tol) {
        this.tol = tol;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "ResponseTol{" +
                        "tol = '" + tol + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}