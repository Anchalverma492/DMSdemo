package com.yoekisoft.dmsdemo;

public class modelgrid {

    private String android_version_name;
    private Integer android_image_url;

    public modelgrid() {
    }

    public modelgrid(String android_version_name, Integer android_image_url) {
        this.android_version_name = android_version_name;
        this.android_image_url = android_image_url;
    }

    public String getAndroid_version_name() {
        return android_version_name;
    }

    public void setAndroid_version_name(String android_version_name) {
        this.android_version_name = android_version_name;
    }

    public int getAndroid_image_url() {
        return android_image_url;
    }

    public void setAndroid_image_url(Integer android_image_url) {
        this.android_image_url = android_image_url;
    }

}
