package com.example.bacsic_homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class notification_details_Activity extends AppCompatActivity {


    ImageButton btn_Back;

    void getView(){
        btn_Back =  findViewById(R.id.btn_back);

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.notification_details);
        getView();
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notification_details_Activity.this,notification_Activity.class);
                startActivity(intent);
            }
        });
    }
}