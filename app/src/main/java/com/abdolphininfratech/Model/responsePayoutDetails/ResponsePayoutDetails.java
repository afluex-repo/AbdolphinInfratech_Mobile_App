package com.abdolphininfratech.Model.responsePayoutDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePayoutDetails {
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("PayOutNo")
    @Expose
    private String payOutNo;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("lstpayout")
    @Expose
    private List<Lstpayout> lstpayout = null;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPayOutNo() {
        return payOutNo;
    }

    public void setPayOutNo(String payOutNo) {
        this.payOutNo = payOutNo;
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

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public List<Lstpayout> getLstpayout() {
        return lstpayout;
    }

    public void setLstpayout(List<Lstpayout> lstpayout) {
        this.lstpayout = lstpayout;
    }

}
