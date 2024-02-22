package com.abdolphininfratech.Model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBookingDetails {

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

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public void setSectorID(String sectorID) {
        this.sectorID = sectorID;
    }

    public void setBlockID(String blockID) {
        this.blockID = blockID;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public void setpKBookingId(String pKBookingId) {
        this.pKBookingId = pKBookingId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setCustomerLoginID(String customerLoginID) {
        this.customerLoginID = customerLoginID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
