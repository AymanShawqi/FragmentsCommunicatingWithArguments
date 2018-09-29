package com.android.fragmentscommunicatingwitharguments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.fragmentscommunicatingwitharguments.myFragments.FragmentOne;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String name;
    private int age;
    private EditText nameEdtTxt;
    private EditText ageEdtTxt;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdtTxt=findViewById(R.id.name_id);
        ageEdtTxt=findViewById(R.id.age_id);

        Button  submitBtn=findViewById(R.id.submit);
        submitBtn.setOnClickListener(this) ;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                handleSubmit();
                break;
        }
    }

    void handleSubmit(){

        name=nameEdtTxt.getText().toString();
        String ageStr=ageEdtTxt.getText().toString();
        if (!ageStr.isEmpty()){
            age=Integer.parseInt(ageStr);
        }
        FragmentOne fragmentOne=FragmentOne.newInstanceOf(name,age);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,fragmentOne)
                .commit();
    }
}
