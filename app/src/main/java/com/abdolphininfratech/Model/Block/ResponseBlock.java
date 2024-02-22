package com.abdolphininfratech.Model.Block;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBlock {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("SiteID")
    @Expose
    private String siteID;
    @SerializedName("SectorID")
    @Expose
    private String sectorID;
    @SerializedName("PK_BlockID")
    @Expose
    private String pKBlockID;
    @SerializedName("lstBlock")
    @Expose
    private List<LstBlock> lstBlock = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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

    public String getPKBlockID() {
        return pKBlockID;
    }

    public void setPKBlockID(String pKBlockID) {
        this.pKBlockID = pKBlockID;
    }

    public List<LstBlock> getLstBlock() {
        return lstBlock;
    }

    public void setLstBlock(List<LstBlock> lstBlock) {
        this.lstBlock = lstBlock;
    }

}
