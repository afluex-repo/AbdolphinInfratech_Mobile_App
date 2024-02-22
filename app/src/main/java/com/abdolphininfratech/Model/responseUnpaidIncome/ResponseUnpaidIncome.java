package com.abdolphininfratech.Model.responseUnpaidIncome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseUnpaidIncome {


    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("FromID")
    @Expose
    private String fromID;
    @SerializedName("ToID")
    @Expose
    private String toID;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("lstunpaid")
    @Expose
    private List<Lstunpaid> lstunpaid = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Lstunpaid> getLstunpaid() {
        return lstunpaid;
    }

    public void setLstunpaid(List<Lstunpaid> lstunpaid) {
        this.lstunpaid = lstunpaid;
    }

}
