package com.abdolphininfratech.Model.responseBookingDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBookingDetails {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SiteID")
    @Expose
    private String siteID;
    @SerializedName("BookingNumber")
    @Expose
    private String bookingNumber;
    @SerializedName("SectorID")
    @Expose
    private String sectorID;
    @SerializedName("BlockID")
    @Expose
    private String blockID;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("BranchID")
    @Expose
    private String branchID;
    @SerializedName("PlotNumber")
    @Expose
    private String plotNumber;
    @SerializedName("PK_BookingId")
    @Expose
    private String pKBookingId;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("CustomerLoginID")
    @Expose
    private String customerLoginID;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("lstbooking")
    @Expose
    private List<Lstbooking> lstbooking = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getPKBookingId() {
        return pKBookingId;
    }

    public void setPKBookingId(String pKBookingId) {
        this.pKBookingId = pKBookingId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getCustomerLoginID() {
        return customerLoginID;
    }

    public void setCustomerLoginID(String customerLoginID) {
        this.customerLoginID = customerLoginID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Lstbooking> getLstbooking() {
        return lstbooking;
    }

    public void setLstbooking(List<Lstbooking> lstbooking) {
        this.lstbooking = lstbooking;
    }
}


