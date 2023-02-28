package com.example.test_intenimplicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button send,call;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = (Button) findViewById(R.id.send_btn);
        call= findViewById(R.id.call_btn);
        editText = findViewById(R.id.edittext);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = String.valueOf(editText.getText());
                Intent intent = new Intent(MainActivity.this,second.class);
                intent.putExtra("Content",text);
                startActivity(intent);
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_CALL);
                getIntent().setData(Uri.parse("tel:0833733599"));
                startActivity(intent2);
            }
        });

    }
}