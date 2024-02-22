package com.abdolphininfratech.Model.responseSummsryReport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstSummary {

    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("PK_BookingId")
    @Expose
    private String pKBookingId;
    @SerializedName("AssociateName")
    @Expose
    private String associateName;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("PaidAmount")
    @Expose
    private String paidAmount;
    @SerializedName("PaymentDate")
    @Expose
    private String paymentDate;
    @SerializedName("PlotNumber")
    @Expose
    private String plotNumber;
    @SerializedName("PlotAmount")
    @Expose
    private String plotAmount;
    @SerializedName("Balance")
    @Expose
    private String balance;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("BookingNumber")
    @Expose
    private String bookingNumber;
    @SerializedName("Discount")
    @Expose
    private String discount;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPKBookingId() {
        return pKBookingId;
    }

    public void setPKBookingId(String pKBookingId) {
        this.pKBookingId = pKBookingId;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getPlotAmount() {
        return plotAmount;
    }

    public void setPlotAmount(String plotAmount) {
        this.plotAmount = plotAmount;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
