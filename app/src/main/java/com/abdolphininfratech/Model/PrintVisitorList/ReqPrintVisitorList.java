package com.abdolphininfratech.Model.PrintVisitorList;
import com.google.gson.annotations.SerializedName;

public class ReqPrintVisitorList {
    @SerializedName("PK_VisitorId")
    public int pK_VisitorId;

    public ReqPrintVisitorList(int pK_VisitorId) {
        this.pK_VisitorId = pK_VisitorId;
    }

    public int getpK_VisitorId() {
        return pK_VisitorId;
    }

    public void setpK_VisitorId(int pK_VisitorId) {
        this.pK_VisitorId = pK_VisitorId;
    }
}
