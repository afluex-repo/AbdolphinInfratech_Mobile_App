package com.abdolphininfratech.Model.VisitorList;
import com.google.gson.annotations.SerializedName;


public class Lstvisitor {
    @SerializedName("AssociateLoginID")
    public String associateLoginID;
    @SerializedName("PK_VisitorID")
    public String pK_VisitorID;
    @SerializedName("AssociateName")
    public String associateName;
    @SerializedName("SiteName")
    public String siteName;
    @SerializedName("VisitDate")
    public String visitDate;
    @SerializedName("Amount")
    public String amount;

    public Lstvisitor(String associateLoginID, String pK_VisitorID, String associateName, String siteName, String visitDate, String amount) {
        this.associateLoginID = associateLoginID;
        this.pK_VisitorID = pK_VisitorID;
        this.associateName = associateName;
        this.siteName = siteName;
        this.visitDate = visitDate;
        this.amount = amount;
    }

    public String getAssociateLoginID() {
        return associateLoginID;
    }

    public void setAssociateLoginID(String associateLoginID) {
        this.associateLoginID = associateLoginID;
    }

    public String getpK_VisitorID() {
        return pK_VisitorID;
    }

    public void setpK_VisitorID(String pK_VisitorID) {
        this.pK_VisitorID = pK_VisitorID;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
