package com.abdolphininfratech.Model.responseUserReword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseUserReword {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("RewardID")
    @Expose
    private String rewardID;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("lstreward")
    @Expose
    private List<Lstreward> lstreward = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRewardID() {
        return rewardID;
    }

    public void setRewardID(String rewardID) {
        this.rewardID = rewardID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Lstreward> getLstreward() {
        return lstreward;
    }

    public void setLstreward(List<Lstreward> lstreward) {
        this.lstreward = lstreward;
    }
}
