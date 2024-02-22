package com.abdolphininfratech.Model.responseAssociateTree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAssociateTree {

    @SerializedName("Fk_UserId")
    @Expose
    private String fkUserId;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("lstdownline")
    @Expose
    private List<Lstdownline> lstdownline = null;

    public String getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public List<Lstdownline> getLstdownline() {
        return lstdownline;
    }

    public void setLstdownline(List<Lstdownline> lstdownline) {
        this.lstdownline = lstdownline;
    }
}
