package com.example.android.bikeapp.rest;

import android.app.IntentService;
import android.content.Intent;

import java.io.IOException;
import java.util.List;

import retrofit.Response;

/**
 * Created by Android on 26.11.2015.
 */
public class RestService extends IntentService {
    private PBServiceAdapter pbServiceAdapter = new PBServiceAdapter();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public RestService() {
        super("rest");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Response<List<CurrencyInfo>> response = pbServiceAdapter.getService().getContent().execute();
            EDBus.getBusInstance().post(new RestEvent(response.body()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
