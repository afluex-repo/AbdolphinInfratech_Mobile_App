package com.abdolphininfratech.Model.VisitorList;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;


public class ResVisitorList {
    @SerializedName("LoginID")
    public String loginID;
    @SerializedName("Message")
    public String message;
    @SerializedName("Status")
    public String status;
    @SerializedName("FromDate")
    public Object fromDate;
    @SerializedName("ToDate")
    public Object toDate;
    @SerializedName("Downline")
    public String downline;
    @SerializedName("TotalAmount")
    public String totalAmount;
    public ArrayList<Lstvisitor> lstvisitor;


    public ResVisitorList(String loginID, String message, String status, Object fromDate, Object toDate, String downline, String totalAmount, ArrayList<Lstvisitor> lstvisitor) {
        this.loginID = loginID;
        this.message = message;
        this.status = status;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.downline = downline;
        this.totalAmount = totalAmount;
        this.lstvisitor = lstvisitor;

    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
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

    public String getDownline() {
        return downline;
    }

    public void setDownline(String downline) {
        this.downline = downline;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<Lstvisitor> getLstvisitor() {
        return lstvisitor;
    }

    public void setLstvisitor(ArrayList<Lstvisitor> lstvisitor) {
        this.lstvisitor = lstvisitor;
    }


}
