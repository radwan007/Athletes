package com.creative.athletes.APIHandler.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Radwan on 17/10/2017.
 */
public class AthleteItemResponse {
    @SerializedName("name")
    @Expose
    private String  Name;

    @SerializedName("image")
    @Expose
    private String  Image;

    @SerializedName("brief")
    @Expose
    private String  Brief;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getBrief() {
        return Brief;
    }

    public void setBrief(String brief) {
        Brief = brief;
    }
}
