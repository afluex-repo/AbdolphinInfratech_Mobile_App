package com.abdolphininfratech.Model.responsePayoutDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstpayout {

    @SerializedName("PayOutNo")
    @Expose
    private String payOutNo;
    @SerializedName("ClosingDate")
    @Expose
    private String closingDate;
    @SerializedName("AssociateLoginID")
    @Expose
    private String associateLoginID;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("GrossAmount")
    @Expose
    private String grossAmount;
    @SerializedName("TDS")
    @Expose
    private String tds;
    @SerializedName("Processing")
    @Expose
    private String processing;
    @SerializedName("NetAmount")
    @Expose
    private String netAmount;

    public String getPayOutNo() {
        return payOutNo;
    }

    public void setPayOutNo(String payOutNo) {
        this.payOutNo = payOutNo;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getAssociateLoginID() {
        return associateLoginID;
    }

    public void setAssociateLoginID(String associateLoginID) {
        this.associateLoginID = associateLoginID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(String grossAmount) {
        this.grossAmount = grossAmount;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

}
