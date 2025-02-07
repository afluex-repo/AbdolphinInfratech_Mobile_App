package com.abdolphininfratech.Model.AssociateDownline;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;



public class ResponseAssociateDownline {
    @SerializedName("Status")
    public String status;
    @SerializedName("Message")
    public String message;
    @SerializedName("Fk_UserId")
    public String fk_UserId;
    @SerializedName("AssociateID")
    public String associateID;
    @SerializedName("FromDate")
    public Object fromDate;
    @SerializedName("ToDate")
    public Object toDate;
    public ArrayList<LstAssociateDownLine> lstAssociateDownLine;

    public ResponseAssociateDownline(String status, String message, String fk_UserId, String associateID, Object fromDate, Object toDate, ArrayList<LstAssociateDownLine> lstAssociateDownLine) {
        this.status = status;
        this.message = message;
        this.fk_UserId = fk_UserId;
        this.associateID = associateID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.lstAssociateDownLine = lstAssociateDownLine;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFk_UserId() {
        return fk_UserId;
    }

    public void setFk_UserId(String fk_UserId) {
        this.fk_UserId = fk_UserId;
    }

    public String getAssociateID() {
        return associateID;
    }

    public void setAssociateID(String associateID) {
        this.associateID = associateID;
    }

    public Object getFromDate() {
        return fromDate;
    }

    public void setFromDate(Object fromDate) {
        this.fromDate = fromDate;
    }

    public Object getToDate() {
        return toDate;
    }

    public void setToDate(Object toDate) {
        this.toDate = toDate;
    }

    public ArrayList<LstAssociateDownLine> getLstAssociateDownLine() {
        return lstAssociateDownLine;
    }

    public void setLstAssociateDownLine(ArrayList<LstAssociateDownLine> lstAssociateDownLine) {
        this.lstAssociateDownLine = lstAssociateDownLine;
    }


}
