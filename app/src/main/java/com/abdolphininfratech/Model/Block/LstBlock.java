package com.abdolphininfratech.Model.Block;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LstBlock {
    @SerializedName("PK_BlockID")
    @Expose
    private String pKBlockID;
    @SerializedName("BlockName")
    @Expose
    private String blockName;

    public String getPKBlockID() {
        return pKBlockID;
    }

    public void setPKBlockID(String pKBlockID) {
        this.pKBlockID = pKBlockID;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

}
