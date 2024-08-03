package com.abdolphininfratech.Model.DownlineBusinessReport;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ResDownlineBusinessReport {
    @SerializedName("Status")
    public String status;
    @SerializedName("Message")
    public String message;
    @SerializedName("LoginId")
    public String loginId;
    @SerializedName("FromDate")
    public Object fromDate;
    @SerializedName("ToDate")
    public Object toDate;
    public ArrayList<LstDownBusiness> lstDownBusiness;

    public ResDownlineBusinessReport(String status, String message, String loginId, Object fromDate, Object toDate, ArrayList<LstDownBusiness> lstDownBusiness) {
        this.status = status;
        this.message = message;
        this.loginId = loginId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.lstDownBusiness = lstDownBusiness;
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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
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

    public ArrayList<LstDownBusiness> getLstDownBusiness() {
        return lstDownBusiness;
    }

    public void setLstDownBusiness(ArrayList<LstDownBusiness> lstDownBusiness) {
        this.lstDownBusiness = lstDownBusiness;
    }
}
