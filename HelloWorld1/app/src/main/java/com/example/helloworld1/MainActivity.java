package com.example.helloworld1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonOnClick;
    EditText editText;
    TextView textView;

    void getView(){
        buttonOnClick = findViewById(R.id.buttonClick);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        buttonOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });}



}