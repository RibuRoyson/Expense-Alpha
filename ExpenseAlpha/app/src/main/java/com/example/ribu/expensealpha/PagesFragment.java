package com.example.ribu.expensealpha;

import android.app.Fragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ribu.expensealpha.Adapter.UserAdaptercat;

import java.util.ArrayList;

/**
 * Created by ribu on 23-Sep-15.
 */
public class PagesFragment extends Fragment {
    Dbhandler dbh;
    ArrayList<details> result;
    ListView lv;
    TextView drinkstxt,dresstxt,foodtxt,othertxt,personaltxt,utilitiestxt,fulltotal,exptxt,desctxt,tmtxt,dttxt;
    public PagesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.categorywisedata, container, false);
        Button catbut = (Button) rootView.findViewById(R.id.catbut);
        dbh=new Dbhandler(getActivity());
        lv = (ListView) rootView.findViewById(R.id.listView21);
        drinkstxt=(TextView)rootView.findViewById(R.id.drinkstotal);
        dresstxt=(TextView)rootView.findViewById(R.id.dresstotal);
        foodtxt=(TextView)rootView.findViewById(R.id.foodtotal);
        othertxt=(TextView)rootView.findViewById(R.id.othertotal);
        personaltxt=(TextView)rootView.findViewById(R.id.pertotal);
        utilitiestxt=(TextView)rootView.findViewById(R.id.utiltotal);
        fulltotal=(TextView)rootView.findViewById(R.id.fulltotoal);
        exptxt=(TextView)rootView.findViewById(R.id.exptxt);
        desctxt=(TextView)rootView.findViewById(R.id.desctxt);
        tmtxt=(TextView)rootView.findViewById(R.id.tmtxt);
        dttxt=(TextView)rootView.findViewById(R.id.dttxt);
        int a = dbh.categorytotal("Drinks");
        int b = dbh.categorytotal("Dress");
        int c1 = dbh.categorytotal("Food");
        int d = dbh.categorytotal("Others");
        int e = dbh.categorytotal("Personal");
        int f = dbh.categorytotal("Utilities");
        int g=a+b+c1+d+e+f;
        drinkstxt.setText("\u20B9" + "."+a+"");
        dresstxt.setText("\u20B9" + "."+b+"");
        foodtxt.setText("\u20B9" + "."+c1+"");
        othertxt.setText("\u20B9" + "."+d+"");
        personaltxt.setText("\u20B9" + "."+e+"");
        utilitiestxt.setText("\u20B9" + "."+f+"");
        fulltotal.setText("\u20B9" + "."+g+"");
        registerForContextMenu(catbut);
        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.category, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drinks:
                String d = "Drinks";
                dbh = new Dbhandler(getActivity());
                result = dbh.category(d);
                if (result == null || result.isEmpty()) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exptxt.setText(R.string.exp);
                    desctxt.setText("Description");
                    tmtxt.setText("Time");
                    dttxt.setText("Date");
                    lv.setAdapter(new UserAdaptercat(getActivity(), dbh.category(d)));
                }
                break;
            case R.id.dress:
                String c = "Dress";
                dbh = new Dbhandler(getActivity());
                result = dbh.category(c);
                if (result == null || result.isEmpty()) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exptxt.setText(R.string.exp);
                    desctxt.setText("Description");
                    tmtxt.setText("Time");
                    dttxt.setText("Date");
                    lv.setAdapter(new UserAdaptercat(getActivity(), dbh.category(c)));
                }
                break;
            case R.id.food:
                String f = "Food";
                dbh = new Dbhandler(getActivity());
                result = dbh.category(f);
                if (result == null || result.isEmpty()) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exptxt.setText(R.string.exp);
                    desctxt.setText("Description");
                    tmtxt.setText("Time");
                    dttxt.setText("Date");
                    lv.setAdapter(new UserAdaptercat(getActivity(), dbh.category(f)));
                }
                break;
            case R.id.others:
                String o = "Others";
                dbh = new Dbhandler(getActivity());
                result = dbh.category(o);
                if (result == null || result.isEmpty()) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exptxt.setText(R.string.exp);
                    desctxt.setText("Description");
                    tmtxt.setText("Time");
                    dttxt.setText("Date");
                    lv.setAdapter(new UserAdaptercat(getActivity(), dbh.category(o)));
                }
                break;
            case R.id.personal:
                String p = "Personal";
                dbh = new Dbhandler(getActivity());
                result = dbh.category(p);
                if (result == null || result.isEmpty()) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exptxt.setText(R.string.exp);
                    desctxt.setText("Description");
                    tmtxt.setText("Time");
                    dttxt.setText("Date");
                    lv.setAdapter(new UserAdaptercat(getActivity(), dbh.category(p)));
                }
                break;
            case R.id.utilities:
                String u = "Utilities";
                dbh = new Dbhandler(getActivity());
                result = dbh.category(u);
                if (result == null || result.isEmpty()) {
                    Toast.makeText(getActivity(), "No Records Found!", Toast.LENGTH_LONG).show();
                } else {
                    exptxt.setText(R.string.exp);
                    desctxt.setText("Description");
                    tmtxt.setText("Time");
                    dttxt.setText("Date");
                    lv.setAdapter(new UserAdaptercat(getActivity(), dbh.category(u)));
                }
                break;
        }
        return super.onContextItemSelected(item);
    }
}