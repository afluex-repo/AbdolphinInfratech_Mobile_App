package com.abdolphininfratech.Model.responseNews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNews {

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
    private List<Lstnewsdetail> lstnewsdetail = null;
    @SerializedName("lstassociate")
    @Expose
    private String lstassociate;

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

    public List<Lstnewsdetail> getLstnewsdetail() {
        return lstnewsdetail;
    }

    public void setLstnewsdetail(List<Lstnewsdetail> lstnewsdetail) {
        this.lstnewsdetail = lstnewsdetail;
    }

    public String getLstassociate() {
        return lstassociate;
    }

    public void setLstassociate(String lstassociate) {
        this.lstassociate = lstassociate;
    }

}
