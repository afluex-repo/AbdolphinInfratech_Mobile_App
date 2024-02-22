package com.abdolphininfratech.Model.responseSummsryReport;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSummaryReport {
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SiteID")
    @Expose
    private String siteID;
    @SerializedName("SectorID")
    @Expose
    private String sectorID;
    @SerializedName("BlockID")
    @Expose
    private String blockID;
    @SerializedName("AssociateID")
    @Expose
    private String associateID;
    @SerializedName("Downline")
    @Expose
    private String downline;
    @SerializedName("CustomerID")
    @Expose
    private String customerID;
    @SerializedName("PK_BookingId")
    @Expose
    private String pKBookingId;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("AssociateName")
    @Expose
    private String associateName;
    @SerializedName("Mobile")
    @Expose
    private String mobile;
    @SerializedName("PlotNumber")
    @Expose
    private String plotNumber;
    @SerializedName("BookingNumber")
    @Expose
    private String bookingNumber;
    @SerializedName("lstSummary")
    @Expose
    private List<LstSummary> lstSummary = null;

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

    public String getAssociateID() {
        return associateID;
    }

    public void setAssociateID(String associateID) {
        this.associateID = associateID;
    }

    public String getDownline() {
        return downline;
    }

    public void setDownline(String downline) {
        this.downline = downline;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getPKBookingId() {
        return pKBookingId;
    }

    public void setPKBookingId(String pKBookingId) {
        this.pKBookingId = pKBookingId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAssociateName() {
        return associateName;
    }

    public void setAssociateName(String associateName) {
        this.associateName = associateName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public List<LstSummary> getLstSummary() {
        return lstSummary;
    }

    public void setLstSummary(List<LstSummary> lstSummary) {
        this.lstSummary = lstSummary;
    }

}
