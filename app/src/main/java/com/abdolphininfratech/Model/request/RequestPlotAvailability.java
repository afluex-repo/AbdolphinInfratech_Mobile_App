package com.abdolphininfratech.Model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestPlotAvailability {

    @SerializedName("SiteID")
    @Expose
    private String siteID;
    @SerializedName("SectorID")
    @Expose
    private String sectorID;
    @SerializedName("BlockID")
    @Expose
    private String blockID;
    @SerializedName("SiteTypeID")
    @Expose
    private String siteTypeID;
    @SerializedName("PlotNumber")
    @Expose
    private String plotNumber;
    @SerializedName("LoginId")
    @Expose
    private String loginId;

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public void setSectorID(String sectorID) {
        this.sectorID = sectorID;
    }

    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    public void setSiteTypeID(String siteTypeID) {
        this.siteTypeID = siteTypeID;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
