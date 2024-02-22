package com.abdolphininfratech.Model.responseDownline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstdownline {

    @SerializedName("AssociateID")
    @Expose
    private String associateID;
    @SerializedName("AssociateName")
    @Expose
    private String associateName;
    @SerializedName("DesignationName")
    @Expose
    private String designationName;
    @SerializedName("Percentage")
    @Expose
    private String percentage;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("Contact")
    @Expose
    private String contact;

    public String getAssociateID() {
        return associateID;
    }

    public void setAssociateID(String associateID) {
        this.associateID = associateID;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
