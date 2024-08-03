package com.abdolphininfratech.Model.PrintVisitorList;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResPrintVisitorList {
    @SerializedName("Status")
    public String status;

    @SerializedName("Message")
    public String message;
    @SerializedName("PK_VisitorId")
    public String pK_VisitorId;
    @SerializedName("SiteName")
    public String siteName;
    @SerializedName("LoginId")
    public String loginId;
    @SerializedName("AssociateName")
    public String associateName;
    @SerializedName("Amount")
    public String amount;
    @SerializedName("VisitDate")
    public String visitDate;
    public ArrayList<Visitorlst> visitorlst;

    public ResPrintVisitorList(String status, String message, String pK_VisitorId, String siteName, String loginId, String associateName, String amount, String visitDate, ArrayList<Visitorlst> visitorlst) {
        this.status = status;
        this.message = message;
        this.pK_VisitorId = pK_VisitorId;
        this.siteName = siteName;
        this.loginId = loginId;
        this.associateName = associateName;
        this.amount = amount;
        this.visitDate = visitDate;
        this.visitorlst = visitorlst;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getpK_VisitorId() {
        return pK_VisitorId;
    }

    public void setpK_VisitorId(String pK_VisitorId) {
        this.pK_VisitorId = pK_VisitorId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public ArrayList<Visitorlst> getVisitorlst() {
        return visitorlst;
    }

    public void setVisitorlst(ArrayList<Visitorlst> visitorlst) {
        this.visitorlst = visitorlst;
    }
}
