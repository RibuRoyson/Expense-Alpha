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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ribu on 23-Sep-15.
 */
public class FindPeopleFragment extends Fragment {
    TextView tv;
    int i = 0;
    String length;
    String results;
    Dbhandler dbh;
    Button b1, b2, b3;
    public FindPeopleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.totalpage, container, false);
        b1 = (Button) rootView.findViewById(R.id.selectmnth);
        registerForContextMenu(b1);
        tv = (TextView) rootView.findViewById(R.id.monthtotal);
        b2 = (Button) rootView.findViewById(R.id.total);
        b3 = (Button) rootView.findViewById(R.id.monthclick);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new Dbhandler(getActivity());
                int x = dbh.total();
                tv.setText("\u20B9" + "."+"" + x);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh = new Dbhandler(getActivity());
                int y = dbh.totalmnth();
                tv.setText("\u20B9" + "."+"" + y);

            }
        });
        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.month, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.janu: {
                i = 1;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                Log.e("arraylist length", "" + length);
                if (results == null || results.isEmpty()) {
                    Toast.makeText(getActivity(), "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    tv.setText("\u20B9" + "."+""+results);

                }
                break;
            }
            case R.id.feb: {
                i = 2;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));

                Log.e("arraylist length", "" + length);
                if (length == "") {
                    Toast.makeText(getActivity(), "Database Empty", Toast.LENGTH_LONG).show();
                } else {
                    tv.setText("\u20B9" + "."+""+results);
                }
                break;
            }
            case R.id.mar: {
                i = 3;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);

                break;
            }
            case R.id.apr: {
                i = 4;
                Dbhandler dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);

                break;
            }
            case R.id.may: {
                i = 5;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);

                break;
            }
            case R.id.jun: {
                i = 6;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);
                break;
            }
            case R.id.jul: {
                i = 7;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);
                break;
            }
            case R.id.aug: {
                i = 8;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);
                break;
            }
            case R.id.sep: {
                i = 9;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);
                break;
            }
            case R.id.oct: {
                i = 10;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);
                break;
            }
            case R.id.nov: {
                i = 11;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                tv.setText("\u20B9" + "."+""+results);
                break;
            }
            case R.id.dec: {
                i = 12;
                dbh = new Dbhandler(getActivity());
                results = String.valueOf(dbh.monthdatatotal(i));
                try {
                    if (results != null) {
                        tv.setText("\u20B9" + "."+""+results);
                        break;
                    } else {
                        Toast.makeText(getActivity(), "No Entry", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return super.onContextItemSelected(item);
    }


}
