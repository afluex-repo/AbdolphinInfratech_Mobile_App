package com.abdolphininfratech.Model.Sector;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstSector {

    @SerializedName("PK_SectorID")
    @Expose
    private String pKSectorID;
    @SerializedName("SectorName")
    @Expose
    private String sectorName;

    public String getPKSectorID() {
        return pKSectorID;
    }

    public void setPKSectorID(String pKSectorID) {
        this.pKSectorID = pKSectorID;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
