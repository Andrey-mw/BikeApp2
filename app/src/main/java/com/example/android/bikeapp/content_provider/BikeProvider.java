package com.example.android.bikeapp.content_provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.android.bikeapp.db.DBHelper;

import java.util.HashMap;

/**
 * Created by Android on 12.11.2015.
 */
public class BikeProvider extends ContentProvider {

    private DBHelper dbHelper;

    private static final int USERS = 1;
    private static final int USERS_ID = 2;

    private static HashMap<String, String> sUsersProjectionMap;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(BikeContract.AUTHORITY, "users", USERS);
        uriMatcher.addURI(BikeContract.AUTHORITY, "users/#", USERS_ID);

        sUsersProjectionMap = new HashMap<String, String>();
        for (int i = 0; i < BikeContract.Users.DEFAULT_PROJECTION.length; i++) {
            sUsersProjectionMap.put(
                    BikeContract.Users.DEFAULT_PROJECTION[i],
                    BikeContract.Users.DEFAULT_PROJECTION[i]);
        }
    }

    @Override
    public boolean onCreate() {
        dbHelper = new DBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
