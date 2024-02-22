package com.abdolphininfratech.Model.responseLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {

    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("TotalBookingId")
    @Expose
    private String TotalBookingId;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("SuccessMessage")
    @Expose
    private String successMessage;
    @SerializedName("LoginId")
    @Expose
    private String loginId;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("Pk_userId")
    @Expose
    private String pkUserId;
    @SerializedName("UserType")
    @Expose
    private String userType;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("ProfilePic")
    @Expose
    private String profilePic;
    @SerializedName("StatusColor")
    @Expose
    private String statusColor;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPkUserId() {
        return pkUserId;
    }

    public void setPkUserId(String pkUserId) {
        this.pkUserId = pkUserId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getTotalBookingId() {
        return TotalBookingId;
    }

    public void setTotalBookingId(String totalBookingId) {
        TotalBookingId = totalBookingId;
    }
}
