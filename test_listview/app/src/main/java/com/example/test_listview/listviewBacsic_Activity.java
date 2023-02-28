package com.example.test_listview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listviewBacsic_Activity extends AppCompatActivity {
    ListView lv_basic;
    String[] sdt = {"0833733599","012233456654","465564564566","54654654655645","456456465456564"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_bacsic);
        lv_basic = findViewById(R.id.lv_basic);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,sdt);
        lv_basic.setAdapter(adapter);
    }
}