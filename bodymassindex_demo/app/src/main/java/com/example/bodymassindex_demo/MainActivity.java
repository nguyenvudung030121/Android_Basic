package com.example.bodymassindex_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button_onclick;
    TextView textView_result;
    EditText editText_w, editText_h;

    void getView() {
        button_onclick = findViewById(R.id.button);
        textView_result = findViewById(R.id.textview_result);
        editText_h = findViewById(R.id.edittext_h);
        editText_w = findViewById(R.id.edittext_w);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        button_onclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float weight = Float.parseFloat(editText_w.getText().toString());
                    float height = Float.parseFloat(editText_h.getText().toString());
                    float result = (float) Math.floor((weight / Math.pow(height, 2)) * 100) / 100 ;

                    if (result < 18){
                        textView_result.setText(String.valueOf(result)+" || Người gầy");
                    }else if(result <24.9){
                        textView_result.setText(String.valueOf(result)+" || Người bình thường");
                    }else if(result < 29.9){
                        textView_result.setText(String.valueOf(result)+" || Béo phì độ I");
                    }else if (result < 34.9){
                        textView_result.setText(String.valueOf(result)+" || Béo phì độ II");
                    }else {
                        textView_result.setText(String.valueOf(result)+" || Béo phì độ III");
                    }


                } catch (NumberFormatException e) {
                    System.out.println("Khong te Parse" + e);
                }
            }
        });


    }
}