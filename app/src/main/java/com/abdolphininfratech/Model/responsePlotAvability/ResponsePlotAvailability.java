package com.abdolphininfratech.Model.responsePlotAvability;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePlotAvailability {


    @SerializedName("Message")
    @Expose
    private String message;
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
    @SerializedName("lstPlot")
    @Expose
    private List<LstPlot> lstPlot = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSectorID() {
        return sectorID;
    }

    public void setSectorID(String sectorID) {
        this.sectorID = sectorID;
    }

    public String getBlockID() {
        return blockID;
    }

    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    public String getSiteTypeID() {
        return siteTypeID;
    }

    public void setSiteTypeID(String siteTypeID) {
        this.siteTypeID = siteTypeID;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public List<LstPlot> getLstPlot() {
        return lstPlot;
    }

    public void setLstPlot(List<LstPlot> lstPlot) {
        this.lstPlot = lstPlot;
    }

}
