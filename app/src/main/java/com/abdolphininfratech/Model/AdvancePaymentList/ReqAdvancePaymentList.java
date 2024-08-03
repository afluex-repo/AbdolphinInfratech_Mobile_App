package com.abdolphininfratech.Model.AdvancePaymentList;
import com.google.gson.annotations.SerializedName;


public class ReqAdvancePaymentList {
    @SerializedName("LoginID")
    public String loginID;

    public ReqAdvancePaymentList(String loginID) {
        this.loginID = loginID;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }
}
