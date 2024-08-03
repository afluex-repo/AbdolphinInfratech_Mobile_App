package com.abdolphininfratech.Model.AdvancePaymentList;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;


public class ResAdvancePaymentList {
    @SerializedName("Status")
    public String status;
    @SerializedName("Message")
    public String message;
    @SerializedName("LoginID")
    public String loginID;
    @SerializedName("TotalAmount")
    public String totalAmount;
    public ArrayList<LstAdvancePayment> lstAdvancePayment;

    public ResAdvancePaymentList(String status, String message, String loginID, String totalAmount, ArrayList<LstAdvancePayment> lstAdvancePayment) {
        this.status = status;
        this.message = message;
        this.loginID = loginID;
        this.totalAmount = totalAmount;
        this.lstAdvancePayment = lstAdvancePayment;

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

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<LstAdvancePayment> getLstAdvancePayment() {
        return lstAdvancePayment;
    }

    public void setLstAdvancePayment(ArrayList<LstAdvancePayment> lstAdvancePayment) {
        this.lstAdvancePayment = lstAdvancePayment;
    }
}
