package com.example.android.bikeapp.rest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.bikeapp.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Android on 26.11.2015.
 */
public class RestActivity extends Activity {

    private ListView listResult;
    private MyArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        listResult = (ListView) findViewById(R.id.list_result_rest);
        arrayAdapter = new MyArrayAdapter(new ArrayList<CurrencyInfo>(), this);
        listResult.setAdapter(arrayAdapter);
        Intent intent = new Intent(RestActivity.this, RestService.class);
        startService(intent);


    }


    @Override
    protected void onResume() {
        super.onResume();
        EDBus.getBusInstance().register(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        EDBus.getBusInstance().unregister(this);

    }

    @Subscribe
    public void dataNew(RestEvent event) {
        arrayAdapter.setData(event.getCurrencyInfos());
        arrayAdapter.notifyDataSetChanged();
    }
}
