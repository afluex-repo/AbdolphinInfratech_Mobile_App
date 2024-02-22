package com.abdolphininfratech.Model.responseUserReword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstreward {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("QualifyDate")
    @Expose
    private String qualifyDate;
    @SerializedName("RewardImage")
    @Expose
    private String rewardImage;
    @SerializedName("RewardName")
    @Expose
    private String rewardName;
    @SerializedName("Contact")
    @Expose
    private String contact;
    @SerializedName("PK_RewardItemId")
    @Expose
    private String pKRewardItemId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQualifyDate() {
        return qualifyDate;
    }

    public void setQualifyDate(String qualifyDate) {
        this.qualifyDate = qualifyDate;
    }

    public String getRewardImage() {
        return rewardImage;
    }

    public void setRewardImage(String rewardImage) {
        this.rewardImage = rewardImage;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPKRewardItemId() {
        return pKRewardItemId;
    }

    public void setPKRewardItemId(String pKRewardItemId) {
        this.pKRewardItemId = pKRewardItemId;
    }
}
