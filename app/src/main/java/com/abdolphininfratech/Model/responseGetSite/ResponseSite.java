package com.abdolphininfratech.Model.responseGetSite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSite {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("lstsite")
    @Expose
    private List<Lstsite> lstsite = null;

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

    public List<Lstsite> getLstsite() {
        return lstsite;
    }

    public void setLstsite(List<Lstsite> lstsite) {
        this.lstsite = lstsite;
    }
}
