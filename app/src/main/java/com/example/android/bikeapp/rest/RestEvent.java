package com.example.android.bikeapp.rest;

import java.util.List;

/**
 * Created by Android on 26.11.2015.
 */
public class RestEvent {

    private List<CurrencyInfo> currencyInfos;

    public List<CurrencyInfo> getCurrencyInfos() {
        return currencyInfos;
    }

    public RestEvent(List<CurrencyInfo> currencyInfos) {

        this.currencyInfos = currencyInfos;
    }
}
