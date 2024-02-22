package com.abdolphininfratech.Model.responseAssociateTree;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstdownline {

    @SerializedName("Fk_UserId")
    @Expose
    private String fkUserId;
    @SerializedName("Fk_SponsorId")
    @Expose
    private String fkSponsorId;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("ActiveStatus")
    @Expose
    private String activeStatus;

    public String getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(String fkUserId) {
        this.fkUserId = fkUserId;
    }

    public String getFkSponsorId() {
        return fkSponsorId;
    }

    public void setFkSponsorId(String fkSponsorId) {
        this.fkSponsorId = fkSponsorId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
}
