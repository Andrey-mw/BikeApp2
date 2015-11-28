package com.example.android.bikeapp.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.bikeapp.MainActivity;
import com.example.android.bikeapp.UpDateActivity;


/**
 * Created by Android on 11.11.2015.
 */
public class DBQueryHelper {

    public MainActivity activity;
    public UpDateActivity upDateActivity;
    public Context context;


    public static final String[] ALL_COLUMNS = {DBHelper._ID, DBHelper.FIRST_NAME, DBHelper.SECOND_NAME, DBHelper.AGE, DBHelper.MODEL_BIKE};
    public SQLiteDatabase database;
    public SQLiteOpenHelper openHelper;

    public DBQueryHelper(Context context) {
        openHelper = new DBHelper(context);
        try {
            database = openHelper.getWritableDatabase();
        } catch (SQLiteException e) {
            database = openHelper.getReadableDatabase();
        }
    }

    public void closeDB() {
        if (openHelper != null)
            openHelper.close();
    }

    public Cursor allItems() {
        return database.query(DBHelper.TABLE_NAME, ALL_COLUMNS, null, null, null, null, null);
    }


    public void delete() {
        database.delete(DBHelper.TABLE_NAME, null, null);
    }

    public Cursor getFilteredItemsMODEL_BIKE(String name) {
        return database.query(DBHelper.TABLE_NAME, ALL_COLUMNS, DBHelper.MODEL_BIKE + " LIKE ?", new String[]{"%" + name + "%"},
                null, null, null);
    }

    public Cursor getFilteredItemsFIRST_NAME(String name) {
        return database.query(DBHelper.TABLE_NAME, ALL_COLUMNS, DBHelper.FIRST_NAME + " LIKE ?", new String[]{"%" + name + "%"},
                null, null, null);
    }

    public Cursor getFilteredItemsSECOND_NAME(String name) {
        return database.query(DBHelper.TABLE_NAME, ALL_COLUMNS, DBHelper.SECOND_NAME + " LIKE ?", new String[]{"%" + name + "%"},
                null, null, null);
    }

    public Cursor getFilteredItemsAGE(String name) {
        return database.query(DBHelper.TABLE_NAME, ALL_COLUMNS, DBHelper.AGE + " LIKE ?", new String[]{"%" + name + "%"},
                null, null, null);
    }


}
