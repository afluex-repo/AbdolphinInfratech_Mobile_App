package com.abdolphininfratech.Model.GetDownLineBusinessById;

import com.google.gson.annotations.SerializedName;

public class LstViewBussiness {
    @SerializedName("Name")
    public String name;
    @SerializedName("LoginId")
    public String loginId;
    @SerializedName("Business")
    public String business;

    public LstViewBussiness(String name, String loginId, String business) {
        this.name = name;
        this.loginId = loginId;
        this.business = business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
