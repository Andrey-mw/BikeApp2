package com.example.android.bikeapp.rest;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Android on 26.11.2015.
 */
public interface PBService {
    @GET("p24api/pubinfo?json&exchange&coursid=3")
    public Call<List<CurrencyInfo>> getContent();
}
