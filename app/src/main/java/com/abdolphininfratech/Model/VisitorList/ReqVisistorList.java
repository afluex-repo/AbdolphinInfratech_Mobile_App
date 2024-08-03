package com.abdolphininfratech.Model.VisitorList;
import com.google.gson.annotations.SerializedName;

public class ReqVisistorList {
    @SerializedName("LoginID")
    public String loginID;
    @SerializedName("Downline")
    public int downline;
    @SerializedName("FromDate")
    public String fromDate;
    @SerializedName("ToDate")
    public String toDate;

    public ReqVisistorList(String loginID, int downline, String fromDate, String toDate) {
        this.loginID = loginID;
        this.downline = downline;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public int getDownline() {
        return downline;
    }

    public void setDownline(int downline) {
        this.downline = downline;
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
}
