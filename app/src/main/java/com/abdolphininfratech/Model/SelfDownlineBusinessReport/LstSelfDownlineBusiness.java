package com.abdolphininfratech.Model.SelfDownlineBusinessReport;

import com.google.gson.annotations.SerializedName;

public class LstSelfDownlineBusiness {
    @SerializedName("PK_BookingId")
    public String pK_BookingId;
    @SerializedName("CustomerID")
    public String customerID;
    @SerializedName("CustomerName")
    public String customerName;
    @SerializedName("AssociateID")
    public String associateID;
    @SerializedName("AssociateName")
    public String associateName;
    @SerializedName("BranchName")
    public String branchName;
    @SerializedName("PaidAmount")
    public String paidAmount;
    @SerializedName("PaymentDate")
    public String paymentDate;
    @SerializedName("PlotAmount")
    public String plotAmount;
    @SerializedName("Amount")
    public String amount;
    @SerializedName("PlotNumber")
    public String plotNumber;
    @SerializedName("Balance")
    public String balance;
    @SerializedName("Discount")
    public String discount;
    @SerializedName("BookingNumber")
    public String bookingNumber;

    public LstSelfDownlineBusiness(String pK_BookingId, String customerID, String customerName, String associateID, String associateName, String branchName, String paidAmount, String paymentDate, String plotAmount, String amount, String plotNumber, String balance, String discount, String bookingNumber) {
        this.pK_BookingId = pK_BookingId;
        this.customerID = customerID;
        this.customerName = customerName;
        this.associateID = associateID;
        this.associateName = associateName;
        this.branchName = branchName;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
        this.plotAmount = plotAmount;
        this.amount = amount;
        this.plotNumber = plotNumber;
        this.balance = balance;
        this.discount = discount;
        this.bookingNumber = bookingNumber;
    }

    public String getpK_BookingId() {
        return pK_BookingId;
    }

    public void setpK_BookingId(String pK_BookingId) {
        this.pK_BookingId = pK_BookingId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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

    public String getPlotAmount() {
        return plotAmount;
    }

    public void setPlotAmount(String plotAmount) {
        this.plotAmount = plotAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
}
