package com.abdolphininfratech.Model.SiteType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSiteType {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("lstsitetype")
    @Expose
    private List<Lstsitetype> lstsitetype = null;

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

    public List<Lstsitetype> getLstsitetype() {
        return lstsitetype;
    }

    public void setLstsitetype(List<Lstsitetype> lstsitetype) {
        this.lstsitetype = lstsitetype;
    }
}
