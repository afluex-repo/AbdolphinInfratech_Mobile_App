package com.abdolphininfratech.Model.responseNews;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstnewsdetail {

    @SerializedName("PK_NewsID")
    @Expose
    private String pKNewsID;
    @SerializedName("NewsHeading")
    @Expose
    private String newsHeading;
    @SerializedName("NewsBody")
    @Expose
    private String newsBody;

    public String getPKNewsID() {
        return pKNewsID;
    }

    public void setPKNewsID(String pKNewsID) {
        this.pKNewsID = pKNewsID;
    }

    public String getNewsHeading() {
        return newsHeading;
    }

    public void setNewsHeading(String newsHeading) {
        this.newsHeading = newsHeading;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

}
