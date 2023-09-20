package com.example.covid19app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrackerInterface {

    String BASE_URL="https://corona.lmao.ninja/v2/";

    @GET("countries")
    Call<List<ModelClasstracker>> getcountrydata();

}
