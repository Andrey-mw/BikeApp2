package com.example.android.bikeapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.bikeapp.R;
import com.example.android.bikeapp.db.DBHelper;

/**
 * Created by Android on 11.11.2015.
 */
public class MyCursorAdapter extends CursorAdapter {
    public MyCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false);
        TextView txt_FIRST_NAME = (TextView) view.findViewById(R.id.txt_FIRST_NAME);
        TextView txt_SECOND_NAME = (TextView) view.findViewById(R.id.txt_SECOND_NAME);
        TextView txt_AGE = (TextView) view.findViewById(R.id.txt_AGE);
        TextView txt_MODEL_BIKE = (TextView) view.findViewById(R.id.txt_MODEL_BIKE);
        TextView txt_ID = (TextView) view.findViewById(R.id.txt_ID);
        view.setTag(new ViewHolder(txt_FIRST_NAME, txt_SECOND_NAME, txt_AGE, txt_MODEL_BIKE, txt_ID));
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();

        TextView txt_FIRST_NAME = holder.getTxt_FIRST_NAME();
        TextView txt_SECOND_NAME = holder.getTxt_SECOND_NAME();
        TextView txt_AGE = holder.getTxt_AGE();
        TextView txt_MODEL_BIKE = holder.getTxt_MODEL_BIKE();
        TextView txt_ID = holder.getTxt_ID();

        txt_FIRST_NAME.setText(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.FIRST_NAME)));
        txt_SECOND_NAME.setText(cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.SECOND_NAME)));
        txt_AGE.setText("Возраст: " + cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.AGE)));
        txt_MODEL_BIKE.setText("Модель вела: " + cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.MODEL_BIKE)));
        txt_ID.setText("ID: " + cursor.getString(cursor.getColumnIndexOrThrow(DBHelper._ID)));
    }

    private static class ViewHolder {
        public TextView getTxt_FIRST_NAME() {
            return txt_FIRST_NAME;
        }

        public TextView getTxt_SECOND_NAME() {
            return txt_SECOND_NAME;
        }

        public TextView getTxt_AGE() {
            return txt_AGE;
        }

        public TextView getTxt_MODEL_BIKE() {
            return txt_MODEL_BIKE;
        }

        public TextView getTxt_ID() {
            return txt_ID;
        }

        public final TextView txt_FIRST_NAME;
        public final TextView txt_SECOND_NAME;
        public final TextView txt_AGE;
        public final TextView txt_MODEL_BIKE;
        public final TextView txt_ID;


        private ViewHolder(TextView txt_FIRST_NAME, TextView txt_SECOND_NAME, TextView txt_AGE, TextView txt_MODEL_BIKE, TextView txt_ID) {
            this.txt_FIRST_NAME = txt_FIRST_NAME;
            this.txt_SECOND_NAME = txt_SECOND_NAME;
            this.txt_AGE = txt_AGE;
            this.txt_MODEL_BIKE = txt_MODEL_BIKE;
            this.txt_ID = txt_ID;
        }
    }
}
