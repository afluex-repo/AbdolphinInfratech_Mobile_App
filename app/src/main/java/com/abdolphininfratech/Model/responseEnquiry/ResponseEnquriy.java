package com.abdolphininfratech.Model.responseEnquiry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseEnquriy {
    @SerializedName("AddedBy")
    @Expose
    private String addedBy;
    @SerializedName("SuccessMessage")
    @Expose
    private String successMessage;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("Details")
    @Expose
    private String details;
    @SerializedName("Name")
    @Expose
    private String name;

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
