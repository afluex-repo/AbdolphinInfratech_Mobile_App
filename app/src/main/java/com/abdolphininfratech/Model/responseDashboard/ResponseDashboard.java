package com.abdolphininfratech.Model.responseDashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDashboard {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("AssociateID")
    @Expose
    private String associateID;
    @SerializedName("lstdueinstallment")
    @Expose
    private String lstdueinstallment;
    @SerializedName("lstnewsdetail")
    @Expose
    private String lstnewsdetail;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("lstassociate")
    @Expose
    private List<Lstassociate> lstassociate = null;

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

    public String getAssociateID() {
        return associateID;
    }

    public void setAssociateID(String associateID) {
        this.associateID = associateID;
    }

    public String getLstdueinstallment() {
        return lstdueinstallment;
    }

    public void setLstdueinstallment(String lstdueinstallment) {
        this.lstdueinstallment = lstdueinstallment;
    }

    public String getLstnewsdetail() {
        return lstnewsdetail;
    }

    public void setLstnewsdetail(String lstnewsdetail) {
        this.lstnewsdetail = lstnewsdetail;
    }

    public List<Lstassociate> getLstassociate() {
        return lstassociate;
    }

    public void setLstassociate(List<Lstassociate> lstassociate) {
        this.lstassociate = lstassociate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
