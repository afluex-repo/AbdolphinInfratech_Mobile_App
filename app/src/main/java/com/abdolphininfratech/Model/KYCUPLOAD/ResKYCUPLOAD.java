package com.abdolphininfratech.Model.KYCUPLOAD;
import com.google.gson.annotations.SerializedName;


public class ResKYCUPLOAD {
    @SerializedName("Status")
    public String status;
    @SerializedName("Message")
    public String message;
    @SerializedName("UserID")
    public String userID;
    @SerializedName("AdharNumber")
    public String adharNumber;
    @SerializedName("AdharImage")
    public String adharImage;
    @SerializedName("AdharBacksideImage")
    public String adharBacksideImage;
    @SerializedName("PanNumber")
    public String panNumber;
    @SerializedName("PanImage")
    public String panImage;
    @SerializedName("DocumentNumber")
    public String documentNumber;
    @SerializedName("AccountHolderName")
    public String accountHolderName;
    @SerializedName("IFSCCode")
    public String iFSCCode;
    @SerializedName("DocumentImage")
    public String documentImage;
    @SerializedName("BankName")
    public String bankName;
    @SerializedName("BankBranch")
    public String bankBranch;

    public ResKYCUPLOAD(String status, String message, String userID, String adharNumber, String adharImage, String adharBacksideImage, String panNumber, String panImage, String documentNumber, String accountHolderName, String iFSCCode, String documentImage, String bankName, String bankBranch) {
        this.status = status;
        this.message = message;
        this.userID = userID;
        this.adharNumber = adharNumber;
        this.adharImage = adharImage;
        this.adharBacksideImage = adharBacksideImage;
        this.panNumber = panNumber;
        this.panImage = panImage;
        this.documentNumber = documentNumber;
        this.accountHolderName = accountHolderName;
        this.iFSCCode = iFSCCode;
        this.documentImage = documentImage;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public void setAdharNumber(String adharNumber) {
        this.adharNumber = adharNumber;
    }

    public String getAdharImage() {
        return adharImage;
    }

    public void setAdharImage(String adharImage) {
        this.adharImage = adharImage;
    }

    public String getAdharBacksideImage() {
        return adharBacksideImage;
    }

    public void setAdharBacksideImage(String adharBacksideImage) {
        this.adharBacksideImage = adharBacksideImage;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPanImage() {
        return panImage;
    }

    public void setPanImage(String panImage) {
        this.panImage = panImage;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getiFSCCode() {
        return iFSCCode;
    }

    public void setiFSCCode(String iFSCCode) {
        this.iFSCCode = iFSCCode;
    }

    public String getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(String documentImage) {
        this.documentImage = documentImage;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }
}
