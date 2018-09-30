package com.android.fragmentscommunicatingwitharguments.myFragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.fragmentscommunicatingwitharguments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    private String name;
    private int age;

    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    public static FragmentOne newInstanceOf(String name, int age) {
        FragmentOne fragmentOne = new FragmentOne();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putInt("age", age);
        fragmentOne.setArguments(args);
        return fragmentOne;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name=getArguments().getString("name"," ");
        age=getArguments().getInt("age",0);

        TextView greatTxt=view.findViewById(R.id.greatingMsg);
        String great = "Welcome to fragment " + name + " Your Age is " + age;
        greatTxt.setText(great);
    }
}
