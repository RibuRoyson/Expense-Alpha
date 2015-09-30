package com.example.ribu.expensealpha.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ribu.expensealpha.R;
import com.example.ribu.expensealpha.details;

import java.util.ArrayList;

/**
 * Created by ribu on 24-Sep-15.
 */
public class UserAdaptercat extends ArrayAdapter<details> {
    ArrayList<details> userslist;
    Context myContext;


    public UserAdaptercat(Context context, ArrayList<details> userlist) {
        super(context, R.layout.list_itemcat, userlist);
        this.userslist = userlist;
        this.myContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mlayoutInflater = LayoutInflater.from(myContext);
            convertView = mlayoutInflater.inflate(R.layout.list_itemcat, parent, false);
        }

        TextView expen = (TextView) convertView.findViewById(R.id.textexp2);

        TextView desc = (TextView) convertView.findViewById(R.id.textdes4);
        TextView tim = (TextView) convertView.findViewById(R.id.texttime5);
        TextView dat = (TextView) convertView.findViewById(R.id.textdate6);
        expen.setText(userslist.get(position).getExpense());
        desc.setText(userslist.get(position).getDescription());
        tim.setText(userslist.get(position).getTime1());
        dat.setText(userslist.get(position).getDate1());

        return convertView;
    }
}