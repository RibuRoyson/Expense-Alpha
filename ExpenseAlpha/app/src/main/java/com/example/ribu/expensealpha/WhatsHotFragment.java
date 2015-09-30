package com.example.ribu.expensealpha;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by ribu on 23-Sep-15.
 */
public class WhatsHotFragment extends Fragment {
ImageView img1,img2,img3,img4;

    public WhatsHotFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graphmain, container, false);
        img3=(ImageView)rootView.findViewById(R.id.imageviewcat);
        img2=(ImageView)rootView.findViewById(R.id.imageviewmonths);
        img1=(ImageView)rootView.findViewById(R.id.imageviewline);
        img4=(ImageView)rootView.findViewById(R.id.imageviewtotal);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Fragment  fragment = new CatwiseFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment  fragment = new Monthwise();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment  fragment = new DaywiseFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment  fragment = new TotalgraphFragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment).commit();
            }
        });
        return rootView;
    }
}
