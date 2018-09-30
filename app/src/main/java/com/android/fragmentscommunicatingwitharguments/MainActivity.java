package com.android.fragmentscommunicatingwitharguments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.fragmentscommunicatingwitharguments.myFragments.FragmentOne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentOne fragmentOne = FragmentOne.newInstanceOf("Ayman", 30);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragmentOne)
                    .commit();
        }

    }
}
