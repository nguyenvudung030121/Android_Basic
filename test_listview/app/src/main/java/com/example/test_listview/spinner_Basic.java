package com.example.test_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class spinner_Basic extends AppCompatActivity {
    Spinner spinner;
    ArrayList arr_class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_basic);
        spinner = findViewById(R.id.spinner_basic);
        arr_class = new ArrayList();
        arr_class.add("Java");
        arr_class.add("Android");
        arr_class.add("PHP");
        arr_class.add("C#");
        arr_class.add("VB.NET");

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr_class);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(spinner_Basic.this,spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}