package com.creative.athletes.APIHandler;


import com.creative.athletes.APIHandler.Response.AthletesResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    /**
     * Getathletes call.
     * @return the call
     */
    @GET("athletes.josn")
    Call<AthletesResponse> getathletes();


}


