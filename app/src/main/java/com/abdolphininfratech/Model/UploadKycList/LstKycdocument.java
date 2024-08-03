package com.abdolphininfratech.Model.UploadKycList;
import com.google.gson.annotations.SerializedName;

public class LstKycdocument {
    @SerializedName("AdharNumber")
    public String adharNumber;
    @SerializedName("AdharImage")
    public String adharImage;
    @SerializedName("AdharBacksideImage")
    public String adharBacksideImage;
    @SerializedName("AdharStatus")
    public String adharStatus;
    @SerializedName("PanNumber")
    public String panNumber;
    @SerializedName("PanImage")
    public String panImage;
    @SerializedName("PanStatus")
    public String panStatus;
    @SerializedName("DocumentNumber")
    public String documentNumber;
    @SerializedName("DocumentImage")
    public String documentImage;
    @SerializedName("DocumentStatus")
    public String documentStatus;
    @SerializedName("AccountHolderName")
    public String accountHolderName;
    @SerializedName("BankName")
    public String bankName;
    @SerializedName("IFSCCode")
    public String iFSCCode;
    @SerializedName("BankBranch")
    public String bankBranch;

    public LstKycdocument(String adharNumber, String adharImage, String adharBacksideImage, String adharStatus, String panNumber, String panImage, String panStatus, String documentNumber, String documentImage, String documentStatus, String accountHolderName, String bankName, String iFSCCode, String bankBranch) {
        this.adharNumber = adharNumber;
        this.adharImage = adharImage;
        this.adharBacksideImage = adharBacksideImage;
        this.adharStatus = adharStatus;
        this.panNumber = panNumber;
        this.panImage = panImage;
        this.panStatus = panStatus;
        this.documentNumber = documentNumber;
        this.documentImage = documentImage;
        this.documentStatus = documentStatus;
        this.accountHolderName = accountHolderName;
        this.bankName = bankName;
        this.iFSCCode = iFSCCode;
        this.bankBranch = bankBranch;
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

    public String getAdharStatus() {
        return adharStatus;
    }

    public void setAdharStatus(String adharStatus) {
        this.adharStatus = adharStatus;
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

    public String getPanStatus() {
        return panStatus;
    }

    public void setPanStatus(String panStatus) {
        this.panStatus = panStatus;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentImage() {
        return documentImage;
    }

    public void setDocumentImage(String documentImage) {
        this.documentImage = documentImage;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getiFSCCode() {
        return iFSCCode;
    }

    public void setiFSCCode(String iFSCCode) {
        this.iFSCCode = iFSCCode;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }
}
