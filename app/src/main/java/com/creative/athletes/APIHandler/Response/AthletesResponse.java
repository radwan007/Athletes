package com.creative.athletes.APIHandler.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Radwan on 17/10/2017.
 */
public class AthletesResponse {
    @SerializedName("athletes")
    @Expose
    private ArrayList<AthleteItemResponse> Athletes;


    public ArrayList<AthleteItemResponse> getAthletes() {
        return Athletes;
    }

    public void setAthletes(ArrayList<AthleteItemResponse> athletes) {
        Athletes = athletes;
    }
}
