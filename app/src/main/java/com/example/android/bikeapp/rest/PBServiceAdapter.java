package com.example.android.bikeapp.rest;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Android on 26.11.2015.
 */
public class PBServiceAdapter {

    private static final String BASE_URL = "https://api.privatbank.ua";
    private PBService service;

    public PBServiceAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PBService.class);
    }

    public PBService getService() {
        return service;
    }
}
