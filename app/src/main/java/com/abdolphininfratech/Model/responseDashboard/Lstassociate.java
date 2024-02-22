package com.abdolphininfratech.Model.responseDashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstassociate {

    @SerializedName("TotalAssociate")
    @Expose
    private String totalAssociate;
    @SerializedName("TotalBusiness")
    @Expose
    private String totalBusiness;
    @SerializedName("TotalActiveId")
    @Expose
    private String totalActiveId;
    @SerializedName("SelfBusiness")
    @Expose
    private String selfBusiness;
    @SerializedName("TeamBusiness")
    @Expose
    private String teamBusiness;
    @SerializedName("TotalBooking")
    @Expose
    private String totalBooking;
    @SerializedName("TeamBooking")
    @Expose
    private String teamBooking;
    @SerializedName("SelfBooking")
    @Expose
    private String selfBooking;
    @SerializedName("Totalregistry")
    @Expose
    private String totalregistry;
    @SerializedName("SelfRegistry")
    @Expose
    private String selfRegistry;
    @SerializedName("TeamRegistry")
    @Expose
    private String teamRegistry;

    public String getTotalAssociate() {
        return totalAssociate;
    }

    public void setTotalAssociate(String totalAssociate) {
        this.totalAssociate = totalAssociate;
    }

    public String getTotalBusiness() {
        return totalBusiness;
    }

    public void setTotalBusiness(String totalBusiness) {
        this.totalBusiness = totalBusiness;
    }

    public String getTotalActiveId() {
        return totalActiveId;
    }

    public void setTotalActiveId(String totalActiveId) {
        this.totalActiveId = totalActiveId;
    }

    public String getSelfBusiness() {
        return selfBusiness;
    }

    public void setSelfBusiness(String selfBusiness) {
        this.selfBusiness = selfBusiness;
    }

    public String getTeamBusiness() {
        return teamBusiness;
    }

    public void setTeamBusiness(String teamBusiness) {
        this.teamBusiness = teamBusiness;
    }

    public String getTotalBooking() {
        return totalBooking;
    }

    public void setTotalBooking(String totalBooking) {
        this.totalBooking = totalBooking;
    }

    public String getTeamBooking() {
        return teamBooking;
    }

    public void setTeamBooking(String teamBooking) {
        this.teamBooking = teamBooking;
    }

    public String getSelfBooking() {
        return selfBooking;
    }

    public void setSelfBooking(String selfBooking) {
        this.selfBooking = selfBooking;
    }

    public String getTotalregistry() {
        return totalregistry;
    }

    public void setTotalregistry(String totalregistry) {
        this.totalregistry = totalregistry;
    }

    public String getSelfRegistry() {
        return selfRegistry;
    }

    public void setSelfRegistry(String selfRegistry) {
        this.selfRegistry = selfRegistry;
    }

    public String getTeamRegistry() {
        return teamRegistry;
    }

    public void setTeamRegistry(String teamRegistry) {
        this.teamRegistry = teamRegistry;
    }
}
