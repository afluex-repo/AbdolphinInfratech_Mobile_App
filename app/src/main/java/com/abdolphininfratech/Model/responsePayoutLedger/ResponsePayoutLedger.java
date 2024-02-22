package com.abdolphininfratech.Model.responsePayoutLedger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePayoutLedger {

    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("lstpayoutledger")
    @Expose
    private List<Lstpayoutledger> lstpayoutledger = null;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Lstpayoutledger> getLstpayoutledger() {
        return lstpayoutledger;
    }

    public void setLstpayoutledger(List<Lstpayoutledger> lstpayoutledger) {
        this.lstpayoutledger = lstpayoutledger;
    }
}
