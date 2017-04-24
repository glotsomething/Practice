package com.example.minji.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    String[] items= {"SM3", "SM5", "SM7", "SONATA","aVANTE","SOUL","K5","K7"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView edit = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        edit.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,items));
    }
}
