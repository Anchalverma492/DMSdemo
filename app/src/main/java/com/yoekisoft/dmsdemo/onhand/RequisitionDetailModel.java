package com.yoekisoft.dmsdemo.onhand;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequisitionDetailModel {

    @SerializedName("ItemName")
    @Expose
    private String itemName;
    @SerializedName("ItemNo")
    @Expose
    private String itemNo;
    @SerializedName("RequestQty")
    @Expose
    private String requestQty;
    @SerializedName("ItemSku")
    @Expose
    private String itemSku;

    @SerializedName("Loaction")
    @Expose
    private String location;
    public RequisitionDetailModel(String itemName, String itemNo, String requestQty) {
        this.itemName = itemName;
        this.itemNo = itemNo;
        this.requestQty = requestQty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getRequestQty() {
        return requestQty;
    }

    public void setRequestQty(String requestQty) {
        this.requestQty = requestQty;
    }

}