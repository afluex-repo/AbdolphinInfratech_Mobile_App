package com.abdolphininfratech.Model.responsePayoutRequestList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePayoutRequestList {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("lstpayout")
    @Expose
    private List<Lstpayout> lstpayout = null;

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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Lstpayout> getLstpayout() {
        return lstpayout;
    }

    public void setLstpayout(List<Lstpayout> lstpayout) {
        this.lstpayout = lstpayout;
    }
}
