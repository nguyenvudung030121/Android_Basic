package com.example.test_intenimplicit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txtV = findViewById(R.id.txtV);
        String getString = getIntent().getStringExtra("Content");
        txtV.setText(getString);
    }
}