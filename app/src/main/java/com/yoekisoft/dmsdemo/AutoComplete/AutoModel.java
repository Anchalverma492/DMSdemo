package com.yoekisoft.dmsdemo.AutoComplete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AutoModel {
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Id")
    @Expose
    private String id;

    public AutoModel(String name, String id) {
        Name = name;
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
