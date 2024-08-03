package com.abdolphininfratech.Model.PrintVisitorList;
import com.google.gson.annotations.SerializedName;

public class Visitorlst {
    @SerializedName("CustomerName")
    public String customerName;
    @SerializedName("Mobile")
    public String mobile;
    @SerializedName("Address")
    public String address;

    public Visitorlst(String customerName, String mobile, String address) {
        this.customerName = customerName;
        this.mobile = mobile;
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
