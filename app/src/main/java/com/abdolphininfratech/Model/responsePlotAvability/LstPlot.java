package com.abdolphininfratech.Model.responsePlotAvability;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstPlot {

    @SerializedName("PlotID")
    @Expose
    private String plotID;
    @SerializedName("PlotStatus")
    @Expose
    private String plotStatus;
    @SerializedName("ColorCSS")
    @Expose
    private String colorCSS;
    @SerializedName("PlotAmount")
    @Expose
    private String plotAmount;
    @SerializedName("PlotArea")
    @Expose
    private String plotArea;
    @SerializedName("SiteName")
    @Expose
    private String siteName;
    @SerializedName("BlockName")
    @Expose
    private String blockName;
    @SerializedName("SectorName")
    @Expose
    private String sectorName;

    @SerializedName("PlotNumber")
    @Expose
    private String plotnumber;

    public String getPlotID() {
        return plotID;
    }

    public void setPlotID(String plotID) {
        this.plotID = plotID;
    }

    public String getPlotStatus() {
        return plotStatus;
    }

    public void setPlotStatus(String plotStatus) {
        this.plotStatus = plotStatus;
    }

    public String getColorCSS() {
        return colorCSS;
    }

    public void setColorCSS(String colorCSS) {
        this.colorCSS = colorCSS;
    }

    public String getPlotAmount() {
        return plotAmount;
    }

    public void setPlotAmount(String plotAmount) {
        this.plotAmount = plotAmount;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getPlotnumber() {
        return plotnumber;
    }

    public void setPlotnumber(String plotnumber) {
        this.plotnumber = plotnumber;
    }
}
