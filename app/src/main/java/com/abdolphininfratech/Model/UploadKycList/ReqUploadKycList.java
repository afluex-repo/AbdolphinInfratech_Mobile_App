package com.abdolphininfratech.Model.UploadKycList;
import com.google.gson.annotations.SerializedName;

public class ReqUploadKycList {

    @SerializedName("UserID")
    private int userID;

    // Default constructor
    public ReqUploadKycList() {
    }

    // Parameterized constructor
    public ReqUploadKycList(int userID) {
        this.userID = userID;
    }

    // Getter for userID
    public int getUserID() {
        return userID;
    }

    // Setter for userID
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
