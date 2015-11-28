package com.example.android.bikeapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Android on 11.11.2015.
 */
public class DBHelper extends SQLiteOpenHelper implements BaseColumns {

    public static final String DATA_NAME = "bike.db";
    public static final int DATA_VERSION = 4;
    public static final String TABLE_NAME = "users";
    public static final String FIRST_NAME = "first_name";
    public static final String SECOND_NAME = "second_name";
    public static final String AGE = "age";
    public static final String MODEL_BIKE = "model_bike";


    private static final String DATABASE_CREATE_SCRIPT = "create table " + TABLE_NAME + " ( "
            + _ID + " INTEGER primary key autoincrement, "
            + FIRST_NAME + " TEXT, "
            + SECOND_NAME + " TEXT, "
            + AGE + " INTEGER, "
            + MODEL_BIKE + " TEXT);";


    public DBHelper(Context context) {
        super(context, DATA_NAME, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        addData(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public void addData(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();

        cv.put(FIRST_NAME, "Александров");
        cv.put(SECOND_NAME, "Андрей");
        cv.put(AGE, 20);
        cv.put(MODEL_BIKE, "Rover");
        db.insert(TABLE_NAME, null, cv);
        cv.clear();

        cv.put(FIRST_NAME, "Иванов");
        cv.put(SECOND_NAME, "Саня");
        cv.put(AGE, 22);
        cv.put(MODEL_BIKE, "Grant");
        db.insert(TABLE_NAME, null, cv);
        cv.clear();

        cv.put(FIRST_NAME, "Попов");
        cv.put(SECOND_NAME, "Иван");
        cv.put(AGE, 21);
        cv.put(MODEL_BIKE, "Ukraina");
        db.insert(TABLE_NAME, null, cv);
        cv.clear();

        cv.put(FIRST_NAME, "Мажор");
        cv.put(SECOND_NAME, "Сергей");
        cv.put(AGE, 26);
        cv.put(MODEL_BIKE, "Rover");
        db.insert(TABLE_NAME, null, cv);
        cv.clear();

        cv.put(FIRST_NAME, "Александров");
        cv.put(SECOND_NAME, "Антон");
        cv.put(AGE, 20);
        cv.put(MODEL_BIKE, "BMX");
        db.insert(TABLE_NAME, null, cv);

    }


}
