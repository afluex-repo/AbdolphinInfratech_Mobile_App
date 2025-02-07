package com.abdolphininfratech.Model.AssociateDownline;

import com.google.gson.annotations.SerializedName;

public class LstAssociateDownLine {
    @SerializedName("LoginDetails")
    public String loginDetails;
    @SerializedName("TotalBusiness")
    public String totalBusiness;
    @SerializedName("TeamBusinessAmount")
    public String teamBusinessAmount;
    @SerializedName("DirectMemberJoining")
    public String directMemberJoining;
    @SerializedName("TeamMemberJoining")
    public String teamMemberJoining;
    @SerializedName("Income")
    public String income;

    public LstAssociateDownLine(String loginDetails, String totalBusiness, String teamBusinessAmount, String directMemberJoining, String teamMemberJoining, String income) {
        this.loginDetails = loginDetails;
        this.totalBusiness = totalBusiness;
        this.teamBusinessAmount = teamBusinessAmount;
        this.directMemberJoining = directMemberJoining;
        this.teamMemberJoining = teamMemberJoining;
        this.income = income;
    }

    public String getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(String loginDetails) {
        this.loginDetails = loginDetails;
    }

    public String getTotalBusiness() {
        return totalBusiness;
    }

    public void setTotalBusiness(String totalBusiness) {
        this.totalBusiness = totalBusiness;
    }

    public String getTeamBusinessAmount() {
        return teamBusinessAmount;
    }

    public void setTeamBusinessAmount(String teamBusinessAmount) {
        this.teamBusinessAmount = teamBusinessAmount;
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

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }
}
