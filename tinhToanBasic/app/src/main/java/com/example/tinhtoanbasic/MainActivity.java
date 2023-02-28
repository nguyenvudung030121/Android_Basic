package com.example.tinhtoanbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button_sum_OnClick,button_minus_OnClick, button_multiple_OnClick,button_div_OnClick;
    EditText editText1,editText2;
    TextView textView;

    void getView(){
        button_sum_OnClick = findViewById(R.id.button_Sum);
        button_minus_OnClick = findViewById(R.id.button_Minus);
        button_multiple_OnClick = findViewById(R.id.button_Multip);
        button_div_OnClick = findViewById(R.id.button_Div);
        editText1 = findViewById(R.id.edit_text1);
        editText2 = findViewById(R.id.edit_text2);
        textView = findViewById(R.id.text_view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();


        button_sum_OnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Float s1 = Float.parseFloat(editText1.getText().toString());
                    Float s2 = Float.parseFloat(editText2.getText().toString());
                    textView.setText(String.valueOf(s1+s2));
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }

            }
        });


        button_minus_OnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Float s1 = Float.parseFloat(editText1.getText().toString());
                    Float s2 = Float.parseFloat(editText2.getText().toString());
                    textView.setText(String.valueOf(s1-s2));
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
            }
        });
        button_multiple_OnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Float s1 = Float.parseFloat(editText1.getText().toString());
                    Float s2 = Float.parseFloat(editText2.getText().toString());
                    textView.setText(String.valueOf(s1*s2));
                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
            }
        });
        button_div_OnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Float s1 = Float.parseFloat(editText1.getText().toString());
                    Float s2 = Float.parseFloat(editText2.getText().toString());
                    textView.setText(String.valueOf(s1*s2));

                } catch(NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
            }
        });

    }

}