package com.abdolphininfratech.Model.UploadKycList;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;


public class ResUploadKycList {
    @SerializedName("UserID")
    public Object userID;
    @SerializedName("Message")
    public String message;
    @SerializedName("Status")
    public String status;
    public ArrayList<LstKycdocument> lstKycdocuments;

    public ResUploadKycList(Object userID, String message, String status, ArrayList<LstKycdocument> lstKycdocuments) {
        this.userID = userID;
        this.message = message;
        this.status = status;
        this.lstKycdocuments = lstKycdocuments;
    }

    public Object getUserID() {
        return userID;
    }

    public void setUserID(Object userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<LstKycdocument> getLstKycdocuments() {
        return lstKycdocuments;
    }

    public void setLstKycdocuments(ArrayList<LstKycdocument> lstKycdocuments) {
        this.lstKycdocuments = lstKycdocuments;
    }
}
