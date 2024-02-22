package com.abdolphininfratech.Model.SiteType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstsitetype {
    @SerializedName("PK_SiteTypeID")
    @Expose
    private String pKSiteTypeID;
    @SerializedName("SiteTypeName")
    @Expose
    private String siteTypeName;

    public String getPKSiteTypeID() {
        return pKSiteTypeID;
    }

    public void setPKSiteTypeID(String pKSiteTypeID) {
        this.pKSiteTypeID = pKSiteTypeID;
    }

    public String getSiteTypeName() {
        return siteTypeName;
    }

    public void setSiteTypeName(String siteTypeName) {
        this.siteTypeName = siteTypeName;
    }

}