package com.example.android.bikeapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.bikeapp.adapter.MyCursorAdapter;
import com.example.android.bikeapp.db.DBQueryHelper;
import com.example.android.bikeapp.loader.MyLoader;
import com.example.android.bikeapp.rest.RestActivity;
import com.example.android.bikeapp.volley.VolleyActivity;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public CheckBox checkFirsName, checkSecondName, checkAge, checkModelBike;
    private ListView listView;
    private MyCursorAdapter adapter;
    public EditText search, etID;
    private Button add, delete, upDate;
    private DBQueryHelper helper;
    private MyLoader loader;
    public String TAG = "Service";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentRest = new Intent(this,VolleyActivity.class);
        startActivity(intentRest);

//        Intent intentRest = new Intent(this,RestActivity.class);
//        startActivity(intentRest);




//        for (int i = 0; i < 10; i++) {
//            Intent intent = new Intent(this, MyService.class);
//            intent.putExtra("name", String.valueOf(i));
//            startService(intent);
//        }
//        Log.i(TAG, "onCreate in MainActivity");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        checkFirsName = (CheckBox) findViewById(R.id.check_FIRST_NAME);
        checkSecondName = (CheckBox) findViewById(R.id.check_SECOND_NAME);
        checkAge = (CheckBox) findViewById(R.id.check_AGE);
        checkModelBike = (CheckBox) findViewById(R.id.check_MODEL_BIKE);

        search = (EditText) findViewById(R.id.search);
        etID = (EditText) findViewById(R.id.et_ID);
        add = (Button) findViewById(R.id.btnSave);
        delete = (Button) findViewById(R.id.btnDelete);
        upDate = (Button) findViewById(R.id.btnUpDate);

        listView = (ListView) findViewById(R.id.listView);
        helper = new DBQueryHelper(this);

        adapter = new MyCursorAdapter(this, null, true);
        getLoaderManager().initLoader(0, null, this);

        adapter.setFilterQueryProvider(new FilterQueryProvider() {
            @Override
            public Cursor runQuery(CharSequence constraint) {
                if (checkFirsName.isChecked()) {

                    return helper.getFilteredItemsFIRST_NAME(constraint.toString());

                } else if (checkSecondName.isChecked()) {

                    return helper.getFilteredItemsSECOND_NAME(constraint.toString());

                } else if (checkAge.isChecked()) {

                    return helper.getFilteredItemsAGE(constraint.toString());

                } else if (checkModelBike.isChecked()) {

                    return helper.getFilteredItemsMODEL_BIKE(constraint.toString());
                }

                return helper.getFilteredItemsMODEL_BIKE(constraint.toString());
            }
        });
        listView.setAdapter(adapter);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void onClickAdd(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAdd:
                intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;

            case R.id.btnDelete:
                helper.delete();
                break;

            case R.id.btnUpDate:
                String id = etID.getText().toString();
                if (id.equalsIgnoreCase("")) {
                    Toast.makeText(this, "Enter id", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(this, UpDateActivity.class);
                    startActivity(intent);
                }

                break;

            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        helper.closeDB();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        loader = new MyLoader(this);
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);

    }
}
