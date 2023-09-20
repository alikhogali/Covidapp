package com.example.covid19app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilitestracker {

    public static Retrofit retrofit=null;

    public static TrackerInterface getTrackerInterface(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(TrackerInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit.create(TrackerInterface.class);
    }


}
