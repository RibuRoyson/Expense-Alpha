package com.example.ribu.expensealpha.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by ribu on 24-Sep-15.
 */
public class CustomArrayAdapter<String> extends ArrayAdapter {
    public CustomArrayAdapter(Context ctx, String[] objects) {
        super(ctx, android.R.layout.simple_spinner_item, objects);
    }

    //other constructors

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        //we know that simple_spinner_item has android.R.id.text1 TextView:

        /* if(isDroidX) {*/
        TextView text = (TextView) view.findViewById(android.R.id.text1);
        text.setTextColor(Color.BLACK);//choose your color :)
        /*}*/

        return view;

    }
}