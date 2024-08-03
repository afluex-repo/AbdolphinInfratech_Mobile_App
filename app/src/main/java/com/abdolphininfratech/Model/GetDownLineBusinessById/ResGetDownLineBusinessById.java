package com.abdolphininfratech.Model.GetDownLineBusinessById;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;


public class ResGetDownLineBusinessById {
    @SerializedName("Status")
    public String status;
    @SerializedName("Message")
    public String message;
    @SerializedName("Fk_UserId")
    public String fk_UserId;
    @SerializedName("FromDate")
    public Object fromDate;
    @SerializedName("ToDate")
    public Object toDate;
    public ArrayList<LstViewBussiness> lstViewBussiness;

    public ResGetDownLineBusinessById(String status, String message, String fk_UserId, Object fromDate, Object toDate, ArrayList<LstViewBussiness> lstViewBussiness) {
        this.status = status;
        this.message = message;
        this.fk_UserId = fk_UserId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.lstViewBussiness = lstViewBussiness;
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

    public ArrayList<LstViewBussiness> getLstViewBussiness() {
        return lstViewBussiness;
    }

    public void setLstViewBussiness(ArrayList<LstViewBussiness> lstViewBussiness) {
        this.lstViewBussiness = lstViewBussiness;
    }
}
