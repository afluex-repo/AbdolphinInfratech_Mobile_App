package com.abdolphininfratech.Model.responseEnquryList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstBlock1 {

    @SerializedName("EnquiryID")
    @Expose
    private String enquiryID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Details")
    @Expose
    private String details;

    public String getEnquiryID() {
        return enquiryID;
    }

    public void setEnquiryID(String enquiryID) {
        this.enquiryID = enquiryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
