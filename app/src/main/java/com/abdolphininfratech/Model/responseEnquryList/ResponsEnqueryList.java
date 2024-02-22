package com.abdolphininfratech.Model.responseEnquryList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsEnqueryList {
    @SerializedName("lstBlock1")
    @Expose
    private List<LstBlock1> lstBlock1 = null;

    public List<LstBlock1> getLstBlock1() {
        return lstBlock1;
    }

    public void setLstBlock1(List<LstBlock1> lstBlock1) {
        this.lstBlock1 = lstBlock1;
    }

}
