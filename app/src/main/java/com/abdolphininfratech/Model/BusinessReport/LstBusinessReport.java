package com.abdolphininfratech.Model.BusinessReport;

import com.google.gson.annotations.SerializedName;

public class LstBusinessReport {
    @SerializedName("UserLoginId")
    public String userLoginId;
    @SerializedName("LoginId")
    public String loginId;
    @SerializedName("TotalAllotmentAmount")
    public String totalAllotmentAmount;
    @SerializedName("TeamBusiness")
    public String teamBusiness;
    @SerializedName("DirectMemberJoining")
    public String directMemberJoining;
    @SerializedName("TeamMemberJoining")
    public String teamMemberJoining;

    public LstBusinessReport(String userLoginId, String loginId, String totalAllotmentAmount, String teamBusiness, String directMemberJoining, String teamMemberJoining) {
        this.userLoginId = userLoginId;
        this.loginId = loginId;
        this.totalAllotmentAmount = totalAllotmentAmount;
        this.teamBusiness = teamBusiness;
        this.directMemberJoining = directMemberJoining;
        this.teamMemberJoining = teamMemberJoining;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
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

    public String getTeamBusiness() {
        return teamBusiness;
    }

    public void setTeamBusiness(String teamBusiness) {
        this.teamBusiness = teamBusiness;
    }

    public String getDirectMemberJoining() {
        return directMemberJoining;
    }

    public void setDirectMemberJoining(String directMemberJoining) {
        this.directMemberJoining = directMemberJoining;
    }

    public String getTeamMemberJoining() {
        return teamMemberJoining;
    }

    public void setTeamMemberJoining(String teamMemberJoining) {
        this.teamMemberJoining = teamMemberJoining;
    }
}
