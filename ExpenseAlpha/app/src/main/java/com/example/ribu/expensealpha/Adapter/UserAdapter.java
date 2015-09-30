package com.example.ribu.expensealpha.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ribu.expensealpha.EditData;
import com.example.ribu.expensealpha.R;
import com.example.ribu.expensealpha.details;

import java.util.ArrayList;

/**
 * Created by ribu on 24-Sep-15.
 */
public class UserAdapter extends ArrayAdapter<details> {
    ArrayList<String> object = new ArrayList<String>();
    ArrayList<details> userslist;
    Context myContext;


    public UserAdapter(Context context, ArrayList<details> userlist) {
        super(context, R.layout.list_item, userlist);
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

    private View getCustomView(final int position, View convertView, final ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mlayoutInflater = LayoutInflater.from(myContext);
            convertView = mlayoutInflater.inflate(R.layout.list_item, parent, false);
        }

        TextView expen = (TextView) convertView.findViewById(R.id.textexp2);
        TextView cat = (TextView) convertView.findViewById(R.id.textcat3);
        TextView desc = (TextView) convertView.findViewById(R.id.textdes4);
        TextView tim = (TextView) convertView.findViewById(R.id.texttime5);
        TextView dat = (TextView) convertView.findViewById(R.id.textdate6);
        expen.setText(userslist.get(position).getExpense());
        cat.setText(userslist.get(position).getCat());
        desc.setText(userslist.get(position).getDescription());
        tim.setText(userslist.get(position).getTime1());
        dat.setText(userslist.get(position).getDate1());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getContext(), EditData.class);

                i.putExtra("id", userslist.get(position).getId());
                i.putExtra("expense", userslist.get(position).getExpense());
                i.putExtra("cat", userslist.get(position).getCat());
                i.putExtra("description", userslist.get(position).getDescription());
                i.putExtra("time", userslist.get(position).getTime1());
                i.putExtra("date", userslist.get(position).getDate1());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                myContext.startActivity(i);


            }
        });
        return convertView;

    }


}
