package com.abdolphininfratech.Model.BusinessReport;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResBusinessReport {
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
    public ArrayList<LstBusinessReport> lstBusinessReport;

    public ResBusinessReport(String status, String message, String loginId, Object fromDate, Object toDate, ArrayList<LstBusinessReport> lstBusinessReport) {
        this.status = status;
        this.message = message;
        this.loginId = loginId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.lstBusinessReport = lstBusinessReport;
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

    public ArrayList<LstBusinessReport> getLstBusinessReport() {
        return lstBusinessReport;
    }

    public void setLstBusinessReport(ArrayList<LstBusinessReport> lstBusinessReport) {
        this.lstBusinessReport = lstBusinessReport;
    }
}
