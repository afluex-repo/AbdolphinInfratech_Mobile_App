package com.abdolphininfratech.Model.AdvancePaymentList;
import com.google.gson.annotations.SerializedName;

public class LstAdvancePayment {
    @SerializedName("LoginID")
    public String loginID;
    @SerializedName("Name")
    public String name;
    @SerializedName("Amount")
    public String amount;
    @SerializedName("PaymentDate")
    public String paymentDate;

    public LstAdvancePayment(String loginID, String name, String amount, String paymentDate) {
        this.loginID = loginID;
        this.name = name;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
