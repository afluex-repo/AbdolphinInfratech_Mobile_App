package com.abdolphininfratech.Model.responseLedger;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseLedger {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("BookingNumber")
    @Expose
    private String bookingNumber;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("SiteID")
    @Expose
    private String siteID;
    @SerializedName("SectorID")
    @Expose
    private String sectorID;
    @SerializedName("BlockID")
    @Expose
    private String blockID;
    @SerializedName("PK_BookingId")
    @Expose
    private String pKBookingId;
    @SerializedName("AssociateID")
    @Expose
    private String associateID;
    @SerializedName("CustomerID")
    @Expose
    private String customerID;
    @SerializedName("PlotNumber")
    @Expose
    private String plotNumber;
    @SerializedName("Result")
    @Expose
    private String result;
    @SerializedName("PlotAmount")
    @Expose
    private String plotAmount;
    @SerializedName("ActualPlotRate")
    @Expose
    private String actualPlotRate;
    @SerializedName("PlotRate")
    @Expose
    private String plotRate;
    @SerializedName("PayAmount")
    @Expose
    private String payAmount;
    @SerializedName("BookingDate")
    @Expose
    private String bookingDate;
    @SerializedName("BookingAmount")
    @Expose
    private String bookingAmount;
    @SerializedName("PaymentDate")
    @Expose
    private String paymentDate;
    @SerializedName("PaidAmount")
    @Expose
    private String paidAmount;
    @SerializedName("Discount")
    @Expose
    private String discount;
    @SerializedName("PaymentPlanID")
    @Expose
    private String paymentPlanID;
    @SerializedName("PlanName")
    @Expose
    private String planName;
    @SerializedName("TotalAllotmentAmount")
    @Expose
    private String totalAllotmentAmount;
    @SerializedName("PaidAllotmentAmount")
    @Expose
    private String paidAllotmentAmount;
    @SerializedName("BalanceAllotmentAmount")
    @Expose
    private String balanceAllotmentAmount;
    @SerializedName("TotalInstallment")
    @Expose
    private String totalInstallment;
    @SerializedName("InstallmentAmount")
    @Expose
    private String installmentAmount;
    @SerializedName("PlotArea")
    @Expose
    private String plotArea;
    @SerializedName("Balance")
    @Expose
    private String balance;
    @SerializedName("lstpayment")
    @Expose
    private List<Lstpayment> lstpayment = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSectorID() {
        return sectorID;
    }

    public void setSectorID(String sectorID) {
        this.sectorID = sectorID;
    }

    public String getBlockID() {
        return blockID;
    }

    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    public String getPKBookingId() {
        return pKBookingId;
    }

    public void setPKBookingId(String pKBookingId) {
        this.pKBookingId = pKBookingId;
    }

    public String getAssociateID() {
        return associateID;
    }

    public void setAssociateID(String associateID) {
        this.associateID = associateID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPlotAmount() {
        return plotAmount;
    }

    public void setPlotAmount(String plotAmount) {
        this.plotAmount = plotAmount;
    }

    public String getActualPlotRate() {
        return actualPlotRate;
    }

    public void setActualPlotRate(String actualPlotRate) {
        this.actualPlotRate = actualPlotRate;
    }

    public String getPlotRate() {
        return plotRate;
    }

    public void setPlotRate(String plotRate) {
        this.plotRate = plotRate;
    }

    public String getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(String bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPaymentPlanID() {
        return paymentPlanID;
    }

    public void setPaymentPlanID(String paymentPlanID) {
        this.paymentPlanID = paymentPlanID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getTotalAllotmentAmount() {
        return totalAllotmentAmount;
    }

    public void setTotalAllotmentAmount(String totalAllotmentAmount) {
        this.totalAllotmentAmount = totalAllotmentAmount;
    }

    public String getPaidAllotmentAmount() {
        return paidAllotmentAmount;
    }

    public void setPaidAllotmentAmount(String paidAllotmentAmount) {
        this.paidAllotmentAmount = paidAllotmentAmount;
    }

    public String getBalanceAllotmentAmount() {
        return balanceAllotmentAmount;
    }

    public void setBalanceAllotmentAmount(String balanceAllotmentAmount) {
        this.balanceAllotmentAmount = balanceAllotmentAmount;
    }

    public String getTotalInstallment() {
        return totalInstallment;
    }

    public void setTotalInstallment(String totalInstallment) {
        this.totalInstallment = totalInstallment;
    }

    public String getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(String installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<Lstpayment> getLstpayment() {
        return lstpayment;
    }

    public void setLstpayment(List<Lstpayment> lstpayment) {
        this.lstpayment = lstpayment;
    }

}
