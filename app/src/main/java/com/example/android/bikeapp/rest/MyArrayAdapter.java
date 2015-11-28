package com.example.android.bikeapp.rest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.bikeapp.R;

import java.util.List;

/**
 * Created by Android on 26.11.2015.
 */
public class MyArrayAdapter extends BaseAdapter {

    private List<CurrencyInfo> myList;
    private Context context;

    public MyArrayAdapter(List<CurrencyInfo> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView ccy;
        TextView buy;
        TextView sale;


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.single_currency_row, parent, false);
            ccy = (TextView) convertView.findViewById(R.id.ccy);
            buy = (TextView) convertView.findViewById(R.id.buy);
            sale = (TextView) convertView.findViewById(R.id.sale);

            convertView.setTag(new ViewHolder(ccy, buy, sale));

        } else {

            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            ccy = viewHolder.ccy;
            buy = viewHolder.buy;
            sale = viewHolder.sale;

        }

        CurrencyInfo example = (CurrencyInfo) getItem(position);

        ccy.setText(example.getCcy());
        buy.setText(example.getBuy());
        sale.setText(example.getSale());

        return convertView;

    }

    private class ViewHolder {
        private final TextView ccy;
        private final TextView buy;
        private final TextView sale;


        public ViewHolder(TextView ccy, TextView buy, TextView sale) {
            this.ccy = ccy;
            this.buy = buy;
            this.sale = sale;

        }

        public TextView getCcy() {
            return ccy;
        }

        public TextView getBuy() {
            return buy;
        }

        public TextView getSale() {
            return sale;
        }
    }

    public void setData(List<CurrencyInfo> list) {
        if (myList == null) {
            myList = list;
        } else {
            myList.addAll(list);
        }
    }
}
