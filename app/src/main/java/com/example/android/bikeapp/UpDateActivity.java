package com.example.android.bikeapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bikeapp.db.DBHelper;
import com.example.android.bikeapp.db.DBQueryHelper;

/**
 * Created by Android on 12.11.2015.
 */
public class UpDateActivity extends AppCompatActivity {
    public EditText Surname, Name, Age, BikeModel;
    public Button btnSave;
    public DBQueryHelper helper;
    public MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.up_date_layout);

        Surname = (EditText) findViewById(R.id.editSurname);
        Name = (EditText) findViewById(R.id.editName);
        Age = (EditText) findViewById(R.id.editAge);
        BikeModel = (EditText) findViewById(R.id.editBike_Model);
        btnSave = (Button) findViewById(R.id.btnUpDate);

    }

    public void onClickUpDate(View view) {
        SQLiteOpenHelper sqLiteOpenHelper;
        SQLiteDatabase db;
        sqLiteOpenHelper = new DBHelper(this);
        db = sqLiteOpenHelper.getReadableDatabase();
        upDate(db);


    }

    public void upDate(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();
        String id = activity.etID.getText().toString();

        cv.put(DBHelper.FIRST_NAME, Surname.getText().toString());

        cv.put(DBHelper.SECOND_NAME, Name.getText().toString());

        cv.put(DBHelper.AGE, Age.getText().toString());

        cv.put(DBHelper.MODEL_BIKE, BikeModel.getText().toString());

        db.update(DBHelper.TABLE_NAME, cv, "id = " + id, null);
        Toast.makeText(this, "Item upDate", Toast.LENGTH_LONG).show();


    }
}

