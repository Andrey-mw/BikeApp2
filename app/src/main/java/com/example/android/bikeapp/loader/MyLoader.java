package com.example.android.bikeapp.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;

import com.example.android.bikeapp.db.DBQueryHelper;

/**
 * Created by Android on 11.11.2015.
 */
public class MyLoader extends AsyncTaskLoader<Cursor> {
    public MyLoader(Context context) {
        super(context);
    }

    @Override
    public Cursor loadInBackground() {
        DBQueryHelper helper = new DBQueryHelper(getContext());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return helper.allItems();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
