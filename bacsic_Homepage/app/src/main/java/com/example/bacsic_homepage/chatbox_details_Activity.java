package com.example.bacsic_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class chatbox_details_Activity extends AppCompatActivity {
    ImageButton btn_Chatbox_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.chatbox_details);
        btn_Chatbox_back = findViewById(R.id.btn_back_chatbox);

        btn_Chatbox_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(chatbox_details_Activity.this,chatbox_Activity.class);
                startActivity(intent);
            }
        });
    }
}