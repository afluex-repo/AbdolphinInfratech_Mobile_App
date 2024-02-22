package com.abdolphininfratech.Model.responseGetSite;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstsite {

    @SerializedName("PK_SiteID")
    @Expose
    private String pKSiteID;
    @SerializedName("SiteName")
    @Expose
    private String siteName;

    public String getPKSiteID() {
        return pKSiteID;
    }

    public void setPKSiteID(String pKSiteID) {
        this.pKSiteID = pKSiteID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
