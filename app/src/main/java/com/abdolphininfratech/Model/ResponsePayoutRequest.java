package com.abdolphininfratech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePayoutRequest {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("Balance")
    @Expose
    private String balance;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
