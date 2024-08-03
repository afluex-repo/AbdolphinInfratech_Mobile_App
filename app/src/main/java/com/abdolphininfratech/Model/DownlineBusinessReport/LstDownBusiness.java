package com.abdolphininfratech.Model.DownlineBusinessReport;

import com.google.gson.annotations.SerializedName;

public class LstDownBusiness {
    @SerializedName("Fk_UserId")
    public String fk_UserId;
    @SerializedName("LoginId")
    public String loginId;
    @SerializedName("TotalAllotmentAmount")
    public String totalAllotmentAmount;

    public LstDownBusiness(String fk_UserId, String loginId, String totalAllotmentAmount) {
        this.fk_UserId = fk_UserId;
        this.loginId = loginId;
        this.totalAllotmentAmount = totalAllotmentAmount;
    }

    public String getFk_UserId() {
        return fk_UserId;
    }

    public void setFk_UserId(String fk_UserId) {
        this.fk_UserId = fk_UserId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getTotalAllotmentAmount() {
        return totalAllotmentAmount;
    }

    public void setTotalAllotmentAmount(String totalAllotmentAmount) {
        this.totalAllotmentAmount = totalAllotmentAmount;
    }


}
