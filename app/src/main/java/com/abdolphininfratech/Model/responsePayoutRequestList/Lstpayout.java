package com.abdolphininfratech.Model.responsePayoutRequestList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstpayout {

    @SerializedName("RequestID")
    @Expose
    private String requestID;
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
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("DisplayName")
    @Expose
    private String displayName;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
