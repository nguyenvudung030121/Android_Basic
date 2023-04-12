package com.example.helloworld;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_Username;
    EditText edt_Password;
    Button btn_Login;

    void getView() {
        edt_Password = findViewById(R.id.password);
        edt_Username = findViewById(R.id.username);
        btn_Login = findViewById(R.id.loginButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);

        getView();



        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_Username.getText().toString();
                String password = edt_Password.getText().toString();

                Intent intent = new Intent(MainActivity.this,homePage.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);

                startActivity(intent);
            }
        });
    }


}