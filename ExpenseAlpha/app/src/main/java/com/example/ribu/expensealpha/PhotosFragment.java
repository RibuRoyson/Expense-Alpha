package com.example.ribu.expensealpha;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribu.expensealpha.Adapter.UserAdapter;

import java.util.ArrayList;

/**
 * Created by ribu on 23-Sep-15.
 */
public class PhotosFragment extends Fragment {
    ArrayList<details> userslist;
    ListView lv;
    UserAdapter myuser;
    TextView exptxt,cattxt,decsxt,timtxt,dattxt;
    public PhotosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.view, container, false);
        lv = (ListView) rootView.findViewById(R.id.listView1);
        exptxt=(TextView)rootView.findViewById(R.id.expensetxt);
        cattxt=(TextView)rootView.findViewById(R.id.categorytxt);
        decsxt=(TextView)rootView.findViewById(R.id.descriptiontxt);
        timtxt=(TextView)rootView.findViewById(R.id.timetxt);
        dattxt=(TextView)rootView.findViewById(R.id.datetxt);
        Dbhandler dbh = new Dbhandler(getActivity());
        userslist = dbh.resultdata();
        myuser = new UserAdapter(getActivity(), userslist);
        if (myuser.isEmpty() == true) {
            Toast.makeText(getActivity(), "Sorry No Entry!!", Toast.LENGTH_LONG).show();
        } else {
            exptxt.setText(R.string.exp);
            cattxt.setText(R.string.cat);
            decsxt.setText(R.string.desc);
            timtxt.setText(R.string.time);
            dattxt.setText(R.string.date);
            lv.setAdapter(myuser);
        }
        dbh.close();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        myuser.notifyDataSetChanged();
        myuser.notifyDataSetInvalidated();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.editdel, menu);
        Toast.makeText(getActivity(), "Menu Created", Toast.LENGTH_SHORT).show();
        System.out.println("\n\n----------------------\n" + "menu created" + "\n\n--------------------------------");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        System.out.println("\n\n----------------------\n" + "menu selected" + "\n\n--------------------------------");

        switch (item.getItemId()) {

            case R.id.edit1:
                Toast.makeText(getActivity(), "Menu edited", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), EditData.class);
                i.putExtra("id", userslist.get(lv.getSelectedItemPosition()).getId());
                i.putExtra("expense", userslist.get(lv.getSelectedItemPosition()).getExpense());
                i.putExtra("cat", userslist.get(lv.getSelectedItemPosition()).getCat());
                i.putExtra("description", userslist.get(lv.getSelectedItemPosition()).getDescription());
                i.putExtra("time", userslist.get(lv.getSelectedItemPosition()).getTime1());
                i.putExtra("date", userslist.get(lv.getSelectedItemPosition()).getDate1());
                startActivity(i);

                break;
            case R.id.dele2:
                Toast.makeText(getActivity(), "Menu deleted", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}