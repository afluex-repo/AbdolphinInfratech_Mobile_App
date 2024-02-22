package com.abdolphininfratech.Model.responseDownline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDownline {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("lstdownline")
    @Expose
    private List<Lstdownline> lstdownline = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Lstdownline> getLstdownline() {
        return lstdownline;
    }

    public void setLstdownline(List<Lstdownline> lstdownline) {
        this.lstdownline = lstdownline;
    }
}
