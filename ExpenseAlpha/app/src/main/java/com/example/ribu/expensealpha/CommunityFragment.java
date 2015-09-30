package com.example.ribu.expensealpha;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribu.expensealpha.Adapter.UserAdaptermon;

import java.util.ArrayList;

/**
 * Created by ribu on 23-Sep-15.
 */
public class CommunityFragment extends Fragment {
    ListView lvv;
    Dbhandler dbh;
    int i = 0;
    int length;
    UserAdaptermon myuser;
    TextView exp,cat,desc,tim,dat;
    public CommunityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.monthwise, container, false);
        Button monbut = (Button) rootView.findViewById(R.id.monbut);
        exp=(TextView)rootView.findViewById(R.id.exptxtt);
        cat=(TextView)rootView.findViewById(R.id.cattxt);
        desc=(TextView)rootView.findViewById(R.id.desctxt);
        tim=(TextView)rootView.findViewById(R.id.timetxt);
        dat=(TextView)rootView.findViewById(R.id.datetxt);
        registerForContextMenu(monbut);
        lvv = (ListView) rootView.findViewById(R.id.list1);
        return rootView;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        switch (item.getItemId()) {
            case R.id.janu: {
                i = 1;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> results = new ArrayList<details>();
                results = dbh.monthdata(i);
                length = results.size();
                Log.e("arraylist length", "" + length);
                if (length == 0) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(1));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.feb: {
                i = 2;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(2));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.mar: {
                i = 3;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(3));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.apr: {
                i = 4;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(4));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.may: {
                i = 5;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(5));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.jun: {
                i = 6;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(6));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.jul: {
                i = 7;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(7));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.aug: {
                i = 8;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(8));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.sep: {
                i = 9;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(9));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.oct: {
                i = 10;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(10));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.nov: {
                i = 11;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(11));
                    lvv.setAdapter(myuser);
                }
                break;
            }
            case R.id.dec: {
                i = 12;
                Dbhandler dbh = new Dbhandler(getActivity());
                ArrayList<details> result = new ArrayList<details>();
                result = dbh.monthdata(i);
                if (result.isEmpty() == true) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exp.setText(R.string.exp);
                    cat.setText("Category");
                    desc.setText("Description");
                    tim.setText("Time");
                    dat.setText("Date");
                    myuser = new UserAdaptermon(getActivity(), dbh.monthdata(12));
                    lvv.setAdapter(myuser);
                }
                break;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.month, menu);
    }

}
