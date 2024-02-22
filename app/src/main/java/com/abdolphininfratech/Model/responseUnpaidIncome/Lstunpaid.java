package com.abdolphininfratech.Model.responseUnpaidIncome;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstunpaid {

    @SerializedName("FromID")
    @Expose
    private String fromID;
    @SerializedName("FromName")
    @Expose
    private String fromName;
    @SerializedName("ToID")
    @Expose
    private String toID;
    @SerializedName("ToName")
    @Expose
    private String toName;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("Income")
    @Expose
    private String income;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("DifferencePercentage")
    @Expose
    private String differencePercentage;

    public String getFromID() {
        return fromID;
    }

    public void setFromID(String fromID) {
        this.fromID = fromID;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToID() {
        return toID;
    }

    public void setToID(String toID) {
        this.toID = toID;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
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

    public String getDifferencePercentage() {
        return differencePercentage;
    }

    public void setDifferencePercentage(String differencePercentage) {
        this.differencePercentage = differencePercentage;
    }
}
