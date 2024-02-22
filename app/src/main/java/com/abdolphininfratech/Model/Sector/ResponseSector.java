package com.abdolphininfratech.Model.Sector;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSector {


    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("SiteID")
    @Expose
    private String siteID;
    @SerializedName("lstsite")
    @Expose
    private List<LstSector> lstsite = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public List<LstSector> getLstsite() {
        return lstsite;
    }

    public void setLstsite(List<LstSector> lstsite) {
        this.lstsite = lstsite;
    }

}
