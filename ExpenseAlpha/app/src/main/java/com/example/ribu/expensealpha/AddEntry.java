package com.example.ribu.expensealpha;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ribu.expensealpha.Adapter.CustomArrayAdapter;

import java.util.Calendar;

/**
 * Created by ribu on 24-Sep-15.
 */
public class AddEntry extends Fragment {
    Spinner sp;
    Button tim, dat, save, show;
    EditText expen, descpt;
    String expense, cat, des, date1, time1;
    Dbhandler dbh;
    int dy, mn, yr;
    String[] Languages = { "Select","Drinks", "Dress", "Food", "Others", "Personal", "Utilities" };

    Integer[] images = { 0, R.drawable.ic_launcher_drinks, R.drawable.ic_launcher_dress,
            R.drawable.ic_launcher_food, R.drawable.ic_launcher_other,R.drawable.ic_launcher_per,R.drawable.ic_launcher_utilities };
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.addnew, container, false);
        sp = (Spinner) rootView.findViewById(R.id.spinner1);
        tim = (Button) rootView.findViewById(R.id.timebtn);
        dat = (Button) rootView.findViewById(R.id.datebtn);
        save = (Button) rootView.findViewById(R.id.save);
        show = (Button) rootView.findViewById(R.id.show);
        expen = (EditText) rootView.findViewById(R.id.exp);
        descpt = (EditText) rootView.findViewById(R.id.desc);
        sp.setAdapter(new MyAdapter(getActivity(), R.layout.custom,
                Languages));

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cat = sp.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Process to get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                // Launch Date Picker Dialog
                DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                // Display Selected date in textbox
                                dat.setText(dayOfMonth + "-"
                                        + (monthOfYear + 1) + "-" + year);
                                dy = dayOfMonth;
                                mn = monthOfYear + 1;
                                yr = year;
                            }
                        }, mYear, mMonth, mDay);
                dpd.getDatePicker().setMaxDate(System.currentTimeMillis());
                dpd.show();
            }
        });

        tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Process to get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                // Display Selected time in textbox
                                tim.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);

                tpd.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expense = expen.getText().toString();
                des = descpt.getText().toString();
                time1 = tim.getText().toString();
                date1 = dat.getText().toString();
                if (expense.equals("")) {
                    Toast.makeText(getActivity(), "Enter a value as expense", Toast.LENGTH_SHORT).show();
                } else if (des.equals("")) {
                    Toast.makeText(getActivity(), "Enter a description", Toast.LENGTH_SHORT).show();
                } else if (time1.matches(".*\\d+.*") == false) {
                    Toast.makeText(getActivity(), "Enter a time", Toast.LENGTH_SHORT).show();
                } else if (date1.matches(".*\\d+.*") == false) {
                    Toast.makeText(getActivity(), "Enter a date", Toast.LENGTH_SHORT).show();
                }else if (cat.equals("Select"))                {
                    Toast.makeText(getActivity(), "Select a Category", Toast.LENGTH_SHORT).show();
                }
                else {
                    int id = -1;
                    details d = new details(id + "", expense, cat, des, time1, date1, dy, mn, yr);
                    d.setExpense(expense);
                    d.setCat(cat);
                    d.setDescription(des);
                    d.setTime1(time1);
                    d.setDate1(date1);
                    dbh = new Dbhandler(getActivity());
                    long g = dbh.insertdata(d);
                    if (g > 0) {
                        Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                    }
                    expen.setText("");
                    descpt.setText("");
                    tim.setText("TIME");
                    dat.setText("DATE");
                    sp.setSelection(0);

                }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new PhotosFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        });

        return rootView;
    }
    public class MyAdapter extends ArrayAdapter {

        public MyAdapter(Context context, int textViewResourceId,
                         String[] objects) {
            super(context, textViewResourceId, objects);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {

// Inflating the layout for the custom Spinner
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom, parent, false);

// Declaring and Typecasting the textview in the inflated layout
            TextView tvLanguage = (TextView) layout
                    .findViewById(R.id.tvLanguage);

// Setting the text using the array
            tvLanguage.setText(Languages[position]);

// Setting the color of the text
//            tvLanguage.setTextColor(Color.rgb(75, 180, 225));

// Declaring and Typecasting the imageView in the inflated layout
            ImageView img = (ImageView) layout.findViewById(R.id.imgLanguage);

// Setting an image using the id's in the array
            img.setImageResource(images[position]);

// Setting Special atrributes for 1st element
            if (position == 0) {
// Removing the image view
                img.setVisibility(View.GONE);
// Setting the size of the text
                tvLanguage.setTextSize(20f);
// Setting the text Color
                tvLanguage.setTextColor(Color.BLACK);

            }

            return layout;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }
    }
}
