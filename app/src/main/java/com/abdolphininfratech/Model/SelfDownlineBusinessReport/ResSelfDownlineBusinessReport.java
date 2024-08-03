package com.abdolphininfratech.Model.SelfDownlineBusinessReport;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ResSelfDownlineBusinessReport {
    @SerializedName("Status")
    public String status;
    @SerializedName("Message")
    public String message;
    @SerializedName("LoginID")
    public String loginID;
    @SerializedName("FromDate")
    public Object fromDate;
    @SerializedName("ToDate")
    public Object toDate;
    @SerializedName("PK_BookingId")
    public Object pK_BookingId;
    @SerializedName("CustomerLoginID")
    public Object customerLoginID;
    @SerializedName("CustomerName")
    public Object customerName;
    @SerializedName("PlotNumber")
    public Object plotNumber;
    @SerializedName("BookingNumber")
    public Object bookingNumber;
    @SerializedName("SiteID")
    public Object siteID;
    @SerializedName("SectorID")
    public Object sectorID;
    @SerializedName("BlockID")
    public Object blockID;
    @SerializedName("Mobile")
    public Object mobile;
    @SerializedName("Downline")
    public Object downline;
    @SerializedName("TotalPaidAmount")
    public String totalPaidAmount;
    @SerializedName("TotalBalance")
    public String totalBalance;
    @SerializedName("TotalPlotAmount")
    public String totalPlotAmount;
    @SerializedName("TotalDiscount")
    public String totalDiscount;
    @SerializedName("TotalAmount")
    public String totalAmount;
    public ArrayList<LstSelfDownlineBusiness> lstSelfDownlineBusiness;

    public ResSelfDownlineBusinessReport(String status, String message, String loginID, Object fromDate, Object toDate, Object pK_BookingId, Object customerLoginID, Object customerName, Object plotNumber, Object bookingNumber, Object siteID, Object sectorID, Object blockID, Object mobile, Object downline, String totalPaidAmount, String totalBalance, String totalPlotAmount, String totalDiscount, String totalAmount, ArrayList<LstSelfDownlineBusiness> lstSelfDownlineBusiness) {
        this.status = status;
        this.message = message;
        this.loginID = loginID;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pK_BookingId = pK_BookingId;
        this.customerLoginID = customerLoginID;
        this.customerName = customerName;
        this.plotNumber = plotNumber;
        this.bookingNumber = bookingNumber;
        this.siteID = siteID;
        this.sectorID = sectorID;
        this.blockID = blockID;
        this.mobile = mobile;
        this.downline = downline;
        this.totalPaidAmount = totalPaidAmount;
        this.totalBalance = totalBalance;
        this.totalPlotAmount = totalPlotAmount;
        this.totalDiscount = totalDiscount;
        this.totalAmount = totalAmount;
        this.lstSelfDownlineBusiness = lstSelfDownlineBusiness;

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

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public Object getFromDate() {
        return fromDate;
    }

    public void setFromDate(Object fromDate) {
        this.fromDate = fromDate;
    }

    public Object getToDate() {
        return toDate;
    }

    public void setToDate(Object toDate) {
        this.toDate = toDate;
    }

    public Object getpK_BookingId() {
        return pK_BookingId;
    }

    public void setpK_BookingId(Object pK_BookingId) {
        this.pK_BookingId = pK_BookingId;
    }

    public Object getCustomerLoginID() {
        return customerLoginID;
    }

    public void setCustomerLoginID(Object customerLoginID) {
        this.customerLoginID = customerLoginID;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public Object getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(Object plotNumber) {
        this.plotNumber = plotNumber;
    }

    public Object getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Object bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Object getSiteID() {
        return siteID;
    }

    public void setSiteID(Object siteID) {
        this.siteID = siteID;
    }

    public Object getSectorID() {
        return sectorID;
    }

    public void setSectorID(Object sectorID) {
        this.sectorID = sectorID;
    }

    public Object getBlockID() {
        return blockID;
    }

    public void setBlockID(Object blockID) {
        this.blockID = blockID;
    }

    public Object getMobile() {
        return mobile;
    }

    public void setMobile(Object mobile) {
        this.mobile = mobile;
    }

    public Object getDownline() {
        return downline;
    }

    public void setDownline(Object downline) {
        this.downline = downline;
    }

    public String getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(String totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public String getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(String totalBalance) {
        this.totalBalance = totalBalance;
    }

    public String getTotalPlotAmount() {
        return totalPlotAmount;
    }

    public void setTotalPlotAmount(String totalPlotAmount) {
        this.totalPlotAmount = totalPlotAmount;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<LstSelfDownlineBusiness> getLstSelfDownlineBusiness() {
        return lstSelfDownlineBusiness;
    }

    public void setLstSelfDownlineBusiness(ArrayList<LstSelfDownlineBusiness> lstSelfDownlineBusiness) {
        this.lstSelfDownlineBusiness = lstSelfDownlineBusiness;
    }
}
