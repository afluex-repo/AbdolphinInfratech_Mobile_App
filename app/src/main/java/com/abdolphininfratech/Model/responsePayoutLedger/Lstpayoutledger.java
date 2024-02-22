package com.abdolphininfratech.Model.responsePayoutLedger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lstpayoutledger {

    @SerializedName("PayoutWalletID")
    @Expose
    private String payoutWalletID;
    @SerializedName("Narration")
    @Expose
    private String narration;
    @SerializedName("Credit")
    @Expose
    private String credit;
    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("TType")
    @Expose
    private String tType;
    @SerializedName("Debit")
    @Expose
    private String debit;

    public String getPayoutWalletID() {
        return payoutWalletID;
    }

    public void setPayoutWalletID(String payoutWalletID) {
        this.payoutWalletID = payoutWalletID;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTType() {
        return tType;
    }

    public void setTType(String tType) {
        this.tType = tType;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }
}
