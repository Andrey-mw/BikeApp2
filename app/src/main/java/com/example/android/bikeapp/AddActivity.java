package com.example.android.bikeapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.bikeapp.db.DBHelper;

/**
 * Created by Android on 11.11.2015.
 */
public class AddActivity extends AppCompatActivity {
    private EditText Surname;
    private EditText Name;
    private EditText Age;
    private EditText BikeModel;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);

        Surname = (EditText) findViewById(R.id.editSurname);
        Name = (EditText) findViewById(R.id.editName);
        Age = (EditText) findViewById(R.id.editAge);
        BikeModel = (EditText) findViewById(R.id.editBike_Model);
        btnSave = (Button) findViewById(R.id.btnSave);

    }

    public void addItem(SQLiteDatabase db) {

        ContentValues cv = new ContentValues();

        cv.put(DBHelper.FIRST_NAME, Surname.getText().toString());
        cv.put(DBHelper.SECOND_NAME, Name.getText().toString());
        cv.put(DBHelper.AGE, Age.getText().toString());
        cv.put(DBHelper.MODEL_BIKE, BikeModel.getText().toString());
        db.insert(DBHelper.TABLE_NAME, null, cv);
        Toast.makeText(this, "Item add", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) {
        SQLiteOpenHelper sqLiteOpenHelper;
        SQLiteDatabase database;
        sqLiteOpenHelper = new DBHelper(this);
        database = sqLiteOpenHelper.getReadableDatabase();
        addItem(database);
    }
}
