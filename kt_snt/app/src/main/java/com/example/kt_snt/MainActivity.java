package com.example.kt_snt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button_Check;
    EditText editText;
    TextView textView;

    void getView(){
        button_Check = findViewById(R.id.button);
        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textview);
    }
    boolean check_snt(int n){
        if (n < 2){
            return  false  ;
        }else{
            int sokt = (int) Math.sqrt(n);
            for (int i = 2 ; i<=sokt ; i++){
                if (n % i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getView();
        button_Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int s1 = Integer.parseInt(editText.getText().toString());
                if (check_snt(s1)){
                    textView.setText(s1+" Là Số Nguyên Tố");
                }else{
                    textView.setText(s1 + " Không phải là số nguyên tố");
                }

            }
        });
    }
}